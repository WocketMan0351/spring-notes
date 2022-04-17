package com.worthen.cody.component_scan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComponentDao {

	private ComponentJdbcConnection jdbcConnection;

	// @Autowired is OPTIONAL for constructor injection now.
	public ComponentDao(@Qualifier("componentJdbcConnection") ComponentJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public ComponentJdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(ComponentJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

}
