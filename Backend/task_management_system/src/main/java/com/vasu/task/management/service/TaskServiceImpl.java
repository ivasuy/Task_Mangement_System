package com.vasu.task.management.service;

import com.vasu.task.management.entity.TaskEntity;
import com.vasu.task.management.model.Task;
import com.vasu.task.management.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task,taskEntity);
        taskRepository.save(taskEntity);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        List<Task> tasks = taskEntities
                .stream()
                .map(task -> new Task(
                        task.getId(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getCreatedDate(),
                        task.getUpdatedDate())).toList();
        return tasks;
    }

    @Override
    public boolean deleteTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskRepository.delete(taskEntity);
        return true;
    }

    @Override
    public Task getTaskById(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        Task task = new Task();
        BeanUtils.copyProperties(taskEntity,task);
        return task;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskEntity.setDescription(task.getDescription());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setCreatedDate(task.getCreatedDate());
        taskEntity.setUpdatedDate(task.getUpdatedDate());
        taskRepository.save(taskEntity);
        return task;
    }
}
