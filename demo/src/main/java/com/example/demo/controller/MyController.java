package com.example.demo.controller;

















import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;








import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;
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
		
		Category c=new Category();
		c.setId(1);
		
		 /*Levels l=new Levels();
		 l.setLevelCategory("level5");
		 l.setCategory(c);
		 */
		 List<Levels> li=dao.insertData(c);
		 for(Levels s:li)
		 {
			 System.out.println("the data is :"+s.getLevelCategory()+"/n"+s.getCategory().getCategory());
		 }
		
		
		
		
		return "success";
	}

}
