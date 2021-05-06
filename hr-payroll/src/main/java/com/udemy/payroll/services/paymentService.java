package com.udemy.payroll.services;

import org.springframework.stereotype.Service;

import com.udemy.payroll.entities.Payment;

@Service
public class paymentService {

	public Payment getPayment(Long workerId, int days) {
		return Payment.builder()
				.name("Bob").dailyIncome(200.0)
				.days(days).build();
		
	}
}
