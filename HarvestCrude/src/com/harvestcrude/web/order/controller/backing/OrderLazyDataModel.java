package com.harvestcrude.web.order.controller.backing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.harvestcrude.model.dispatch.Dispatch;
import com.harvestcrude.model.order.DTO.OrderDTO;
import com.harvestcrude.services.order.OrderService;

public class OrderLazyDataModel extends LazyDataModel<OrderDTO> {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderLazyDataModel.class);
	private List<OrderDTO> orders;
	private String filter;
	private Dispatch dispatch;
	private OrderDTO orderDTO;
	
	public OrderLazyDataModel(String filter, Dispatch dispatch, OrderDTO orderDTO){
		this.filter = filter;
		this.dispatch = dispatch;
		this.orderDTO = orderDTO;
	}
	
	@Override
	public List<OrderDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		OrderService orderService = new OrderService();
		try {
			orders = orderService.selectOrdersForSplitLoad(dispatch, orderDTO, filter, first, pageSize);
			setRowCount(orderService.selectOrdersForSplitLoadCount(dispatch, orderDTO, sortField));
		} catch (Exception e) {
			logger.error(e);
			orders = Collections.emptyList();
		}
		return orders;
	}

	@Override
	public OrderDTO getRowData(String rowKey) {
		OrderDTO order = null;
		for (OrderDTO orderDTO : orders) {
			if(orderDTO.getOrderNumber() == Integer.parseInt(rowKey)){
				order = orderDTO;
			}
		}
		return order;
	}

	@Override
	public Object getRowKey(OrderDTO object) {
		return object.getOrderNumber();
	}
	
}
