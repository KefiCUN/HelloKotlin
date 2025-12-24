// Мини-задание: "Безопасная система коробок"
// Контекст:
// Ты создаешь систему хранения с тремя типами коробок:

// Только для чтения (можно брать предметы)

// Только для записи (можно класть предметы)

// Для чтения и записи (можно и брать, и класть)

// Задача:
// Создай иерархию классов:

// kotlin
// open class Item
// class Book : Item()
// class Electronics : Item()
// И три класса коробок:

// ReadOnlyBox<out T> — только для чтения

// Свойство: val item: T (только val!)

// Метод: fun getItem(): T

// WriteOnlyBox<in T> — только для записи

// Метод: fun putItem(item: T)

// ReadWriteBox<T> — для чтения и записи (инвариантный)

// Свойство: var item: T (var!)

// Метод: fun getItem(): T

// Метод: fun putItem(item: T)


fun main() {
    // 1. Тест ReadOnlyBox (ковариантность)
    val bookBox = ReadOnlyBox(Book())
    val itemBox: ReadOnlyBox<Item> = bookBox // ДОЛЖНО РАБОТАТЬ!
    println("Можно читать как Item: ${itemBox.get()}")
    
    // 2. Тест WriteOnlyBox (контравариантность)  
    val itemWriter = WriteOnlyBox<Item>()
    val bookWriter: WriteOnlyBox<Book> = itemWriter // ДОЛЖНО РАБОТАТЬ!
    bookWriter.put(Book())
    
    // 3. Тест ReadWriteBox (инвариантность)
    val bookReadWrite = ReadWriteBox(Book())
    // val itemReadWrite: ReadWriteBox<Item> = bookReadWrite // ОШИБКА! Не должно работать
    // val bookFromReadWrite: ReadWriteBox<Book> = itemReadWrite // ОШИБКА! Не должно работать
    
    println("Все тесты прошли!")
}