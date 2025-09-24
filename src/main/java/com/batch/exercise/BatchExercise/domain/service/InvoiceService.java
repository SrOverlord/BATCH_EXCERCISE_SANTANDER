package com.batch.exercise.BatchExercise.domain.service;

import com.batch.exercise.BatchExercise.domain.filters.FilterInvoce;
import com.batch.exercise.BatchExercise.domain.model.Invoice;
import org.springframework.core.io.Resource;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    List<Invoice> findByFilter(FilterInvoce filter);

    Invoice update (Invoice invoiceUpdate);

    Resource extractInvoiceReport(LocalDate dueDate);
}
