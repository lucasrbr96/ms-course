package com.udemy.payroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2219246604279606882L;
	
	private Long id;
	private String name;
	private Double dailyIncome;
	
}
