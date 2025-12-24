open class ReadWriteBox<T>(var item: T) {
    fun get(): T {
        return item
    }
    fun put(_item: T) {
        item = _item
    }
}