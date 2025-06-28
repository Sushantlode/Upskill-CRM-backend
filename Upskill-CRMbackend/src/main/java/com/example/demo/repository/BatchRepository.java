package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, String> {
    // String because batchName is the primary key
}
