package com.worthen.cody.springnotes.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {

	// We want the same PersonDao to get a new instance of JdbcConnection each time,
	// but changing the scope of JdbcConnection to prototype isn't enough to
	// accomplish this. We need to use a proxy. We do this by passing a second
	// argument to the @Scope annotation as shown above.

	public JdbcConnection() {
		System.out.println("JDBC Connection");
	}

}
