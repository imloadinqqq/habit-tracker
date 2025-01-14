package com.imloadinqqq.consistency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.imloadinqqq.consistency.entity.Habit;
import com.imloadinqqq.consistency.service.HabitService;

@CrossOrigin("http://localhost:3000")
@Controller
@RequestMapping("/api")
public class HabitController {

  private HabitService habitService;

  public HabitController(HabitService habitService) {
    this.habitService = habitService;
  }

  @GetMapping("/habits")
  public ResponseEntity<List<Habit>> getAllHabits() {
    List<Habit> habits = habitService.getAllHabits();
    return ResponseEntity.ok(habits);
  }

  @GetMapping("/habits/{id}")
  public ResponseEntity<Habit> getHabitById(@PathVariable Long id) {
    Habit habit = habitService.getHabitById(id);
    return ResponseEntity.ok(habit);
  }

  @PostMapping("/habits")
  public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
    Habit createdHabit = habitService.createHabit(habit);
    return ResponseEntity.ok(createdHabit);
  }

  @DeleteMapping("/habits/{id}")
  public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
    habitService.deleteHabitById(id);
    return ResponseEntity.noContent().build();
  }

}
