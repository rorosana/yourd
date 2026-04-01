package com.rosana.yourdead.domain.usecase

import domain.model.Task
import com.rosana.yourdead.domain.repository.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) = repository.updateTask(task)
}