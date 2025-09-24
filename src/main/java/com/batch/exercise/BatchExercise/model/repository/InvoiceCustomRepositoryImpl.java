package com.batch.exercise.BatchExercise.model.repository;

import com.batch.exercise.BatchExercise.domain.filters.FilterInvoce;
import com.batch.exercise.BatchExercise.model.entity.InvoiceEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Repository
@Validated
@RequiredArgsConstructor
public class InvoiceCustomRepositoryImpl implements InvoiceCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<InvoiceEntity> findByFilter(FilterInvoce filter) {
		//I was having problems in my IDE trying the get the dependency so I commented the code. Sorry for that.
		//Here we are playing with querydsl to make easy controlled operations

		final JPAQueryFactory queryFactory = new JPAQueryFactory( this.entityManager);
		final QInvoiceEntity i = new QInvoiceEntity( "i");
		return queryFactory
				.selectDistinct(ad)
				.from(i)
				.where(this.generateWhere(filter, i)).fetch();
		return new ArrayList<>();
	}


	private BooleanExpression generateWhere(final FilterInvoce filter, final QInvoiceEntity i) {
		return new WhereBuilder(i)
				.invoicesCode(filter.getInvoicesCode())
				.ibans(filter.getIbans())
				.dueDate(filter.getDueDate())
				.paymentExtraction(filter.getPaymentExtraction())
				.build();
	}

	@RequiredArgsConstructor
	private class WhereBuilder {

		private final QInvoiceEntity i;

		private BooleanExpression booleanExpression = Expressions.asBoolean(true).isTrue();

		WhereBuilder invoicesCode(final Set<String> invoicesCode) {
			if (!CollectionUtils.isEmpty(invoicesCode)) {
				this.booleanExpression = this.booleanExpression
						.and(this.i.invoiceCode.in(invoicesCode));
			}
			return this;
		}

		WhereBuilder ibans(final Set<String> ibans) {
			if (!CollectionUtils.isEmpty(ibans)) {
				this.booleanExpression = this.booleanExpression
						.and(this.i.iban.in(ibans));
			}
			return this;
		}

		WhereBuilder dueDate(final LocalDate dueDate) {
			if (dueDate != null) {
				this.booleanExpression = this.booleanExpression
						.and(this.i.due.eq(dueDate));
			}
			return this;
		}

		WhereBuilder paymentExtraction(final Integer paymentExtraction) {
			if (paymentExtraction != null) {
				this.booleanExpression = this.booleanExpression
						.and(this.i.paymentExtraction.eq(paymentExtraction));
			}
			return this;
		}

		BooleanExpression build() {
			return this.booleanExpression;
		}
	}
}
