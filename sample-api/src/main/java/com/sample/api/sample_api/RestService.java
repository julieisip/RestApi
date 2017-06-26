package com.sample.api.sample_api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.sample.api.sample_api.BO.Contact;
import com.sample.api.sample_api.context.SpringApplicationContext;
import com.sample.api.sample_api.provider.ContactMapper;
import com.sample.api.sample_api.provider.DBSearch;

@Path("/")
@Provider
public class RestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mainService(@Context UriInfo info) {
		DBSearch search = (DBSearch) SpringApplicationContext.getBean("dbSearch");
		final String firstName = info.getQueryParameters().getFirst("firstName");
		final String lastName = info.getQueryParameters().getFirst("lastName");
		final String phone = info.getQueryParameters().getFirst("phone");
		final String email = info.getQueryParameters().getFirst("email");
		List<Contact> contact;
		if (firstName == null && lastName == null && phone == null && email == null) {
			contact = new ArrayList<Contact>();
		} else {

			contact = ContactMapper.personMapper(search.findContact(firstName, lastName, email, phone));
		}
		return Response.status(200).entity(contact).build();

	}

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

}
