package com.example.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
 * @apiNote Beacon CURD operation
 * @author Narendranadh P
 * @since 10-01-2020
 */
@SuppressWarnings("serial")
@RestController
@RequestMapping(value = "/demo")
public class DemoController extends RuntimeException{
	
	@Autowired
	DemoService service;
	/**
	 * @author Narendranadh P
	 * @return
	 */
	@GetMapping("")
	public String displayName() {
		return "Hello Narendranadh, Welcome to locus application";
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
	 * @ApiUse --save
	 * @param data
	 * @return
	 * @author Narendranadh P
	 * @return 
	 * @since 20-01-2020
	 */

	/*
	 * Accepts Json format
	@PostMapping("/beacon/save")
	public int save(@RequestBody Map<String, Object > data) {
		return service.save(data);
	}
	*/
	@PostMapping(path = "/beacon/save", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<Map<String, Object>> save(@RequestParam Map<String, Object > data, HttpSession httpSession) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int res = service.save(data);
			if(res == 1) {
			map.put("message", "approved");
			map.put("status", "success");
			}else if(res == 0){	
				map.put("message", "rejected");
				map.put("status", "fail");
				map.put("error","Duplicate entry for key");
		}else if(res == 2) {
			map.put("message", "rejected");
			map.put("status", "fail");
			map.put("error","IntegrityConstraintViolationException: Column 'name','mac','message' and 'location' cannot be null");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * @ApiUse --Update using Pk_id
	 * @param data
	 * @param id
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	@PutMapping("/beacon/update/{pk_id}")
	public int update(@RequestBody Map<String, Object > data, @PathVariable("pk_id") int id) {
		return service.update(data, id);
	}
	
	/**
	 * @ApiUse --Delete
	 * @param id
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	@DeleteMapping("/beacon/delete/{pk_id}")
	public int delete(@PathVariable("pk_id") int id) {
		return service.delete(id);
	}
	
	/**
	 * @apiUse --List 
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	@PostMapping(path = "/beacon/list")
	public ResponseEntity<Map<String, Object>> list() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		list = service.list();
		// TODO Pagination
		map.put("message", "approved");
		map.put("status", "success");
		map.put("data", list);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * @apiUse --List with Sort
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	
	@PostMapping("/beacon/list/{parameter}/{sort}")
	public ResponseEntity<Map<String, Object>> list(@PathVariable("parameter") String parameter, @PathVariable("sort") String sort) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		list = service.list(parameter, sort);
		// TODO Pagination
		map.put("message", "approved");
		map.put("status", "success");
		map.put("data", list);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @apiUse --Used to calculate Distance between two coordinates
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @author Narendranadh P
	 * @since 05-02-2020
	 */
	@PostMapping(path="/beacon/distance", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<Map<String, Object>> distance(@RequestParam("lat1") double lat1,@RequestParam("lon1") double lon1, @RequestParam("lat2") double lat2, @RequestParam("lon2") double lon2, @RequestParam("unit") String unit) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		double calDistance;	
		calDistance = service.distancecal(lat1,lon1,lat2,lon2,unit);
		map.put("Latitude1", lat1);
		map.put("Longitude1", lon1);
		map.put("Latitude2", lat2);
		map.put("Longitude2", lon2);
		map.put("Units", unit);
		map.put("status", "success");
		map.put("Distance", calDistance);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
