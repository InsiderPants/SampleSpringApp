package com.manish.SampleSpringProject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataResponse<T> extends Response{

	private T body;
	
	public DataResponse (Boolean success, T body) {
		super(success);
		this.body = body;
	}
}
