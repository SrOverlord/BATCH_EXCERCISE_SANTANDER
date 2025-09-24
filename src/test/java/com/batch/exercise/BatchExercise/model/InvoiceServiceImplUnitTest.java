package com.batch.exercise.BatchExercise.model;

import com.batch.exercise.BatchExercise.base.AbstractBaseUnitTest;
import com.batch.exercise.BatchExercise.domain.service.InvoiceService;
import com.batch.exercise.BatchExercise.model.mapper.InvoiceMapper;
import com.batch.exercise.BatchExercise.model.mapper.InvoiceMapperImpl;
import com.batch.exercise.BatchExercise.model.repository.InvoiceRepository;
import com.batch.exercise.BatchExercise.model.service.InvoiceServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class InvoiceServiceImplUnitTest extends AbstractBaseUnitTest {

    @InjectMocks
    @Spy
    InvoiceServiceImpl invoiceService;

    @Mock
    InvoiceRepository invoiceRepository;
    @Spy
    InvoiceMapperImpl invoiceMapper;

    @Override
    public void setUp() {
        doReturn(new ArrayList<>()).when(this.invoiceRepository).findByFilter(any());
        ReflectionTestUtils.setField(this.invoiceService, "invoiceMapper", this.invoiceMapper);
    }


    @Test
    void findByFilterWithSuccess(){
        //WHEN
        //We mock the calls to the in order to make

        //METHOD-CALL

        //ASSERT
    }

    @Test
    void updateWithSuccess(){
        //WHEN
        //METHOD-CALL

        //ASSERT - compare the result with a JSON
    }

    @Test
    void updateWhenNoIdWithException(){
        //WHEN
        //METHOD-CALL

        //ASSERT - exception and not verify not call repository
    }

    @Test
    void updateWhenEntityNotFoundWithException(){
        //WHEN
        //METHOD-CALL

        //ASSERT - exception and not verify not call repository
    }

    @Test
    void extractInvoiceReportWithSuccess(){
        //WHEN
        //METHOD-CALL

        //ASSERT - exception and not verify not call repository
    }

    @Test
    void extractInvoiceReportWhenFailUpdateWithException(){
        //WHEN
        //METHOD-CALL

        //ASSERT - exception and not verify not call repository
    }

    @Test
    void extractInvoiceReportWhenFailReportGenerationWithException(){
        //WHEN
        //METHOD-CALL

        //ASSERT - exception and not verify not call repository
    }



}
