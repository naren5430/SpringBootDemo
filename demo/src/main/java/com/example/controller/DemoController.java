package com.example.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DemoService;

/**
 * 	
 * @author Narendranadh P
 * @since 10-01-2020
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	DemoService service;
	/**
	 * @author Narendranadh P
	 * @return
	 */
	@GetMapping("/name")
	public String displayName() {
		return "Mani Paul sample";
	}
	@PostMapping("/addition/{val1}/{val2}")
	public int addition(@PathVariable("val1") int val1,@PathVariable("val2") int val2) {
		return service.addition(val1, val2);
	}
	@PostMapping("/subtraction")
	public int subtraction(@RequestParam("val1") int val1,@RequestParam("val2") int val2) {
		return service.subtraction(val1, val2);
	}
	@PostMapping("/multiplication")
	public int multiplication(@RequestBody Map<String, Integer > data) {
		return service.multiplication(data.get("val1"), data.get("val2"));
	}
	
	/*
	 * Beacon CURD perations
	 * 
	 */
	
	/**
	 * @param data
	 * @return
	 * @author Narendranadh P
	 * @since 20-01-2020
	 */
	
	@PostMapping("/beacon/save")
	public int save(@RequestBody Map<String, Object > data) {
		return service.save(data);
	}
	
	@PutMapping("/beacon/update/{pk_id}")
	public int update(@RequestBody Map<String, Object > data, @PathVariable("pk_id") int id) {
		return service.update(data, id);
	}
	
	@DeleteMapping("/beacon/delete/{pk_id}")
	public int delete(@PathVariable("pk_id") int id) {
		return service.delete(id);
	}
	
	@PostMapping("/beacon/list")
	public ResponseEntity<Map<String, Object>> list() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		list = service.list();
		map.put("message", "approved");
		map.put("status", "success");
		map.put("data", list);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		//return service.list();
	}
	
	@PostMapping("/beacon/list/{parameter}/{sort}")
	public ResponseEntity<Map<String, Object>> list(@PathVariable("parameter") String parameter, @PathVariable("sort") String sort) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		list = service.list(parameter, sort);
		map.put("message", "approved");
		map.put("status", "success");
		map.put("data", list);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
