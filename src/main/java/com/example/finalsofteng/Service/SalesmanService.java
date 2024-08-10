package com.example.finalsofteng.Service;

import com.example.finalsofteng.Entity.SalesmanEntity;
import com.example.finalsofteng.Repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesmanService {
    // https://github.com/cnuhay/finalSoftEng
    @Autowired
    private SalesmanRepository salesmanRepository;

    // Return All Transaction on DB
    public List<SalesmanEntity> getAllTransactions() {
        return salesmanRepository.findAll();
    }

    // Insert transaction to DB
    public void saveTransaction(SalesmanEntity salesmanEntity) {
        salesmanRepository.save(salesmanEntity);
    }

    // Return transaction filtered by ID
    public SalesmanEntity getTransactionById(Long id) {
        Optional<SalesmanEntity> transaction = salesmanRepository.findById(id);
        return transaction.orElse(null);
    }

    // Updates transaction
    public void updateTransaction(SalesmanEntity transaction) {
        if (salesmanRepository.existsById(transaction.getTransactionId())) {
            salesmanRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found");
        }
    }
    // Deletes transaction
    public void deleteTransaction(Long transactionId) {
        salesmanRepository.deleteById(transactionId);
    }
}
