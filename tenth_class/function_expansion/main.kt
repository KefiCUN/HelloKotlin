class Task (
    var title: String = "",
    var done: Boolean = false,
    var subtasks: MutableList<Task> = mutableListOf()
) {
    fun task(init: Task.() -> Unit){
        var task = Task()
        task.init()
        subtasks.add(task)
    }

}


class TodoList() {
    private var tasksList = mutableListOf<Task>()

    fun doInit(init: Task.() -> Unit, task: Task) {
        task.init()
        tasksList.add(task)
    }

    fun task(init: Task.() -> Unit) = doInit(init, Task())

    fun render(): String {
        return tasksList.joinToString("\n") { t ->
            var mark = if(t.done) "[x]" else "[ ]"
            var subtasks = " "
            if(t.subtasks.size != 0) {
                subtasks = t.subtasks.joinToString("\n") { t2 ->
                    var mark = if(t2.done) "[x]" else "[ ]"
                    "\n\t$mark ${t2.title}"
                }
            }
            "$mark ${t.title} {$subtasks\n}"
        }
    }

}

fun todoList(init: TodoList.() -> Unit): TodoList {
    val todoList = TodoList()
    todoList.init()
    return  todoList
}


fun main() {
    val todoList = todoList {
        task {
            title = "Task 1"
            done = true
            task {
                title = "Task 2"
                done = false
            }
        }
    }
    println(todoList.render())
}