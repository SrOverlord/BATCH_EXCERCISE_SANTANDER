package com.batch.exercise.BatchExercise.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "INVOICES")
public class InvoiceEntity {

    @Id
    @Column
    private Integer id;

    @Column
    private String invoiceCode;

    @Column
    private String supplierCode;

    @Column( precision = 15, scale = 2)
    private BigDecimal amount;

    @Column( length = 3)
    private String currency;

    @Column
    private LocalDate dueDate;

    @Column( length = 20)
    private String status;

    @Column
    private Integer paymentExtraction;

    @Column( length = 20)
    private String iban;

}