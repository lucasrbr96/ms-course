package com.udemy.payroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udemy.payroll.entities.Payment;
import com.udemy.payroll.services.paymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private paymentService service;
	
	@HystrixCommand(fallbackMethod = "findByIdAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findById(@PathVariable("workerId") Long id, @PathVariable("days") Integer days){
		Payment payment = service.getPayment(id, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> findByIdAlternative(Long id, Integer days){
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}
	
}
