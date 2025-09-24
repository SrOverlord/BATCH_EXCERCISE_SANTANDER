package com.batch.exercise.BatchExercise.domain.filters;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class FilterInvoce {

    @Builder.Default
    private Set<String> invoicesCode = new HashSet<>();

    @Builder.Default
    private Set<String> ibans = new HashSet<>();

    private LocalDate dueDate;

    private Integer paymentExtraction;

}
