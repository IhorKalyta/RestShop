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

import ua.entity.Type;
import ua.service.TypeService;

@RestController
@RequestMapping(value="/admin/type")
public class RestTypeController {
	
	@Autowired
	private TypeService typeService;	
	
	@GetMapping(headers = {"Accept=text/xml, application/json"})
	public List<Type> findAll(){
		return typeService.findAll();
	}
	
	@GetMapping("/{id}")
	public Type findOne(@PathVariable int id){
		return typeService.findOne(id);
	}
	
	@PutMapping
	public Type save(@RequestBody Type type){
		return typeService.save(type);
	}
	
	@DeleteMapping(value = "/{id}", headers = {"Accept=text/xml, application/json"})
	public HttpStatus delete(@PathVariable int id){
		typeService.delete(id);
		return HttpStatus.OK;
	}
	

}
