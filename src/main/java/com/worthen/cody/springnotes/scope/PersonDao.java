package com.worthen.cody.springnotes.scope;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {

	private JdbcConnection jdbcConnection;

	// @Autowired is OPTIONAL for constructor injection now.
	public PersonDao(@Qualifier("jdbcConnection") JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

}
