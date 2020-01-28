package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao{


	
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
		int res;
		try {
		res = jdbcTemplate.update("INSERT INTO beacon (name, mac, message, location) VALUES(?,?, ?, ?)",
				data.get("name"), data.get("becon_mac"), data.get("message"), data.get("location"));
		}catch(DuplicateKeyException key){
			return 0;
		}catch(DataIntegrityViolationException key){
			return 2;
		}
		return res;
	}
	
	/*
	 * public int save1(Map<String, Object> data) {
	 * 
	 * String sql =
	 * "INSERT INTO beacon (name, mac, message, location) VALUES(?,?, ?, ?)";
	 * KeyHolder keyHolder = new GeneratedKeyHolder();
	 * 
	 * jdbcTemplate.update(connection -> { PreparedStatement ps = connection
	 * .prepareStatement(sql); ps.setString(name, data.get("name")); return ps; },
	 * keyHolder);
	 * 
	 * return (long) keyHolder.getKey(); return jdbcTemplate.
	 * update("INSERT INTO beacon (name, mac, message, location) VALUES(?,?, ?, ?)",
	 * data.get("name"), data.get("becon_mac"), data.get("message"),
	 * data.get("location")); }
	 */

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
		return jdbcTemplate.queryForList(
				"SELECT mac AS `becon_mac`, name, message, location, date_format(created_time,'%D %M %Y %r') AS `Added Date` FROM beacon ORDER BY pk_id DESC");
	}

	/**
	 * 
	 * @param parameter
	 * @param sort
	 * @return
	 * @author Narendranadh P
	 * @since 21-01-2020 date_format(created_time,'%D-%M-%Y T(hr-min-sec)%H-%i-%S --%r')
	 * @see https://www.w3schools.com/sql/func_mysql_date_format.asp
	 */
	public List<Map<String, Object>> list(String parameter, String sort) {
		return jdbcTemplate.queryForList(
				"SELECT mac AS `becon_mac`, name, message, location, date_format(created_time,'%D %M %Y %r') AS `Added Date` FROM beacon ORDER BY "
						+ parameter + " " + sort);
	}
}
