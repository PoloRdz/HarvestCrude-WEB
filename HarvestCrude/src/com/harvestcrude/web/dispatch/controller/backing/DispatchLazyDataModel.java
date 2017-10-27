package com.harvestcrude.web.dispatch.controller.backing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.harvestcrude.model.dispatch.DTO.DispatchDTO;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.dispatch.DispatchService;

public class DispatchLazyDataModel extends LazyDataModel<DispatchDTO>{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DispatchLazyDataModel.class);
	
	private List<DispatchDTO> dispatches;
	private String filter;

	public DispatchLazyDataModel(String filter) {
		this.filter = filter;
	}

	@Override
	public List<DispatchDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		DispatchService dispatchService = new DispatchService();
		try{
			dispatches = dispatchService.searchAllDispatch(filter, first, pageSize);
			setRowCount(dispatchService.searchAllDispatchCount(filter));
		} catch (ServiceException e) {
			logger.error(e);
			dispatches = Collections.emptyList();
		}
		return dispatches;
	}
}
