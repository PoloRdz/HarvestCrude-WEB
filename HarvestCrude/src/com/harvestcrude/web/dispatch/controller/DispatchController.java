package com.harvestcrude.web.dispatch.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.harvestcrude.model.destination.Destination;
import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.destination.DestinationService;
import com.harvestcrude.services.dispatch.DispatchService;
import com.harvestcrude.services.lease.plant.LeasePlantService;

@ManagedBean
@ViewScoped
public class DispatchController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DispatchController.class);
	
	private Dispatch dispatch;
	private Order newOrder;
	private List<LeasePlant> leases;
	private List<Destination> destinations;
	
	@PostConstruct
	public void init(){
		newOrder = new Order();
		String dispatchId = null;
		dispatch = new Dispatch();
		DispatchService dispatchService = new DispatchService();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		destinations = new DestinationService().getAllDestinations();
		leases = new LeasePlantService().getAllLeasePlants();
		try{
			if(request.getParameter("dispatch") != null && !request.getParameter("dispatch").equals("0")){
				dispatchId = request.getParameter("dispatch").toString();
				dispatch.setDispatchId(Integer.parseInt(dispatchId));
				dispatch = dispatchService.getDispatchById(dispatch);
			}
		} catch(NumberFormatException e){
			logger.error(e);
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid dispatch", "The requested dispatch is not available"));
		} catch (ServiceException e) {
			logger.error(e);
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	public Dispatch getDispatch() {
		return dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public Order getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}

	public List<LeasePlant> getLeases() {
		return leases;
	}

	public void setLeases(List<LeasePlant> leases) {
		this.leases = leases;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
}
