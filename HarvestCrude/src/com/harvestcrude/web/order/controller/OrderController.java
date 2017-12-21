package com.harvestcrude.web.order.controller;

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
import com.harvestcrude.model.driver.Driver;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.model.lease.plant.tank.Tank;
import com.harvestcrude.model.order.Order;
import com.harvestcrude.model.ticket.TicketType;
import com.harvestcrude.model.user.User;
import com.harvestcrude.services.ServiceException;
import com.harvestcrude.services.destination.DestinationService;
import com.harvestcrude.services.dispatch.DispatchService;
import com.harvestcrude.services.driver.DriverService;
import com.harvestcrude.services.lease.plant.LeasePlantService;
import com.harvestcrude.services.lease.plant.tank.TankService;
import com.harvestcrude.services.order.NoSuchOrderException;
import com.harvestcrude.services.order.OrderService;
import com.harvestcrude.services.order.OrderStatusService;
import com.harvestcrude.services.ticket.TicketTypeService;
import com.harvestcrude.services.truck.TruckService;

@ViewScoped
@ManagedBean
public class OrderController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderController.class);

	private Order order;
	private List<LeasePlant> leases;
	private List<Destination> destinations;
	private List<Driver> drivers;
	private List<TicketType> ticketTypes;
	private Dispatch currentDispatch;
	private Integer nextOrderNumber;
	private Integer previousOrderNumber;
	private List<Tank> leasePlantTanks;

	@PostConstruct
	public void init() {
		order = new Order();
		String orderNumber = null;
		OrderService orderService = new OrderService();
		destinations = new DestinationService().getAllDestinations();
		leases = new LeasePlantService().getAllLeasePlants();
		drivers = new DriverService().getAllDrivers();
		ticketTypes = new TicketTypeService().getAllTicketTypes();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		try {
			if (request.getParameter("order") != null && !request.getParameter("order").equals("0")) {
				orderNumber = request.getParameter("order").toString();
				order.setOrderNumber(Integer.parseInt(orderNumber));
				order = orderService.selectCompleteOrder(order);
				currentDispatch = new DispatchService().getOrderCurrentDispatch(order);
				setLeasePlantTanks(new TankService().selectLeasePlantTanks(order.getLeasePlant()));
				previousOrderNumber = orderService.getPreviousOrderNumber(order, currentDispatch);
				nextOrderNumber = orderService.getNextOrderNumber(order, currentDispatch);
			}
		} catch (NumberFormatException e) {
			logger.error(e);
			getFacesContext().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid order", "The requested order is not valid"));
		} catch (NoSuchOrderException e) {
			logger.error(e);
			getFacesContext().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid order", e.getMessage()));
		} catch (ServiceException e) {
			logger.error(e);
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public void cancelOrder() {
		OrderService orderService = new OrderService();
		try {
			orderService.cancelOrder(order);
			order.setOrderStatus(new OrderStatusService().selectOrderStatus(order));
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Order cancel Succesful",
					"Order was canceled succesfully"));
		} catch (ServiceException e) {
			logger.error(e);
			getFacesContext().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error canceling order", e.getMessage()));
		}
	}

	public void saveOrder() {
		OrderService orderService = new OrderService();
		User user = new User();
		user.setUserId(1);
		calculateBarrels();
		try {
			orderService.saveOrderTicketInformation(order, user);
			order.setOrderStatus(new OrderStatusService().selectOrderStatus(order));
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Order saved",
					"Order information was saved succesfully"));
		} catch (ServiceException e) {
			logger.error(e);
			getFacesContext().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error saving order", e.getMessage()));
		}
	}

	public void calculateBarrels() {
		if (order.getTicket().getTicketType().getIsMeterRequired()) {
			order.getTicket().getTicketData()
					.setTotalBarrels(order.getTicket().getTicketData().getTicketMeterData().getMeterOff()
							- order.getTicket().getTicketData().getTicketMeterData().getMeterOn());
		} else {
			order.getTicket().getTicketData()
					.setTotalBarrels(((order.getTicket().getTicketData().getTicketGaugeData().getHighFeet() * 12)
							+ order.getTicket().getTicketData().getTicketGaugeData().getHighInches()
							+ (order.getTicket().getTicketData().getTicketGaugeData().getHighFract() * 0.25f))
							- ((order.getTicket().getTicketData().getTicketGaugeData().getLowFeet() * 12)
									+ order.getTicket().getTicketData().getTicketGaugeData().getLowInches() + (order
											.getTicket().getTicketData().getTicketGaugeData().getLowFract() * 0.25f)));
		}
	}

	public void selectDriverTruck() {
		if (order.getDriver() != null) {
			TruckService truckService = new TruckService();
			try {
				order.setTruck(truckService.selectDriverTruck(order.getDriver().getUser()));
			} catch (ServiceException e) {
				logger.error(e);
				getFacesContext().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error getting driver's truck"));
			}
		}
	}
	
	public void selectLeasePlantTanks(){
		if(order.getLeasePlant() != null){
			TankService tankService = new TankService();
			try {
				setLeasePlantTanks(tankService.selectLeasePlantTanks(order.getLeasePlant()));
			} catch (Exception e) {
				logger.error(e);
				getFacesContext().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error getting lease plant's tanks"));
			}
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}

	public Dispatch getCurrentDispatch() {
		return currentDispatch;
	}

	public void setCurrentDispatch(Dispatch currentDispatch) {
		this.currentDispatch = currentDispatch;
	}

	public Integer getNextOrderNumber() {
		return nextOrderNumber;
	}

	public void setNextOrderNumber(Integer nextOrderNumber) {
		this.nextOrderNumber = nextOrderNumber;
	}

	public Integer getPreviousOrderNumber() {
		return previousOrderNumber;
	}

	public void setPreviousOrderNumber(Integer previousOrderNumber) {
		this.previousOrderNumber = previousOrderNumber;
	}

	public List<Tank> getLeasePlantTanks() {
		return leasePlantTanks;
	}

	public void setLeasePlantTanks(List<Tank> leasePlantTanks) {
		this.leasePlantTanks = leasePlantTanks;
	}

}
