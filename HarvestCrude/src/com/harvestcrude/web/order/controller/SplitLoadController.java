package com.harvestcrude.web.order.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.order.DTO.OrderDTO;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.dispatch.DispatchService;
import com.harvestcrude.services.order.OrderService;
import com.harvestcrude.web.order.controller.backing.OrderLazyDataModel;

@ManagedBean
@ViewScoped
public class SplitLoadController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SplitLoadController.class);

	private OrderDTO order;
	private Dispatch dispatch;
	private LazyDataModel<OrderDTO> orders;
	private OrderDTO selectedOrder;

	@PostConstruct
	public void init(){
		System.out.println("init()");
		int orderNumber = 0;
		Order auxOrder = new Order();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try{
			if(request.getParameter("order") != null && !request.getParameter("order").equals("0")){
				orderNumber = Integer.parseInt(request.getParameter("order"));
				order = new OrderDTO();
				order.setOrderNumber(orderNumber);
				auxOrder.setOrderNumber(orderNumber);
				try {
					order = new OrderService().selectPrimaryOrderForSplitLoad(order);
					dispatch = new DispatchService().getOrderCurrentDispatch(auxOrder);
					orders = new OrderLazyDataModel(null, dispatch, order);
				} catch (ServiceException e) {
					getFacesContext().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				}
			}
		} catch(NumberFormatException e){
			logger.error(e);
			getFacesContext().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid order", "The requested order is not valid"));
		}
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public Dispatch getDispatch() {
		return dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public LazyDataModel<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(LazyDataModel<OrderDTO> orders) {
		this.orders = orders;
	}

	public OrderDTO getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(OrderDTO selectedOrder) {
		this.selectedOrder = selectedOrder;
	}
}
