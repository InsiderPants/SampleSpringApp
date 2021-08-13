package com.manish.SampleSpringProject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageResponse extends Response {
	
	private String message;
	
	public MessageResponse (Boolean success, String message) {
		super(success);
		this.message = message;
	}
	
}
