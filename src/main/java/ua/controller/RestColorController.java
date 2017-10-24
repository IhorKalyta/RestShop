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

import ua.entity.Color;
import ua.service.ColorService;

@RestController
@RequestMapping(value="/admin/color")
public class RestColorController {
	
	@Autowired
	private ColorService colorService;		
	
	
	@GetMapping(headers = {"Accept=text/xml, application/json"})
	public List<Color> findAll(){
		return colorService.findAll();
	}
	
	@GetMapping("/{id}")
	public Color findOne(@PathVariable int id){
		return colorService.findOne(id);
	}
	
	@PutMapping
	public Color save(@RequestBody Color color){
		return colorService.save(color);
	}
	
	@DeleteMapping(value = "/{id}", headers = {"Accept=text/xml, application/json"})
	public HttpStatus delete(@PathVariable int id){
		colorService.delete(id);
		return HttpStatus.OK;
	}
}
