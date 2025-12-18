
class CommandBridge(
    override val name: String,
    override var crewCount: Int,
    override var fuel: Double = 100.0, 
    protected var accessCode: String
): Spaceship(name, crewCount, fuel) { 

    fun enterBridge(enteredCode: String) {
        if (enteredCode == accessCode) println("Доступ на капитанский мостик разрешен. Статус корабля: [$name], топливо: [$fuel]%"); 
        else println("Неверный код доступа!");
    }
}