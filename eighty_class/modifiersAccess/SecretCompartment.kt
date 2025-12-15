
class SecretCompartment internal constructor(val compartmentId: Int) {
    fun activate(activationKey: String) {
        println("Секретный отсек #[$compartmentId] активирован ключом: $activationKey");
    }
}