// Практическое задание (короткое, интересное, с концом)
// Задача: написать функцию safeSum(a: Any?, b: Any?): Int, которая принимает два значения любого типа (Any?) и возвращает их сумму как Int по правилам:

// Если аргумент — числовой тип (Int, Long, Short, Byte, Double, Float), преобразовать его в Int (через встроенные toInt()/toDouble()→toInt()) и использовать значение.
// Если аргумент — строка, пытаемся преобразовать её в Int через toInt(); если преобразование не удалось, считаем значение 0.
// Для любых других типов или null считаем значение 0.
// Функция должна безопасно обрабатывать исключения и возвращать итоговую сумму.
// Пример ожидаемого поведения:

// safeSum(10, "20") -> 30
// safeSum("10", 5.7) -> 15 (5.7 -> toInt() = 5)
// safeSum("abc", null) -> 0
// Реализуйте функцию и небольшой main, который демонстрирует все три примера выше и печатает результаты.Resolved merge conflict in main.kt

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