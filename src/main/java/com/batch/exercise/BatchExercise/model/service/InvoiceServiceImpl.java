package com.batch.exercise.BatchExercise.model.service;

import com.batch.exercise.BatchExercise.domain.filters.FilterInvoce;
import com.batch.exercise.BatchExercise.domain.model.Invoice;
import com.batch.exercise.BatchExercise.domain.service.InvoiceService;
import com.batch.exercise.BatchExercise.model.entity.InvoiceEntity;
import com.batch.exercise.BatchExercise.model.enums.PaymentExtractionEnum;
import com.batch.exercise.BatchExercise.model.mapper.InvoiceMapper;
import com.batch.exercise.BatchExercise.model.repository.InvoiceRepository;
import com.batch.exercise.BatchExercise.model.utils.InvoiceReportUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

	@jakarta.annotation.Resource
	@Lazy
	private InvoiceService self;

	private final InvoiceRepository invoiceRepository;

	private final InvoiceMapper invoiceMapper;

	public List<Invoice> findByFilter(FilterInvoce filter) {
		return this.invoiceRepository.findByFilter(filter).stream().map(this.invoiceMapper::asModel).toList();
	}

	@SneakyThrows
	@Transactional
	public Invoice update (Invoice invoiceUpdate) {
		if(invoiceUpdate.getId() ==  null){
			throw new Exception("ERROR: CANNOT UPDATE INVOICE WITHOUT ID");
		}
		final Optional<InvoiceEntity> entity = this.invoiceRepository.findById(invoiceUpdate.getId());
		if( entity.isEmpty()){
			throw new Exception("ERROR: CANNOT FOUND INVOICE WITH PROVIDED ID ");
		}

		this.invoiceMapper.updateFromModel(entity.get(),invoiceUpdate );
		return this.invoiceMapper.asModel(this.invoiceRepository.save(entity.get()));
	}

	@Transactional
	public Resource extractInvoiceReport(LocalDate dueDate) {
		final List<Invoice> invoices  = this.findByFilter(FilterInvoce.builder()
				.dueDate(dueDate)
				.paymentExtraction(PaymentExtractionEnum.NOT_EXTRACTED.getValue())
				.build());

		final Resource report = InvoiceReportUtils.generateReport(invoices);
		invoices.forEach(this::saveWithPaymentExtractionExtracted);
		return report;
    }

	private void saveWithPaymentExtractionExtracted(Invoice invoice) {
		invoice.setPaymentExtraction(PaymentExtractionEnum.EXTRACTED.getValue());
		this.update(invoice);
	}
}
