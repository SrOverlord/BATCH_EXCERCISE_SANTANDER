package com.batch.exercise.BatchExercise.base;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZoneId;
import java.util.TimeZone;

@ExtendWith({MockitoExtension.class})
public abstract class AbstractBaseUnitTest {
    public AbstractBaseUnitTest() {
    }

    @PostConstruct
    protected void setUp() {
    }
}