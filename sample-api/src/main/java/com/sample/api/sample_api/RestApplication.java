package com.sample.api.sample_api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplication extends Application {
	protected final Set<Class<?>> classes = new HashSet<Class<?>>();



	private final Set<Class<?>> singletons = new HashSet<Class<?>>();

	public RestApplication() {
		singletons.add(com.sample.api.sample_api.RestService.class);

	}
	
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(RestService.class);
		return classes;
	}

}
