package com.rosana.yourdead.data.local

import com.rosana.yourdead.domain.model.Task

// Convert domain Task to database TaskEntity
fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        createdAt = createdAt
    )
}

// Convert database TaskEntity to domain Task
fun TaskEntity.toDomain(): Task {
    return Task(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        createdAt = createdAt
    )
}
