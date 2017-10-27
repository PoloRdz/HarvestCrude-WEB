package com.harvestcrude.web.dispatch.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import com.harvestcrude.model.dispatch.DTO.DispatchDTO;
import com.harvestcrude.web.dispatch.controller.backing.DispatchLazyDataModel;

@ManagedBean
@RequestScoped
public class SearchDispatchController implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SearchDispatchController.class);
	
	private LazyDataModel<DispatchDTO> dispatches;
	
	@PostConstruct
	public void init(){
		dispatches = new DispatchLazyDataModel("");
	}

	public LazyDataModel<DispatchDTO> getDispatches() {
		return dispatches;
	}

	public void setDispatches(LazyDataModel<DispatchDTO> dispatches) {
		this.dispatches = dispatches;
	}

}
