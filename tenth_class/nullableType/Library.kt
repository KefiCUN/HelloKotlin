class Library(
    var listBook: MutableList<Book> =  mutableListOf()

) {


    fun addBook(
        title: String?, 
        author: String?

    ): Int {

        listBook.add(Book(title = title?: "", author = author?: ""))
        return listBook.size
    }

    fun printAllBooks() {

        if(listBook.size != 0){

            for (book in listBook) {
                println("Книга с названием: " + book.title + ". Автор: " + book.author)
            }
        } else throw Exception("В библиотеке нет книг")
            
    }
}