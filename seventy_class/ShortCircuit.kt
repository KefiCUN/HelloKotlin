
// Объяснение задания (без кода):
// Основная идея:
// Создать несколько функций-счётчиков, каждый из которых помнит своё текущее значение, даже если мы вызываем их в разных местах программы.

// Часть 1: Простой счётчик (создаём замыкание)
// Создать функцию createCounter(), которая:

// Внутри себя создаёт переменную count (начинается с 0)

// Возвращает другую функцию, которая:

// При вызове увеличивает count на 1

// Возвращает новое значение count

// Как это работает:

// val counter1 = createCounter() — создаём первый счётчик

// counter1() → возвращает 1

// counter1() → возвращает 2 (помнит, что было 1)

// counter1() → возвращает 3 (помнит, что было 2)

// Часть 2: Счётчик с начальным значением
// Создать функцию createCounter(start: Int), которая:

// Принимает начальное значение

// Возвращает функцию, которая увеличивает и возвращает значение

// Пример:

// val counter2 = createCounter(10)

// counter2() → 11

// counter2() → 12

// Часть 3: Счётчик с шагом
// Создать функцию createCounter(start: Int, step: Int), которая:

// Принимает начальное значение и шаг

// Возвращает функцию, которая увеличивает на шаг

// Пример:

// val counter3 = createCounter(0, 5)

// counter3() → 5

// counter3() → 10

// counter3() → 15

// Часть 4: Демонстрация
// Показать, что каждый счётчик независим и помнит своё состояние:

// Создать два счётчика

// Вызвать каждый несколько раз

// Убедиться, что они считают независимо


fun createCounter(): () -> Int {
    var count = 0 ;
    return {++count} ;
}

fun createCounter(start: Int): () -> Int {
    var x = start;
    return {++x};
}

fun createCounter(start: Int, step: Int): () -> Int {
    var x = start;
    return { x = x + step;x; };
}


fun main(args: Array<String>) {
    val counter1 = createCounter();
    val counter2 = createCounter(10);
    val counter3 = createCounter(12,2);
    println(counter1());
    println(counter2());
    println(counter3());
    println(counter2());
    println(counter3());
    println(counter1());

}