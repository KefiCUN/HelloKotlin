package models

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