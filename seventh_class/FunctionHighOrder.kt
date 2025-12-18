// 🔧 Практическое задание (смысловое)
// Сделай программу «Мини‑трансформатор строк»:
// Определи функцию transform(text: String, operation: (String) -> String): String, которая принимает строку и функцию‑операцию.
// Определи несколько функций‑операций:

// toUpper(text: String): String — переводит строку в верхний регистр.
// reverse(text: String): String — разворачивает строку.
// addExclamation(text: String): String — добавляет в конец строки "!".

// В main вызови transform три раза для строки "kotlin", передавая разные операции.
// Выведи результаты.

fun toUpper(text: String): String = text.uppercase();

fun reverse(text: String): String {

    var reverseStr:String = "";

    for (i in (text.length - 1) downTo 0) {
        reverseStr += text[i];
    }

    return reverseStr;
}

fun addExclamation(text: String): String = text + "!";

fun transform(text: String, operation: (String) -> String): String {
    println(operation(text));
}

fun main(args: Array<String>) {
    
    transform("kotlin",::toUpper);
    transform("kotlin", ::reverse);
    transform("kotlin", ::addExclamation);
}