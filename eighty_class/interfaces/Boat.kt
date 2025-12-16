

class Boat(
    override var model: String = "",
    override var speed: Int = 20
):Vehicle(model) {

    
    override fun move() {
        println("Плыву на лодке со скоростью $speed км/ч")
    }
}