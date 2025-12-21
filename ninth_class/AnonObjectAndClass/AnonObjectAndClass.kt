
import Person 



val person = object {
    val name = "Alice"
    val  age = 30

    fun introduce() {
        println("Hi, I'm $name, $age years old.")
    }
}

private fun sayHelloObject(obj: Person) {
    obj.sayHello()
}

fun main(args: Array<String>) {
    
    var weatherInCity = object {
        
        val city = "Moscow"
        var temperature = 20

        fun printWeather() {

            println("Weather in $city is $temperature°C")
        }
    }

    val employee = object: Person ("Kilua"){
        override fun sayHello() {
            println("Hello, my name is $name and I work at X")
        }
    }

    weatherInCity.printWeather()

    weatherInCity.temperature = 25
    println(person.name)
    // person.introduce()
    sayHelloObject(employee)

}