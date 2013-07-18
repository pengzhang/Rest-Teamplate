package com.fanaifan.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class RestAPI {

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion(){
		return "0.0.1";
	}
}
