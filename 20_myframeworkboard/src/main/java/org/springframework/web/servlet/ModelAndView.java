package org.springframework.web.servlet;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private String view;
	private Map<String, Object> model = new HashMap<>();
	
	
	public ModelAndView() {}
	public ModelAndView(String view) {this.view = view;}
	
	
	
	public void addObject(String key, Object value) {
		model.put(key, value);
	}
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public Map<String, Object> getModel() {
		return model;
	}
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	

}
