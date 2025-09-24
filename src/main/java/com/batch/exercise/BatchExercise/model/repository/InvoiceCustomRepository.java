package com.batch.exercise.BatchExercise.model.repository;

import com.batch.exercise.BatchExercise.domain.filters.FilterInvoce;
import com.batch.exercise.BatchExercise.model.entity.InvoiceEntity;

import java.util.List;

public interface InvoiceCustomRepository {

    List<InvoiceEntity> findByFilter (FilterInvoce filter);
}
