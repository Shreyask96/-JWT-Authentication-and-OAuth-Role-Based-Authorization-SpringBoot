package com.dakrsolutions.JWT_OAuth.Models;

public class ReponseModel{
	
	    private final String jwtToken;

	    public ReponseModel(String jwtToken) {
	        this.jwtToken = jwtToken;
	    }

	    public String getJwtToken() {
	        return jwtToken;
	    }
}
