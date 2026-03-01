package com.rosana.yourdead.domain.usecase

import com.rosana.yourdead.domain.repository.TaskRepository
import javax.inject.Inject

class ToggleTaskCompletedUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskId: Int, completed: Boolean) =
        repository.setCompleted(taskId, completed)
}