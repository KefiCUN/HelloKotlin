


    fun main(args: Array<String>) {
        

        val helpMessage = """
    ========= Строка-напоминания =========

    Команды для создания своей библиотеки:
    Нажмите 1 чтобы создать библиотеку,
    Нажмите 2 чтобы добавить книгу в библиотеку,
    Нажмите 3 чтобы вывести все книги которые есть в библиотеке
    Нажмите 4 чтобы вывести строку-напоминания
    Нажмите 5 чтобы выйти из приложения

    ======================================
    """
        

        var command: String? = null
        var library: Library? = null
        var title: String? = null
        var author: String? = null 


        print(helpMessage)

        while(command != "5") {
            println("Введите команду: ")
            command = readLine()
            when(command) {
                "1" -> {
                    library = Library()
                    println("Библиотека создана")
                }
                "2" -> {
                    if(library != null){
                        print("Введите название книги: ")
                        title = readLine()
                        print("Введите автора книги: ")
                        author = readLine()
                        println("Книга создана, количество книг в библиотеке составляет " + library?.addBook(title = title, author = author))
                    } else
                        println("Библиотека не создана")
                    
                
                }
                "3" -> {
                    if(library != null)
                        library?.printAllBooks()
                    else 
                        println("Библиотека не создана")
                }
                "4" -> println(helpMessage)
                else -> {
                    if(command == "5") {
                        println("Выход")
                        continue
                    }
                    println("Неверная операция")
                }
            }
            
        }
    }