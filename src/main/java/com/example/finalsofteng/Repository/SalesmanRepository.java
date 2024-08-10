package com.example.finalsofteng.Repository;

import com.example.finalsofteng.Entity.SalesmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
// https://github.com/cnuhay/finalSoftEng
public interface SalesmanRepository extends JpaRepository<SalesmanEntity, Long> {
}
