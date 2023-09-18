package com.vasu.task.management.service;

import com.vasu.task.management.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    List<Task> getAllTasks();

    boolean deleteTask(Long id);

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);
}
