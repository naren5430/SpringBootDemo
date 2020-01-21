package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int save(Map<String, Object> data) {
		return jdbcTemplate.update(
                "INSERT INTO beacon (name, mac, message, location) VALUES(?,?)",
                data.get("name"), data.get("becon_mac"), data.get("message"), data.get("location"));
	}

	public int update(Map<String, Object> data, int id) {
		return jdbcTemplate.update(
                "UPDATE `beacon` SET `name` = ?, `mac` = ?, `message` = ?, `location` = ? WHERE `pk_id` = ?",
                data.get("name"), data.get("becon_mac"), data.get("message"), data.get("location"), id);
	}

	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM beacon WHERE id = ?", id);
	}

	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("select mac AS `becon_mac`, name, message, location from beacon");
	}
	
	public List<Map<String, Object>> list(String parameter, String sort) {
		return jdbcTemplate.queryForList("select mac AS `becon_mac`, name, message, location from beacon ORDER BY "+parameter+" "+sort);
	}
}
