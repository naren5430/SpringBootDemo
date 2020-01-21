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

	/**
	 * 
	 * @param data
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public int save(Map<String, Object> data) {
		return jdbcTemplate.update(
                "INSERT INTO beacon (name, mac, message, location) VALUES(?,?)",
                data.get("name"), data.get("becon_mac"), data.get("message"), data.get("location"));
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
		return jdbcTemplate.update(
                "UPDATE `beacon` SET `name` = ?, `mac` = ?, `message` = ?, `location` = ? WHERE `pk_id` = ?",
                data.get("name"), data.get("becon_mac"), data.get("message"), data.get("location"), id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM beacon WHERE id = ?", id);
	}

	/**
	 * 
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020
	 */
	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("SELECT mac AS `becon_mac`, name, message, location FROM beacon");
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
		return jdbcTemplate.queryForList("SELECT mac AS `becon_mac`, name, message, location FROM beacon ORDER BY "+parameter+" "+sort);
	}
}
