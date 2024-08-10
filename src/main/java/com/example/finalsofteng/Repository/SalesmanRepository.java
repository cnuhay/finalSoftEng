package com.example.finalsofteng.Repository;

import com.example.finalsofteng.Entity.SalesmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<SalesmanEntity, Long> {
}
