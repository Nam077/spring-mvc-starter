package com.example.demo.repositories;

import com.example.demo.models.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SinhvienRepository extends JpaRepository<Sinhvien, Integer>, JpaSpecificationExecutor<Sinhvien> {

}