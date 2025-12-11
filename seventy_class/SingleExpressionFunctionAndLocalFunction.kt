// Маленькое задание по однострочным и локальным функциям
// Задача: "Калькулятор с валидацией"
// Что сделать:

// Создать 2 функции в одном файле:

// calculateExpression(a: Int, b: Int, op: Char): Int — вычисляет выражение
// main() — тестирует

// Внутри calculateExpression создать:
// Однострочную локальную функцию validateNumber(x: Int) — возвращает true если x от -100 до 100
// Однострочную локальную функцию validateOperator(op: Char) — возвращает true если op: '+', '-', '*', '/'

// Логику вычисления с проверками
// Правила:

// Если числа или оператор невалидны — возвращать 0
// Поддерживать операции: +, -, *, / (целочисленное деление)
// При делении на 0 возвращать 0
// Всю валидацию делать через локальные функции
// Саму calculateExpression сделать обычной (не однострочной)

// Пример вывода в main():

// text
// 10 + 20 = 30
// 100 + 200 = 0 (число вне диапазона)
// 50 / 0 = 0 (деление на ноль)
// 50 / 3 = 16
// 50 & 30 = 0 (неверный оператор)
// Цель: Попрактиковать однострочные и локальные функции вместе.

// Ограничение: Только эти 2 функции в файле.

fun calculateExpression(a: Int, b: Int, op: Char): Int {
    
    fun validateNumber(x: Int) = (x >= -100) && (x < 100)

    fun validateOperator(op: Char) = (op == '+') || (op == '-') || (op == '*') || (op == '/')

    if ((validateNumber(a)) && (validateNumber(b)) && (validateOperator(op))){
        return when(op){
            '+' -> a+b;
            '-' -> a-b;
            '*' -> a*b;
            '/' -> {
                if ((a == 0) || (b == 0) ) 0;
                else a/b;
            };
            else -> 0;
        };
    }  
    else return 0;
}

fun main(){
    println(calculateExpression(10,20,'+'));
    println(calculateExpression(100,200,'+'));
    println(calculateExpression(50,0,'/'));
    println(calculateExpression(50,3,'/'));
    println(calculateExpression(50,30,'&'));
}