

class Cat(
    override var age:Int
): Animal() {
    override fun makeSound() {
        println("Мяу")
    }
}