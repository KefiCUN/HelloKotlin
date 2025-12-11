// 🔧 Практическое задание (улучшенное)
// Напиши программу, которая:

// Определяет три функции:

// sum(a: Int, b: Int): Int — складывает числа.
// subtract(a: Int, b: Int): Int — вычитает числа.
// multiply(a: Int, b: Int): Int — умножает числа.

// Создаёт функцию calculate(a: Int, b: Int, operation: (Int, Int) -> Int), которая принимает два числа и ссылку на функцию для выполнения операции.
// В main вызови calculate три раза:
// один раз с ::sum,
// один раз с ::subtract,
// один раз с ::multiply.
// Выведи результаты в консоль.

fun multiply(a: Int, b: Int): Int = a * b;

fun sum(a: Int, b: Int): Int = a + b;

fun subtract(a: Int, b: Int): Int = a - b;

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int){
    println(operation(a,b));
}

fun main(args: Array<String>) {
    
    calculate(10, 3, ::sum);
    calculate( 10, 3, ::subtract);
    calculate( 10,3, ::multiply);
}