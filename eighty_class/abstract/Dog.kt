

class Dog(
    override var age:Int
): Animal() {
    override fun makeSound() {
        println("Гав");
    }
}