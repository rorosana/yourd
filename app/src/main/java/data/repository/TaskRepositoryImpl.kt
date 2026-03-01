package com.rosana.yourdead.data.repository

import com.rosana.yourdead.data.local.TaskDao
import com.rosana.yourdead.data.local.toDomain
import com.rosana.yourdead.data.local.toEntity
import com.rosana.yourdead.domain.model.Task
import com.rosana.yourdead.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : TaskRepository {

    override fun observeTasks(): Flow<List<Task>> =
        dao.observeTasks().map { list -> list.map { it.toDomain() } }

    override suspend fun addTask(task: Task) =
        dao.insert(task.toEntity())

    override suspend fun updateTask(task: Task) =
        dao.update(task.toEntity())

    override suspend fun deleteTask(task: Task) =
        dao.delete(task.toEntity())

    override suspend fun setCompleted(taskId: Int, completed: Boolean) =
        dao.setCompleted(taskId, completed)
}