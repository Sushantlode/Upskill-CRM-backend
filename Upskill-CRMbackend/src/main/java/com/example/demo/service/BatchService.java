package com.example.demo.service;

import com.example.demo.model.Batch;
import com.example.demo.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    public Optional<Batch> getBatchByName(String batchName) {
        return batchRepository.findById(batchName);
    }

    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public Batch updateBatch(String batchName, Batch updatedBatch) {
        return batchRepository.findById(batchName).map(existing -> {
            existing.setBatchSubject(updatedBatch.getBatchSubject());
            existing.setStartDate(updatedBatch.getStartDate());
            existing.setEndDate(updatedBatch.getEndDate());
            existing.setMode(updatedBatch.getMode());
            return batchRepository.save(existing);
        }).orElseGet(() -> {
            updatedBatch.setBatchName(batchName);
            return batchRepository.save(updatedBatch);
        });
    }

    public void deleteBatch(String batchName) {
        batchRepository.deleteById(batchName);
    }
}

