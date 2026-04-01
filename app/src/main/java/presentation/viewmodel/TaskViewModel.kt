package com.rosana.yourdead.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Task
import com.rosana.yourdead.domain.usecase.AddTaskUseCase
import com.rosana.yourdead.domain.usecase.DeleteTaskUseCase
import com.rosana.yourdead.domain.usecase.ObserveTasksUseCase
import com.rosana.yourdead.domain.usecase.ToggleTaskCompletedUseCase
import com.rosana.yourdead.domain.usecase.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val observeTasks: ObserveTasksUseCase,
    private val addTask: AddTaskUseCase,
    private val updateTask: UpdateTaskUseCase,
    private val deleteTask: DeleteTaskUseCase,
    private val toggleCompleted: ToggleTaskCompletedUseCase
) : ViewModel() {

    val tasks: StateFlow<List<Task>> = observeTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            addTask(Task(title = title, description = description))
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTask(task)
        }
    }

    fun toggleCompleted(taskId: Int, completed: Boolean) {
        viewModelScope.launch {
            toggleCompleted(taskId, completed)
        }
    }
}