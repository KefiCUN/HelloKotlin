import models.*

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