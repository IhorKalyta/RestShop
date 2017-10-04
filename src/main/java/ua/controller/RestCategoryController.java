package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.entity.Category;
import ua.service.CategoryService;

@RestController
@RequestMapping(value="/admin/category")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(headers = {"Accept=text/xml, application/json"})
	public List<Category>findAll(){
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category findOne(@PathVariable int id){
		return categoryService.findOne(id);
	}
	
	@PutMapping
	public Category save(@RequestBody Category category){
		return categoryService.save(category);
	}
	
	@DeleteMapping(value = "/{id}", headers = {"Accept=text/xml, application/json"})
	public HttpStatus delete(@PathVariable int id){
		categoryService.delete(id);
		return HttpStatus.OK;
	}
	

}
