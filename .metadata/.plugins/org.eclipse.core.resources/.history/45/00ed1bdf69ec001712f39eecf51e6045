package com.example.demo.controller;

<<<<<<< HEAD

















import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;

=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
>>>>>>> 85c077362c2c1cd0853ab19868a0db05d8e3a8ee
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD

=======
>>>>>>> 85c077362c2c1cd0853ab19868a0db05d8e3a8ee

import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;
import com.example.demo.entity.Questions;
import com.example.demo.service.Inter;

@Controller
public class MyController {
	
	
	@Autowired Inter dao;
	
	
	/*@RequestMapping(value="/getUsers", method = { RequestMethod.GET})
	public  ResponseEntity<List<Stri>> index(Model mol){
		mol.addAttribute("data","hello");
		System.out.println("inside the controller");
		List<Mark> l= dao.getUsers();
        
		for(Mark m:l)
		{
		System.out.println("the name ****************"+m.getProduct());
		}
		return new ResponseEntity<>(l,org.springframework.http.HttpStatus.OK);			
	}*/
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public @ResponseBody String ins(){
		
		/*Category c=new Category();
		c.setCategory("dbz8");
		
		List<Levels> l=new ArrayList<Levels>();
		l.add(new Levels("goku",c));
		l.add(new Levels("picalo",c));
		
		c.setItems(l);
		
		dao.saveData(c);*/
		 /*Levels l=new Levels();
		 l.setLevelCategory("level5");
		 l.setCategory(c);
		 */
		
		  
		 List<Category> t=dao.saveData(1);
	     for(Levels h:t.get(0).getItems())
	     {
	    	 for(Questions q:h.getQuestionsItem())
	    	 {
	    		 System.out.println("the data is :"+q.getAnswer());
	    	 }
	     }
	     return "success";
	}
	
	@RequestMapping(value ="/getCategory", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> categor(){
		List<Category> mCategory = dao.findCategory();
		return new ResponseEntity<List<Category>>(mCategory, null,HttpStatus.OK);
	}  

}
