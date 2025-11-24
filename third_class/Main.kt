fun main() {
    // === КОЛЛЕКЦИИ ===
    
    // 1. LIST - история операций (упорядоченная, с дубликатами)
    val operationsHistory: MutableList<String> = mutableListOf()
    
    // 2. SET - жанры книг (уникальные, неупорядоченные)
    val bookGenres: MutableSet<String> = mutableSetOf()
    
    // 3. MAP - книги: название -> количество доступных экземпляров
    val libraryBooks: MutableMap<String, Int> = mutableMapOf()
    
    // 4. MAP - читатели: ID читателя -> информация о читателе
    val readers: MutableMap<Int, String> = mutableMapOf()
    
    // 5. MAP - выданные книги: ID читателя -> список названий книг
    val borrowedBooks: MutableMap<Int, MutableList<String>> = mutableMapOf()

    // === ФУНКЦИИ ДЛЯ РЕАЛИЗАЦИИ ===

    // Функция 1: Добавить книгу в библиотеку
    fun addBook(title: String, genre: String, quantity: Int) {
        // TODO: Реализовать:
        // - Добавить жанр в bookGenres
        bookGenres.add(genre)
        // - Добавить/обновить книгу в libraryBooks (учесть если книга уже есть)
        libraryBooks[title] = quantity
        // - Добавить запись в operationsHistory
        operationsHistory.add("Добавляется жанр с названием $genre, добавляется книга с названием $title и количеством $quantity")
        // - Вывести сообщение о результате
        println("Книга успешно добавлена")
    }

    // Функция 2: Зарегистрировать читателя
    fun registerReader(readerId: Int, name: String) {
        // TODO: Реализовать:
        // - Проверить, нет ли уже читателя с таким ID
        if (!(readerId in readers.keys)&&!(name in readers.values)){
            // - Добавить читателя в readers
            readers[readerId]=name
            // - Создать пустой список для этого читателя в borrowedBooks
            borrowedBooks[readerId] = mutableListOf() 
            // - Добавить запись в operationsHistory
            operationsHistory.add("Добавляется читатель $readerId с именем $name")
            println("Пользователь успешно добавлен")
        }else{
            println("Пользователь уже есть с таким Id")
            operationsHistory.add("Попытка создать читатель $readerId с именем $name, не успешно, такой пользователь уже есть")
        }
    }

    // Функция 3: Выдать книгу читателю
    fun lendBook(readerId: Int, bookTitle: String) {
        // TODO: Реализовать:
        // - Проверить, есть ли читатель
        if (readerId in readers.keys){
            // - Проверить, есть ли книга и доступна ли она
            if (bookTitle in libraryBooks.keys){
                // - Уменьшить количество доступных книг в libraryBooks
                libraryBooks[bookTitle] = (libraryBooks[bookTitle]?:0)-1
                // - Добавить книгу в список borrowedBooks для этого читателя
                borrowedBooks[readerId]?.add(bookTitle)
                // - Добавить запись в operationsHistory
                operationsHistory.add("Добавлен доступ к книге $bookTitle пользователю ${readers[readerId]} ")
            }else{
                operationsHistory.add("Попытка дать доступ к книге к книге $bookTitle пользователю ${readers[readerId]}, не успешно, такой книги не существует или она не доступна")
            }
            
        }else{
            operationsHistory.add("Попытка дать доступ к книге к книге $bookTitle пользователю ${readers[readerId]}, не успешно, пользователя с таким Id нет")
           
        }

    }

    // Функция 4: Вернуть книгу в библиотеку
    fun returnBook(readerId: Int, bookTitle: String) {
        // TODO: Реализовать:
        // - Проверить, есть ли читатель
         if (readerId in readers.keys){
            // - Проверить, есть ли у него эта книга
            if (borrowedBooks[readerId]?.contains(bookTitle)==true){
                // - Увеличить количество книг в libraryBooks
                libraryBooks[bookTitle]= (libraryBooks[bookTitle]?:0)+1
                // - Удалить книгу из списка borrowedBooks
                borrowedBooks[readerId]?.remove(bookTitle)
                // - Добавить запись в operationsHistory
                operationsHistory.add("Книга $bookTitle успешно удалена у польхователя $readerId")
            }else{
                operationsHistory.add("Попытка вернуть книгу $bookTitle, не успешна, такой книги у пользователя $readerId нет")
            }
        }else{
            operationsHistory.add("Попытка вернуть книгу $bookTitle, не успешна, пользователя с таким Id нет")
        }
    }

    // Функция 5: Показать статистику
    fun showStatistics() {
        // TODO: Реализовать вывод:
        // - Количество книг в библиотеке (всего экземпляров) 
        println("Количество книг в библиотеке ${libraryBooks.count()}")
        // - Количество уникальных книг (названий)
        println("Количество уникальных книг ${libraryBooks.keys.count()}")
        // - Количество жанров
        
        println("Количество жанров ${bookGenres.count()}")
        // - Количество читателей
        println("Количество читателей ${readers.count()}")
        // - Самые популярные жанры
        println("Самые популярные жанры ${bookGenres}")
    }

    // Функция 6: Показать историю операций
    fun showOperationsHistory() {
        // TODO: Вывести последние 10 операций
        println("Операция ${operationsHistory}")
    }

    // === ТЕСТИРОВАНИЕ ПРОГРАММЫ ===
    
    // Добавляем книги
    addBook("Преступление и наказание", "Классика", 3)
    addBook("Мастер и Маргарита", "Фэнтези", 2)
    addBook("1984", "Антиутопия", 5)
    addBook("Гарри Поттер", "Фэнтези", 4)

    // Регистрируем читателей
    registerReader(1, "Иван Иванов")
    registerReader(2, "Мария Петрова")
    registerReader(3, "Алексей Сидоров")

    // Выдаем книги
    lendBook(1, "Преступление и наказание")
    lendBook(1, "1984")
    lendBook(2, "Гарри Поттер")
    lendBook(3, "Мастер и Маргарита")

    // Возвращаем книги
    returnBook(1, "1984")
    returnBook(2, "Гарри Поттер")

    // Показываем статистику
    showStatistics()
    
    // Показываем историю операций
    showOperationsHistory()
}