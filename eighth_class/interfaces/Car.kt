

class Car(
    override var model: String = "",
    override var speed: Int = 60
):Vehicle(model) {    
    override fun move() {
        println("Еду на машине со скоростью $speed км/ч")
    }
}