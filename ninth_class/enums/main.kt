
fun processOrder(order: CoffeeOrder): CoffeeOrder {
    var returned: CoffeeOrder = order.copy()
    if((order.status != OrderStatus.CANCELLED) and (order.status != OrderStatus.DELIVERED)){
        returned.status = order.status?.nextStatus()?:OrderStatus.CANCELLED
    }
    return returned
}

fun calculateRevenue(orders: List<CoffeeOrder>): Double {
    var revenue: Double = 0.0
    for (i in orders) {
        if (i.status == OrderStatus.DELIVERED) revenue += i.totalPrice
    }
    return revenue
}

fun main() {
    // Создание заказа
    val order = CoffeeOrder(
        1,
        CoffeeType.LATTE,
        CoffeeSize.MEDIUM,
        2,
        OrderStatus.CREATED,
        "Анна"
    )
    
    println("Заказ создан: ${order.coffeeType}")
    println("Размер: ${order.size.displayName()}")
    println("Цена за чашку: ${order.coffeeType.price * order.size.multiplier}")
    println("Итого: ${order.totalPrice}")
    
    // Обработка заказа
    var currentOrder = order
    println("Текущий статус: ${currentOrder.status.description}")
    
    currentOrder = processOrder(currentOrder)
    println("Новый статус: ${currentOrder.status.description}")
    
    // Проверка следующего статуса
    val nextStatus = currentOrder.status?.nextStatus()?: OrderStatus.CANCELLED
    println("Следующий статус: ${nextStatus?.description ?: "Конец"}")
    
    // Работа с температурой
    println(Temperature.HOT.getServingMessage())
    println("Идеальная температура: ${Temperature.HOT.idealTemp}°C")
}