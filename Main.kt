fun main(){
    val product:String = "Чай"
    val countDay:Int = 30
    val bydjetForDay:Double = 30000.0
    var byeProducts:Int = 0 
    var spentMoney:Double = 0.0
    println("Стартовая информация о бюджете: $bydjetForDay")
    println("Текущее состояние расходов: $spentMoney")
    spentMoney += 50000
    println("После покупки: $product за $spentMoney")
    println("Куплено товаров: ${byeProducts+1}, потрачено:   $spentMoney")
    println("Превышение бюджета на: ${spentMoney-bydjetForDay}")
}