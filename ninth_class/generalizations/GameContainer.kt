

class GameContainer<T>(
    private val items: MutableList<T>,
    val name: String,
    val capacity: Int = 10 
) {
    val isFull: Boolean = false
    val isEmpty: Boolean = true

    companion object {
        fun <T> transferItems(from: GameContainer<T>, to: GameContainer<T>): Int {
            var counterMoves: Int = 0
            for(i in from.items) {
                for(j in to.items){
                    if(i == j) continue
                    else if(to.isFull == true) return counterMoves
                    else {
                        to.items.add(i)
                        counterMoves++
                    } 
                }
            }
            return counterMoves
        }


    }

    fun addItem(item: T): Boolean {
        //Добавить вместо проверки на полноту функцию которая это проверяет
        if(items.size < capacity) {
            items.add(item)
            return true
        } else return false
    }

    fun removeItem(): T? {
        if(isEmpty)  {
            return null
        } else {
            items.removeAt(items.size - 1)
            return items[items.size - 1]
        }
    }

    fun peekItem(): T? {
        if(isEmpty) return null
        else return items[items.size - 1]
    }

    fun findItem(predicate: (T) -> Boolean): T? {
        for(i in items) {
            if(predicate(i)) {return i}
        }
        return null
        
    }

    fun countItems(predicate: (T) -> Boolean): Int {
        var count: Int = 0
        for(i in items) {
            if(predicate(i)) count++
        }
       return count
    }

}