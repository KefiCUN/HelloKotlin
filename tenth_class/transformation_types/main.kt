
open class Person(open var name: String) 

class Employee(
    override var name: String,
    var company: String?
): Person(name) 

fun Person.checkEmployment() {
    when(this){
        is Employee -> println("${this.name} ${this.company ?: "doesn't have company"}")
        else -> println("${this.name} doesn't work")
    }
}

fun main(args: Array<String>) {
    var tom: Person = Person("Tom")
    var eddy: Employee = Employee("Eddy", "VK")
    var ilua: Employee = Employee("Ilua", "Tbank") 


    tom.checkEmployment()
    eddy.checkEmployment()
    ilua.checkEmployment()
}