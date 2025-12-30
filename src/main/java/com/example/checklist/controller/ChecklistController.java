package com.example.checklist.controller;

import com.example.checklist.model.ChecklistItem;
import com.example.checklist.persistence.ChecklistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

    private final ChecklistRepository repo;

    public ChecklistController(ChecklistRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ChecklistItem> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ChecklistItem create(@RequestBody ChecklistItem item) {
        return repo.save(item);
    }

    @PutMapping("/{id}")
    public ChecklistItem toggle(@PathVariable Long id) {
        ChecklistItem item = repo.findById(id)
                .orElseThrow();
        item.setCompleted(!item.getCompleted());
        return repo.save(item);
    }

}
