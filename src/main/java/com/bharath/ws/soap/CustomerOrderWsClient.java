package com.bharath.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/customerordersservice?wsdl"));
	
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
	
	
		/*GetOrdersRequest req = new GetOrdersRequest();
	req.setCustomerId(BigInteger.valueOf(1));
	
	GetOrdersResponse response = customerOrdersWsImplPort.getOrders(req);
	List<Order> orders = response.getOrder();
	System.out.println("order size"+orders.size());

	
	for(Order order:orders) {
		List<Product> products = order.getProduct();
		for(Product product :products) {
			System.out.println("product desc"+product.getDescription());
			System.out.println("product quanitry"+product.getQuantity());
		}
	}
	*/
	
	
	
	
	
	CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
	
	Product product=new Product();
	product.setId("3");
	product.setDescription("macs");
	product.setQuantity(BigInteger.valueOf(11));
	
	Order order=new Order();
	order.setId(BigInteger.valueOf(2));
	order.getProduct().add(product);
	
	createOrdersRequest.setOrder(order);
	
	
	CreateOrdersResponse createOrdersResponse = customerOrdersWsImplPort.createOrders(createOrdersRequest);
	createOrdersResponse.setResult(true);
	System.out.println("result is"+createOrdersResponse.isResult());
	
	}

}
