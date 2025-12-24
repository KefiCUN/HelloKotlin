// Мини-задание: "Калькулятор с защитой от дурака"
// Контекст:
// Ты создаешь калькулятор, который должен безопасно обрабатывать пользовательский ввод.

// Задача:
// Создай функцию safeCalculate, которая:

// Принимает два числа (a: Double, b: Double) и операцию (operation: String)

// Поддерживает операции: "+", "-", "*", "/"

// Возвращает результат или null при ошибке

// Обрабатывает ВСЕ возможные исключения

// Требования:
// Обработка деления на ноль → вернуть null

// Неизвестная операция → вернуть null

// Любые другие ошибки → вернуть null

// Успешный расчет → вернуть результат

// Используй конструкцию try-catch с возвращением значения

fun safeCalculate(a: Double, b: Double, operation: String): Double? {
    try{
        when(operation) {
            "+" -> return a+b
            "-" -> return a-b
            "/" -> try{return a/b} catch (e: Exception) {return null}
            "*" -> return a*b
            else -> return null
        }
    } catch (e: Exception) {
        return null
    }
}


fun main() {
    println(safeCalculate(10.0, 5.0, "+"))   // 15.0
    println(safeCalculate(10.0, 5.0, "-"))   // 5.0
    println(safeCalculate(10.0, 5.0, "*"))   // 50.0
    println(safeCalculate(10.0, 5.0, "/"))   // 2.0
    
    println(safeCalculate(10.0, 0.0, "/"))   // null (деление на ноль)
    println(safeCalculate(10.0, 5.0, "^"))   // null (неизвестная операция)
    
    // Бонус: с пользовательским вводом
    val result = safeCalculate(5.0, 2.0, "+") ?: "Ошибка"
    println("Результат: $result") // 7.0
}