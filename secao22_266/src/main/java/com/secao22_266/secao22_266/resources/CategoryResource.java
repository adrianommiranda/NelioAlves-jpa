package com.secao22_266.secao22_266.resources;

import java.util.List;
import com.secao22_266.secao22_266.services.CategoryService;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secao22_266.secao22_266.entities.Category;

@Controller
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
	private CategoryService categoryService;

    @GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
    	Category obj = categoryService.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
}
