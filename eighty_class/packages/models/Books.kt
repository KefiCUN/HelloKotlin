package models


class Book ( val title:String = "", val author: String = "", var year:Int = 2025) {
 

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
