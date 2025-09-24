package com.batch.exercise.BatchExercise.model.enums;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@Getter
public enum PaymentExtractionEnum {
    EXTRACTED(1),
    NOT_EXTRACTED(0);

    private Integer value;
}
