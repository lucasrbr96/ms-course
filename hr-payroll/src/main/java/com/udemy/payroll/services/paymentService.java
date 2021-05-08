package com.udemy.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.payroll.entities.Payment;
import com.udemy.payroll.entities.Worker;
import com.udemy.payroll.feignclientes.WorkerFeignClient;

@Service
public class paymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
}
