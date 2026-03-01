package com.rosana.yourdead.domain.usecase

import com.rosana.yourdead.domain.model.Task
import com.rosana.yourdead.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> = repository.observeTasks()
}