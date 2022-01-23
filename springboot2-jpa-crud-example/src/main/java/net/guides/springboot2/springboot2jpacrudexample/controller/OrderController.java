package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Order;
import net.guides.springboot2.springboot2jpacrudexample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		return ResponseEntity.ok().body(order);
	}

	@PostMapping("/orders")
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderRepository.save(order);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
			@Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

		order.setSymbol(orderDetails.getSymbol());
		order.setSide(orderDetails.getSide());
		order.setStopPrice(orderDetails.getStopPrice());
		order.setPrice(orderDetails.getStopPrice());
		order.setQuantity(orderDetails.getStopPrice());
		order.setDueDate(orderDetails.getDueDate());
		order.setStatus(orderDetails.getStatus());
		final Order updatedOrder = orderRepository.save(order);
		return ResponseEntity.ok(updatedOrder);
	}

	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

		orderRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
