// Практическое задание: "Библиотека книг"
// Объяснение задания (без кода):
// Цель: Научиться создавать классы и объекты на практическом примере.

// Что программа будет делать:
// Ты создашь простую систему для учета книг в библиотеке. Будут два класса:

// Класс Book (Книга) — представляет одну книгу

// Класс Library (Библиотека) — управляет коллекцией книг

// Часть 1: Класс Book (Книга)
// Свойства (данные книги):

// title — название книги (строка)

// author — автор книги (строка)

// year — год издания (число)

// isBorrowed — взята ли книга (логическое значение)

// Функции (действия с книгой):

// borrow() — взять книгу (меняет isBorrowed на true)

// returnBook() — вернуть книгу (меняет isBorrowed на false)

// getInfo() — получить информацию о книге в виде строки

// Часть 2: Класс Library (Библиотека)
// Свойства:

// books — список книг в библиотеке (массив или список объектов Book)

// Функции:

// addBook(book: Book) — добавить новую книгу

// findBook(title: String) — найти книгу по названию

// showAllBooks() — показать все книги

// showAvailableBooks() — показать только доступные книги

// Часть 3: Демонстрация работы
// Создать несколько книг, добавить их в библиотеку и показать:

// Все книги в библиотеке

// Поиск конкретной книги

// Взятие книги (изменение статуса)

// Показ только доступных книг




class Book {

    var title:String = "";
    var author:String = "";
    var year:Int = 0;
    var isBorrowed:Boolean = false;

    fun borrow () {
        isBorrowed = true;
    } 
    fun returnBook () {
        isBorrowed = false;
    } 
    fun getInfo() : String = "Книга $title. Автор $author. Год издания $year. Книга "+ if( isBorrowed ) "была взята." else "не была взята.";
}

class Library {
    
    var books : MutableList<Book> = mutableListOf();

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

    var book1: Book = Book();
    book1.title = "Мастер и Маргарита";
    book1.author = "Булгаков";
    book1.year = 1967;

    var book2: Book = Book();
    book2.title = "Преступление и наказание";
    book2.author = "Достоевский";
    book2.year = 1866;
    
    var book3: Book = Book();
    book3.title = "Война и мир";
    book3.author = "Толстой";
    book3.year = 1869;
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