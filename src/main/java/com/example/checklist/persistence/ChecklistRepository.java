package com.example.checklist.persistence;

import com.example.checklist.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<ChecklistItem, Long> {
}
