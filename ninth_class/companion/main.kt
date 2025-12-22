import Student

fun main(args: Array<String>) {
    
    val annStd: Student = Student(_name = "Anna", _year = 1)
    println(annStd.getInfo())
    val yenStd: Student = Student("Yen", 2)
    println(yenStd.getInfo())
    val kirillStd: Student = Student("Kirill", 3)
    println(kirillStd.getInfo())
    println("Всего студентов " + Student.Companion.getTotalCounts())
}