package com.husqvarna.todo.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public enum StatusEnum {

	S100("S100","Todo record added"),
	S200("S200","Todo record updated"),
	S300("S300","Todo record deleted"),
	
	E100("E100","To do record id not found"),
	E200("E200","Recods can not be null"),
	E500("E500","Excepetion occured while runing service, pleaese conatct system admin");
	
	
	private String code;
	private String message;
	
	
	private StatusEnum(String code, String message ) {
		this.code =code;
		this.message =message;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public StatusEnum getValueOf(String code) {
		
		return Stream.of(StatusEnum.values()).filter(s->s.getCode().equals(code)).findFirst().get();
	}
	
}
