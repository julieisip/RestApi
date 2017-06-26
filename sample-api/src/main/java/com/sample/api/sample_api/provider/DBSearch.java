package com.sample.api.sample_api.provider;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBSearch {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> findContact(String firstName,String lastName,String email, String phone) {

		List<Map<String, Object>> queryResult;
		SQLBuilder sql = new  SQLBuilder();
		String sqlSttmnt = sql.searchBuilder(firstName, lastName, email, phone);
		queryResult = jdbcTemplate.queryForList(sqlSttmnt, sql.getQueryParams());

		return queryResult;
	}
	

}
