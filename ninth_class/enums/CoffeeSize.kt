
enum class CoffeeSize(var multiplier: Double) {
    SMALL(1.0),
    MEDIUM(1.3),
    LARGE(1.6);
    
    fun displayName(): String {
        return when(this) {
            SMALL -> "Маленький"
            MEDIUM -> "Средний"
            LARGE -> "Большой"
        } 
    } 
}