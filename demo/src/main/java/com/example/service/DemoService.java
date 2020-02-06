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
		return dao.list(parameter, sort);
		
	}

	

	public double distancecal(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            