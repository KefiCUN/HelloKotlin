

enum class OrderStatus(var description: String) {
    CREATED("Создан"),
    PREPARING ("Готовится"),
    READY ("Готов"),
    DELIVERED ("Доставлен"),
    CANCELLED ("Отменен");

    fun nextStatus(): OrderStatus? {
        return when (this) {
            CREATED -> PREPARING
            PREPARING -> READY
            READY -> DELIVERED
            DELIVERED, CANCELLED -> null
        }
    }
}