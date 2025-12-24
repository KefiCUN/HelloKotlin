open class WriteOnlyBox<in T> () {
    fun put(item: T) {
        println("Кладем $item")
    }
}