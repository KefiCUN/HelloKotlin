open class ReadOnlyBox<out T> (val item: T){
    fun get(): T {
        return item
    }
} 