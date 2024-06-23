package com.rnazarapps.server.model.repos;

import com.rnazarapps.server.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
