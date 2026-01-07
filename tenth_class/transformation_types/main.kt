

fun safeSum(
    a: Any?,
    b: Any?
): Int {

    try{
        var transformA: Int? = null
        var transformB: Int? = null
        var arrForTransform = listOf(a,b)

        for (i in arrForTransform) {
            if((i is Int) || (i is Long) || (i is Short) || (i is Byte) || (i is Double) || (i is Float)) {
                if(i == a) transformA = i.toInt()
                else transformB = i.toInt()
            } else if(i is String) {
                if(i == a) transformA = i.toIntOrNull() ?: 0
                else transformB = i.toIntOrNull() ?: 0
            } else {
                if(i == a) transformA = 0
                else transformB = 0
            }
        }

        return (transformA?:0) + (transformB?:0)
    } catch(e:Exception) {
        e.printStackTrace()
        return 0 
    }
}


fun main(args: Array<String>) {

    println(safeSum(10, "20")) 
    println(safeSum("10", 5.7)) 
    println(safeSum("abc", null))
}