// Задача: "Калькулятор скидок"
// Что сделать:
// Создать 4 функции в одном файле:

// calculatePrice(price: Double, discount: Double = 0.0) — считает цену со скидкой
// printReceipt(item: String, price: Double, quantity: Int = 1) — печатает чек для одного товара
// applySeasonalDiscount(price: Double, isHoliday: Boolean = false) — применяет сезонную скидку 15% если isHoliday = true
// main() — тестирует все функции

// Правила:

// Каждая функция ≤ 5 строк
// Использовать значения по умолчанию
// В main() вызвать функции с разными комбинациями аргументов (позиционно, по имени, с пропуском необязательных)

// Пример вывода:

// text
// Цена со скидкой: 85.0
// Чек: Товар "Молоко" - 80.0 руб × 2 = 160.0 руб
// Сезонная скидка: 85.0 → 72.25
// Цель: Попрактиковать синтаксис функций, параметры, значения по умолчанию, именованные аргументы.

// Ограничение: Только эти 4 функции, без классов, без меню. Просто объявил → вызвал в main.

fun calculatePrice(price: Double, discount: Double = 0.0):Double = price - (discount*price/100);

fun printReceipt(item: String, price: Double, quantity: Int = 1) {
    println("Чек: Товар \"$item\" - $price руб * $quantity = ${price*quantity} ");
} 


fun applySeasonalDiscount(price: Double, isHoliday: Boolean = false):Double = if (isHoliday) price - (15*price/100) else price;


fun main(args: Array<String>) {
    println("Цена со скидкой: " + calculatePrice(100.0, 10));
    println("Цена со скидкой: " + calculatePrice(price = 100.0, discount = 10));
    println("Цена со скидкой: " + calculatePrice(price = 100.0));
    printReceipt("Молоко", 100.0,5 );
    printReceipt(price = 100.0, item = "Молоко",quantity = 5);
    printReceipt("Молоко", 100.0);
    println("Сезонная скидка: 100 → " + applySeasonalDiscount(100.0, true));
    println("Сезонная скидка: 100 → " + applySeasonalDiscount(price = 100.0, isHoliday = true));
    println("Сезонная скидка: 100 → " + applySeasonalDiscount(price = 100.0));
}