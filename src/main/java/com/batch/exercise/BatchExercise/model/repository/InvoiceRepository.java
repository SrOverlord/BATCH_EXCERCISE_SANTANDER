package com.batch.exercise.BatchExercise.model.repository;

import com.batch.exercise.BatchExercise.model.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends InvoiceCustomRepository, JpaRepository<InvoiceEntity, Integer> {
}
