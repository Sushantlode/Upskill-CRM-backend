package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import com.example.demo.model.Batch;
import com.example.demo.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin("*") // optional for frontend access
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{batchName}")
    public Optional<Batch> getBatchByName(@PathVariable String batchName) {
        return batchService.getBatchByName(batchName);
    }

    @PostMapping
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    @PutMapping("/{batchName}")
    public Batch updateBatch(@PathVariable String batchName, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchName, updatedBatch);
    }

    @DeleteMapping("/{batchName}")
    public void deleteBatch(@PathVariable String batchName) {
        batchService.deleteBatch(batchName);
    }
}
