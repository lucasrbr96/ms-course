package com.udemy.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.payroll.entities.Payment;
import com.udemy.payroll.entities.Worker;

@Service
public class paymentService {

	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVaribleMap = new HashMap<String, String>();
		uriVaribleMap.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(workerHost+ "/workers/{id}",
				Worker.class,uriVaribleMap);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
}
