package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.AdminLogin;
import com.example.demo.entity.Category;
import com.example.demo.entity.InsertQuestions;
import com.example.demo.entity.Levels;
import com.example.demo.entity.Questions;
import com.example.demo.exception.UserAlreadyExist;
import com.example.demo.service.Inter;
import com.example.demo.utility.CustomException;
import com.example.demo.utility.ResponseMessage;
import com.google.gson.Gson;

@Controller
public class MyController {

	@Autowired
	Inter dao;

	/*
	 * @RequestMapping(value="/getUsers", method = { RequestMethod.GET}) public
	 * ResponseEntity<List<Stri>> index(Model mol){
	 * mol.addAttribute("data","hello");
	 * System.out.println("inside the controller"); List<Mark> l= dao.getUsers();
	 * 
	 * for(Mark m:l) {
	 * System.out.println("the name ****************"+m.getProduct()); } return new
	 * ResponseEntity<>(l,org.springframework.http.HttpStatus.OK); }
	 */

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public @ResponseBody String ins() {

		/*
		 * Category c=new Category(); c.setCategory("dbz8");
		 * 
		 * List<Levels> l=new ArrayList<Levels>(); l.add(new Levels("goku",c));
		 * l.add(new Levels("picalo",c));
		 * 
		 * c.setItems(l);
		 * 
		 * dao.saveData(c);
		 */
		/*
		 * Levels l=new Levels(); l.setLevelCategory("level5"); l.setCategory(c);
		 */

		List<Category> t = dao.saveData(1);
		for (Levels h : t.get(0).getItems()) {
			for (Questions q : h.getQuestionsItem()) {
				System.out.println("the data is :" + q.getAnswer());
			}
		}
		return "success";
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Category>> addCategory(HttpServletRequest request, String category)
			throws CustomException {
		String header = request.getHeader("Accept");

		if (header.equalsIgnoreCase("application/json")) {
			List<Category> resp = null;
			if (category == null) {
				resp = dao.findCategory();
				return new ResponseEntity<List<Category>>(resp, null, HttpStatus.OK);
			}
			boolean response = dao.addCategory(category);
			if (!response) {
				throw new CustomException("Error inserting Data", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				resp = dao.findCategory();
			}

			return new ResponseEntity<List<Category>>(resp, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "removeCategory", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Category>> RemoveCategory(HttpServletRequest request, Integer category)
			throws CustomException {
		String header = request.getHeader("Accept");
		System.out.println("ID is " + category);
		if (header.equalsIgnoreCase("application/json")) {
			List<Category> resp = null;
			if (category == null) {
				resp = dao.findCategory();
				return new ResponseEntity<List<Category>>(resp, null, HttpStatus.OK);
			}
			boolean response = dao.removeCategory(category);
			System.out.println("Resp is " + response);
			if (!response) {
				throw new CustomException("Error removing Data", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				resp = dao.findCategory();
			}

			return new ResponseEntity<List<Category>>(resp, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "getCategory", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategory(HttpServletRequest request) throws CustomException {
		String header = request.getHeader("Accept");

		if (header.equalsIgnoreCase("application/json")) {
			List<Category> mCategory = dao.findCategory();
			return new ResponseEntity<List<Category>>(mCategory, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "getQuestions/{L_id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getQuestions(@PathVariable("L_id") int id, HttpServletRequest request)
			throws CustomException {
		String header = request.getHeader("Accept");

		if (header.equalsIgnoreCase("application/json")) {
			System.out.println("the header is " + header);

			List<Questions> ques = dao.findLevel(id);
			return new ResponseEntity<Object>(ques, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "getLevels/{l_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getLevels(@PathVariable("l_id") int id, HttpServletRequest httpServletRequest)
			throws CustomException {
		String header = httpServletRequest.getHeader("Accept");

		if (header.equalsIgnoreCase("application/json")) {
			List<Levels> lvl = dao.showLevel(id);
			return new ResponseEntity<Object>(lvl, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@RequestMapping(value = "signup", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<Object> doSignUp(@RequestParam("username") String Username,
			@RequestParam("password") String Password, @RequestParam("email") String Email,
			@RequestParam("phonenumber") String Phonenumber,
			@RequestParam(value = "role", defaultValue = "student") String Role) throws CustomException {
		try {
			AdminLogin adminLogin = new AdminLogin();
			adminLogin.setUsername(Username);
			adminLogin.setEmail(Email);
			adminLogin.setPassword(Password);
			adminLogin.setPhonenumber(Integer.parseInt(Phonenumber));
			adminLogin.setRole(Role);
			String dbResponse = dao.doSignUp(adminLogin);
			return new ResponseEntity<Object>(new ResponseMessage(dbResponse, 200), null, HttpStatus.OK);
		} catch (UserAlreadyExist e) {
			throw new CustomException(e.getLocalizedMessage(), HttpStatus.CONFLICT);
		}
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> getException(CustomException ex) {
		System.out.println("inside the CustomException");
		return new ResponseEntity<Object>(new ResponseMessage(ex.getLocalizedMessage(), ex.getHttpStatus().value()),
				null, ex.getHttpStatus());
	}

	@RequestMapping(value = "editCategory", method = RequestMethod.POST)
	public ResponseEntity<Object> editCategorybyValue(HttpServletRequest request, int id, String category)
			throws CustomException {
		String header = request.getHeader("Accept");
		if (header.equalsIgnoreCase("application/json")) {
			dao.editValue(id, category);
			return new ResponseEntity<Object>(new ResponseMessage("Success", 200), null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "editLevel", method = RequestMethod.POST)
	public ResponseEntity<Object> editLevelbyValue(HttpServletRequest request, int id, String levelCategory)
			throws CustomException {
		String header = request.getHeader("Accept");
		if (header.equalsIgnoreCase("application/json")) {
			dao.editLevelValue(id, levelCategory);
			return new ResponseEntity<Object>(new ResponseMessage("Success", 200), null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "removeLevel", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Levels>> RemoveLevel(HttpServletRequest request, Integer level)
			throws CustomException {
		String header = request.getHeader("Accept");
		System.out.println("Level ID is " + level);
		if (header.equalsIgnoreCase("application/json")) {
			List<Levels> resp = null;
			if (level == null) {
				resp = dao.showAllLevel();
				return new ResponseEntity<List<Levels>>(resp, null, HttpStatus.OK);
			}
			boolean response = dao.removeLevel(level);
			System.out.println("Resp is " + response);
			if (!response) {
				throw new CustomException("Error removing Data", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				resp = dao.showAllLevel();
			}

			return new ResponseEntity<List<Levels>>(resp, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "addQuestion", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<List<Category>> test(HttpServletRequest request, @RequestBody String str)
			throws CustomException {
		String header = request.getHeader("Accept");
		if (header.equalsIgnoreCase("application/json")) {
			Gson g = new Gson();
			InsertQuestions sIQ = g.fromJson(str, InsertQuestions.class);
			Questions qS = new Questions();
			for (int i = 0; i < sIQ.getItems().size(); i++) {
				qS.setLevel(new Levels(sIQ.getLevelId()));
				// qS.setId(sIQ.getCategoryId());
				List<Questions> liq = sIQ.getItems();
				qS.setChoice_a(liq.get(i).getChoice_a());
				qS.setChoice_b(liq.get(i).getChoice_b());
				qS.setChoice_c(liq.get(i).getChoice_c());
				qS.setChoice_d(liq.get(i).getChoice_d());
				qS.setQuestion(liq.get(i).getQuestion());
				qS.setAnswer((liq.get(i).getAnswer()));
				dao.addQuestion(qS);
			}
			return new ResponseEntity<List<Category>>(null, null, HttpStatus.OK);
		} else {
			throw new CustomException("Return type not accepted", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "addLevels", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> getLevels(@RequestBody String jsonResponse) throws JSONException {
		JSONObject org = new JSONObject(jsonResponse);
		String category = org.getString("categoryID");
		System.out.println("Add levels : ");
		Category c = new Category();
		c.setId(Integer.parseInt(category));

		Levels l = new Levels();
		JSONArray ary = org.getJSONArray("levels");
		for (int i = 0; i < ary.length(); i++) {
			l.setLevelCategory(ary.getString(i));
			l.setCategory(c);
			try {
				System.out.println(l.getCategory().getId() + " CG : SL " + l.getLevelCategory());
				dao.addLevel(l);
			} catch (Exception e) {
				System.out.println("Ad level errror" + e);
			}
		}

		return new ResponseEntity<String>(jsonResponse, null, HttpStatus.OK);
	}

	@RequestMapping(value = "getAllLevels", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllLevels() {
		List<Levels> lvl = dao.showAllLevel();
		return new ResponseEntity<Object>(lvl, null, HttpStatus.OK);
	}

}
