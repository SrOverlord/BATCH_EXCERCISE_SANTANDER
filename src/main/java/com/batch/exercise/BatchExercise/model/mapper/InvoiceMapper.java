package com.batch.exercise.BatchExercise.model.mapper;

import com.batch.exercise.BatchExercise.domain.model.Invoice;
import com.batch.exercise.BatchExercise.model.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface InvoiceMapper {

	//Mappings if needed....
	Invoice asModel(InvoiceEntity src);

	InvoiceEntity asEntity(Invoice src);

	@Mapping(target = "id", ignore = true)
	void updateFromModel(@MappingTarget InvoiceEntity entity, Invoice src);

}
