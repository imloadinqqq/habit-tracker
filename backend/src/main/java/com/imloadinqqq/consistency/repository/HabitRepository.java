package com.imloadinqqq.consistency.repository;

import com.imloadinqqq.consistency.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {

}
