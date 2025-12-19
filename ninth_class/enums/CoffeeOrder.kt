

data class CoffeeOrder(
    val orderId: Int,
    val coffeeType: CoffeeType,
    val size: CoffeeSize,
    var quantity: Int,
    var status: OrderStatus,
    val customerName: String
) {
    var totalPrice: Double;
    init{
        totalPrice = coffeeType.price * size.multiplier * quantity 
    }
}