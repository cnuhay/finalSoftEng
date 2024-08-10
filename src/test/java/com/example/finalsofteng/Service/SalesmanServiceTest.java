package com.example.finalsofteng.Service;

import com.example.finalsofteng.Entity.SalesmanEntity;
import com.example.finalsofteng.Repository.SalesmanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SalesmanServiceTest {

    @Mock
    private SalesmanRepository salesmanRepository;

    @InjectMocks
    private SalesmanService salesmanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTransaction() {
        SalesmanEntity salesmanEntity = new SalesmanEntity();
        salesmanEntity.setTransactionId(1L);
        salesmanEntity.setSalesmanName("John Doe");
        salesmanEntity.setItemType("Washing Machine");
        salesmanEntity.setSalesAmount(100);
        salesmanEntity.setTransactionDate(LocalDate.now());

        when(salesmanRepository.save(any(SalesmanEntity.class))).thenReturn(salesmanEntity);

        salesmanService.saveTransaction(salesmanEntity);

        verify(salesmanRepository, times(1)).save(salesmanEntity);
    }

    @Test
    public void testDeleteTransaction() {
        Long transactionId = 1L;

        // Call the delete method
        salesmanService.deleteTransaction(transactionId);

        // Verify that the repository's deleteById method was called once
        verify(salesmanRepository, times(1)).deleteById(transactionId);
    }

    @Test
    public void testGetAllTransactions() {
        SalesmanEntity salesmanEntity = new SalesmanEntity();
        salesmanEntity.setTransactionId(1L);
        salesmanEntity.setSalesmanName("John Doe");
        salesmanEntity.setItemType("Washing Machine");
        salesmanEntity.setSalesAmount(100);
        salesmanEntity.setTransactionDate(LocalDate.now());

        when(salesmanRepository.findAll()).thenReturn(List.of(salesmanEntity));

        List<SalesmanEntity> salesmen = salesmanService.getAllTransactions();

        verify(salesmanRepository, times(1)).findAll();
        assertFalse(salesmen.isEmpty());
        assertEquals(1, salesmen.size());
        assertEquals("John Doe", salesmen.get(0).getSalesmanName());
    }

    @Test
    public void testGetTransactionById() {
        Long transactionId = 1L;
        SalesmanEntity salesmanEntity = new SalesmanEntity();
        salesmanEntity.setTransactionId(transactionId);
        salesmanEntity.setSalesmanName("John Doe");
        salesmanEntity.setItemType("Washing Machine");
        salesmanEntity.setSalesAmount(100);
        salesmanEntity.setTransactionDate(LocalDate.now());

        when(salesmanRepository.findById(transactionId)).thenReturn(Optional.of(salesmanEntity));

        SalesmanEntity foundEntity = salesmanService.getTransactionById(transactionId);

        verify(salesmanRepository, times(1)).findById(transactionId);
        assertNotNull(foundEntity);
        assertEquals("John Doe", foundEntity.getSalesmanName());
    }

    @Test
    public void testUpdateTransaction() {
        SalesmanEntity salesmanEntity = new SalesmanEntity();
        salesmanEntity.setTransactionId(1L);
        salesmanEntity.setSalesmanName("John Doe");
        salesmanEntity.setItemType("Washing Machine");
        salesmanEntity.setSalesAmount(100);
        salesmanEntity.setTransactionDate(LocalDate.now());

        when(salesmanRepository.existsById(salesmanEntity.getTransactionId())).thenReturn(true);
        when(salesmanRepository.save(any(SalesmanEntity.class))).thenReturn(salesmanEntity);

        salesmanService.updateTransaction(salesmanEntity);

        verify(salesmanRepository, times(1)).save(salesmanEntity);
    }
}
