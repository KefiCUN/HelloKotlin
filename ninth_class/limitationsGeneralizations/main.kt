// Мини-задание: "Умный компаратор цен"
// Контекст:
// Ты создаешь систему для сравнения товаров в интернет-магазине. Товары могут быть разными, но у всех есть цена.

// Задача (одна, конкретная):
// Создай единственную функцию compareByBestValue, которая:

// Принимает два товара ЛЮБОГО типа

// Оба товара должны иметь цену (price: Double) и рейтинг (rating: Double)

// Возвращает товар с лучшим соотношением "цена/качество"

// Формула: рейтинг / цена (чем выше значение, тем лучше)

// Требования:
// Используй ограничения обобщений

// Создай интерфейс Valuable, который требует свойства price и rating

// Функция должна работать с ЛЮБЫМИ типами, реализующими Valuable

// Верни товар с БОЛЬШИМ значением rating / price



fun <T: Valuable> compareByBestValue(item1: T, item2: T): T = if(((item1.rating)/(item1.price)) < ((item2.rating)/(item2.price))) item2 else item1

fun main() {
    // Телефоны
    data class Phone(val brand: String, override val price: Double, override val rating: Double) : Valuable
    
    // Книги  
    data class Book(val title: String, override val price: Double, override val rating: Double) : Valuable
    
    val phone1 = Phone("Xiaomi", 25000.0, 4.5)    // 4.5 / 25000 = 0.00018
    val phone2 = Phone("iPhone", 80000.0, 4.8)    // 4.8 / 80000 = 0.00006
    
    val book1 = Book("Kotlin Guide", 1500.0, 4.9) // 4.9 / 1500 = 0.00326
    val book2 = Book("Java Bible", 2000.0, 4.7)   // 4.7 / 2000 = 0.00235
    
    // Сравниваем телефоны
    val bestPhone = compareByBestValue(phone1, phone2)
    println("Лучший телефон: ${bestPhone.brand}") // Xiaomi (лучшее соотношение)
    
    // Сравниваем книги  
    val bestBook = compareByBestValue(book1, book2)
    println("Лучшая книга: ${bestBook.title}") // Kotlin Guide
    
    // Можно даже сравнивать телефон с книгой!
    val bestOverall = compareByBestValue(phone1, book1)
    println("Лучшая покупка: ${bestOverall::class.simpleName}") // Book
}