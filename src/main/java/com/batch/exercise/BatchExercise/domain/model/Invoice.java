package com.batch.exercise.BatchExercise.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice {

	@EqualsAndHashCode.Include
	private Integer id;

	private String invoiceCode;

	private String supplierCode;

	private BigDecimal amount;

	private String currency;

	private LocalDate dueDate;

	private String status;

	private Integer paymentExtraction;

	private String iban;
}
