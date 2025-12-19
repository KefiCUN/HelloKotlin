
enum class Temperature () {
    HOT {
        override val idealTemp: Int = 85
        override fun getServingMessage(): String = "Подается горячим"
    },
    ICE {
        override val idealTemp: Int = 5
        override fun getServingMessage(): String = "Подается со льдом"
    };

    abstract val idealTemp: Int
    abstract fun getServingMessage(): String
}