// Задание: "Улучшенная библиотека с конструкторами"
// Цель: Добавить конструкторы в существующие классы библиотеки.
// Что нужно сделать с твоим кодом:


// class Book ( val title:String, val author: String, var year:Int) {
 

//     var isBorrowed:Boolean = false;
// Задачи для Book:

// Первичный конструктор с параметрами: title, author, year

// Вторичный конструктор только с title и author (год = текущий)

// Блок init для проверки: год не может быть отрицательным

// Значения по умолчанию в конструкторе

// 2. Класс Library — добавить конструкторы:
// Сейчас: Создаёшь пустую библиотеку и добавляешь книги по одной.

// Стало: Создавать библиотеку сразу с книгами или пустую.

// Задачи для Library:

class Book ( val title:String, val author: String, var year:Int) {
 

    var isBorrowed:Boolean = false;

    constructor( title:String, author:String): this(title, author,2025)

    init{
        if(year<0) {
            println("⚠️ Предупреждение: год $year некорректен для книги '$title'") ;
            year = 0;
        }
        println("📖 Создана книга: '$title'")
    }

    fun borrow () {
        if (!isBorrowed) {
            isBorrowed = true
            println("✅ Книга '$title' взята")
        } else {
            println("❌ Книга '$title' уже взята")
        }
    } 
    fun returnBook () {
        if (isBorrowed) {
            isBorrowed = false
            println("✅ Книга '$title' возвращена")
        } else {
            println("❌ Книга '$title' уже в библиотеке")
        }
    } 
    fun getInfo() : String = "Книга $title. Автор $author. Год издания $year. Книга "+ if( isBorrowed ) "была взята." else "не была взята.";
}

class Library (_books:List<Book> = emptyList()){
    
    var books : MutableList<Book> = _books.toMutableList();

    constructor(): this(emptyList())
    

    init{
        println("Создана библиотека");
    }

    fun addBook( book : Book) {
        books.add(book);
    }

    fun findBook(title: String): Book {
        for (i in books) {
            if (i.title == title) return i;
        }
        return Book();
    }

    fun showAllBooks() {
        for (i in books) println(i.getInfo());
    }

    fun showAvailableBooks() {
        for (i in books) if (i.isBorrowed) println(i.getInfo());
    }
}

fun main(args: Array<String>) {

    var book1: Book = Book("Мастер и Маргарита","Булгаков", 1967);
    var book2: Book = Book("Преступление и наказание", "Достоевский", 1866);
    var book3: Book = Book("Война и мир", "Толстой", 1869);
    book3.isBorrowed = true;


    println("Добавляем книги: ");
    println(book1.getInfo());
    println(book2.getInfo());
    println(book3.getInfo());

    var library1: Library = Library();
    library1.books = mutableListOf(book1, book2, book3);
    println("Все книги в библиотеке:");
    library1.showAllBooks();

    print("Ищем.. ")
    var searchStr:String = readLine()?:" "; 
    println((library1.findBook(searchStr)?:Book()).getInfo());

    book2.borrow();
    print("\n Берем книгу ${book2.title}\n");
    println(if(book2.isBorrowed == true)"Книга взята" else "Книгу не получилось взять");


    println("Доступные книги:");
    library1.showAvailableBooks();
}