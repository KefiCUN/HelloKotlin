
open class Spaceship(
    open val name: String,
    open var crewCount: Int,
    open var fuel: Double = 100.0, 
) {
    fun launch() {
        println("Корабль [$name] с экипажем из [$crewCount] человек готов к запуску! Топлива: [$fuel]%");
        if (checkEngine()) println("Расчетная мощность двигателей: [результат вызова "+calculateEnginePower()+"] усл. ед.") else println("Ошибка двигателя!")
    }

    private fun checkEngine(): Boolean {
        return true;
    }

    private fun calculateEnginePower(): Double {
        var power = (fuel * 10) + (crewCount * 5);
        return power;
    }
}
