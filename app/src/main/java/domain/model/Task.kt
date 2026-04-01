package domain.model

data class Task(
    val id: Int = 0,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val deadline: Long? = null,
    val priority: Priority = Priority.NONE
)

enum class Priority {
    NONE, LOW, MEDIUM, HIGH
}