package com.husqvarna.todo;

import java.io.Serializable;



public class TodoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7931265859693016492L;
	

	
	private Integer id;
	
	
	private String status;
	
	
	private String description;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", status=" + status + ", description=" + description + "]";
	}

}
