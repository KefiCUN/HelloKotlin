
var books:MutableMap<String, Int> = mutableMapOf()
var users:MutableMap<Int, String> = mutableMapOf()
var accessBooksUser:MutableMap<Int, MutableList<String>> = mutableMapOf()

fun addBook(title:String, accessCount:Int = 200){
    books[title]=accessCount
}

fun isAccess(title:String):Boolean = if ((title in books.keys)&&((books[title]?:0)>=1)) true else false

fun issuanceBook(id:Int, title:String)  {
    if(isAccess(title)) {
        books[title] = (books[title]?:0)-1
        // accessBooksUser[id]=accessBooksUser[id]?.add(title)
         if (accessBooksUser[id] == null) {
            accessBooksUser[id] = mutableListOf(title)
        } else {
            accessBooksUser[id]?.add(title)
        }
    }else{
        println("Ошибка нет доступа к книге")
    }
} 
fun findBooks(title:String):MutableMap<String, Int>{
    if (title in books.keys) return mutableMapOf(title to (books[title]?:0))
    else return mutableMapOf()
}

fun createBookFormatter():(String) -> String {
    return {bookTitle -> "Книга под названием $bookTitle с доступом ${books[bookTitle]}"}
}

fun main(){
    addBook(title = "Преступление и наказание")
    println(books)
    users[1] = "Kef"
    issuanceBook(id = 1, title = "Преступление и наказание" )
    println(findBooks(title = "Преступление и наказание"))
    var formatter = createBookFormatter()
    println(formatter("Преступление и наказание"))
    println(accessBooksUser)

}


