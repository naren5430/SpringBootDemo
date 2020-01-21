package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DemoDao;
/**
 * 	
 * @author Narendranadh P
 * @since 10-01-2020
 */
@Service
public class DemoService {

	@Autowired
	DemoDao dao;
	
	public int addition(int val1, int val2) {
		return val1+val2;
		
	}

	public int subtraction(int val1, int val2) {
		return val1-val2;
	}

	public int multiplication(int val1, int val2) {
		
		return val1 * val2;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public int save(Map<String, Object> data) {
		return dao.save(data);
	}

	/**
	 * 
	 * @param data
	 * @param id
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public int update(Map<String, Object> data, int id) {
		return dao.update(data, id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public int delete(int id) {
		return dao.delete(id);
	}

	/**
	 * 
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public List<Map<String, Object>> list() {
		//List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		return dao.list();
		
	}

	/**
	 * 
	 * @param parameter
	 * @param sort
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public List<Map<String, Object>> list(String parameter, String sort) {
		//List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		return dao.list(parameter, sort);
		
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            