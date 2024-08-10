package com.example.finalsofteng.Service;

import com.example.finalsofteng.Entity.SalesmanEntity;
import com.example.finalsofteng.Repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    // Mevcut işlemleri getirme
    public List<SalesmanEntity> getAllTransactions() {
        return salesmanRepository.findAll();
    }

    // Yeni işlem kaydetme
    public void saveTransaction(SalesmanEntity salesmanEntity) {
        salesmanRepository.save(salesmanEntity);
    }

    // ID ile işlem getirme
    public SalesmanEntity getTransactionById(Long id) {
        Optional<SalesmanEntity> transaction = salesmanRepository.findById(id);
        return transaction.orElse(null); // Veya uygun bir hata işleme stratejisi
    }

    // İşlemi güncelleme
    public void updateTransaction(SalesmanEntity transaction) {
        if (salesmanRepository.existsById(transaction.getTransactionId())) {
            salesmanRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found");
        }
    }
}
