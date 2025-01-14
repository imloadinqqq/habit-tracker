package com.imloadinqqq.consistency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imloadinqqq.consistency.entity.Habit;
import com.imloadinqqq.consistency.repository.HabitRepository;

@Service
public class HabitService {

  @Autowired
  private HabitRepository habitRepository;

  public Habit createHabit(Habit habit) {
    return habitRepository.save(habit);
  }

  public Habit getHabitById(Long id) {
    return habitRepository.findById(id).orElseThrow(() -> new RuntimeException("Habit not found."));
  }

  public List<Habit> getAllHabits() {
    return habitRepository.findAll();
  }

  public void deleteHabitById(Long id) {
    habitRepository.deleteById(id);
  }
}
