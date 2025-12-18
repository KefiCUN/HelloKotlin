// Маленькое задание по vararg
// Задача: "Сборщик статистики"
// Что сделать:
// Создать 3 функции в одном файле:

// printAll(vararg items: String) — печатает все переданные строки через запятую
// average(vararg numbers: Int): Double — возвращает среднее арифметическое (0 если чисел нет)
// joinWithPrefix(prefix: String, vararg words: String): String — соединяет слова через пробел с префиксом

// Правила:
// Каждая функция ≤ 4 строк
// В main() протестировать все случаи:
// Без аргументов
// С одним аргументом
// С несколькими аргументами
// С массивом через *
// Для joinWithPrefix показать передачу параметров после vararg
// Пример вывода:

// text
// Строки: Kotlin, Java, Python
// Среднее: 10.5
// Результат: Предметы: Математика Физика Химия
// Цель: Попрактиковать vararg, оператор *, разные варианты вызова.
// Ограничение: Только эти 3 функции + main(). Без классов.


fun printAll(vararg items: String) {
    var str = "";
    for (item in items)
        str += item + ", ";
    println(str);
}

fun average(vararg numbers: Int): Double {
    if (numbers.size == 0) return 0.0;
    else {
        var sum:Int = 0;
        for (number in numbers) {
            sum += number;
        }
        return (sum.toDouble()) / (numbers.size);
    }
}

fun joinWithPrefix(prefix: String, vararg words: String, postfix:Int): String {
    var sum = prefix + " ";
    for (word in words) {
        sum += word + " ";
    }
    return sum + postfix;
}


fun main() {
    printAll();
    printAll("Hello World");
    println(average(1,2,3));
    var arr:Array<String> = arrayOf("Hellow", "Worlds", "Here", "There");
    println(joinWithPrefix("Hi", *arr, postfix = 1));
}