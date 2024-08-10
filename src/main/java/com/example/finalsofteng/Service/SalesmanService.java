package com.example.finalsofteng.Service;

import com.example.finalsofteng.Entity.SalesmanEntity;
import com.example.finalsofteng.Repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    public List<SalesmanEntity> getAllTransactions() {
        return salesmanRepository.findAll();
    }

    public void saveTransaction(SalesmanEntity salesmanEntity) {
        salesmanRepository.save(salesmanEntity);
    }
}
