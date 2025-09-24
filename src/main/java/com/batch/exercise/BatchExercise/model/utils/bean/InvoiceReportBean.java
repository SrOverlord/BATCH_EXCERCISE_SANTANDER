package com.batch.exercise.BatchExercise.model.utils.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class InvoiceReportBean {

    private Integer id;

    private String invoiceCode;

    private String supplierCode;

    private BigDecimal amount;

    private String currency;

    private LocalDate dueDate;

    private String iban;
}
