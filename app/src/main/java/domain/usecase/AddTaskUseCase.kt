package com.rosana.yourdead.domain.usecase

import com.rosana.yourdead.domain.model.Task
import com.rosana.yourdead.domain.repository.TaskRepository
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) = repository.addTask(task)
}