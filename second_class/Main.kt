//Программа учета товаров на складе электроники
//точка входа
fun main(){

    //инициализация переменных и объявление констант 
    val MAX_CAPACITY_WAREHOUSE:Int = 10_000
    val TAX_RATE:Int = 15
    var countProducts:Int = 0
    var resultSumPrice:Float 
    
    println("Добро пожаловать на Центральный склад вместимость вашего склада сейчас $MAX_CAPACITY_WAREHOUSE")
    println("----------------------------------------------------------------------------------------------")
    //происходит приемка товара
    var teddyBearProductCount = 1_000
    var teddyBearPrice = 499.0
    var nowCapacity = MAX_CAPACITY_WAREHOUSE
    var teddyBearContract = true

    countProducts += teddyBearProductCount
    nowCapacity -= countProducts
    resultSumPrice = (1).toFloat()
    resultSumPrice *= (teddyBearProductCount*teddyBearPrice).toFloat()
    
    println("Приемка товаров из компании Teddy Bear, продукта Плюшевый Медведь, налог по контракту входит в стоимость закупки товара: $teddyBearContract, в количестве: $teddyBearProductCount,  по цене за штуку: $teddyBearPrice ")
    println("Кол-во товаров на складе равно: $countProducts общая сумма товаров: $resultSumPrice вместимость товаров на складе составляет: $nowCapacity ")
    println("----------------------------------------------------------------------------------------------")
    
    var toyCarProductCount = 1_500
    var toyCarPrice = 999.64
    var toyCarContract = false
    var tax_rate_sum = 100.0

    countProducts += toyCarProductCount
    nowCapacity -= toyCarProductCount 
    tax_rate_sum /= ((toyCarProductCount*toyCarPrice)*TAX_RATE)
    resultSumPrice += ((toyCarProductCount*toyCarPrice)+tax_rate_sum).toFloat()

    println("Приемка товаров из компании Toy Car, продукта Игрушечная Машинка, налог по контракту входит в стоимость закупки товара $toyCarContract, в количестве $toyCarProductCount,  по цене за штуку $toyCarPrice ")
    println("Кол-во товаров на складе равно $countProducts общая сумма товаров $resultSumPrice вместимость товаров на складе составляет $nowCapacity ")
    println("----------------------------------------------------------------------------------------------")
    
    var toyTractorProductCount = 3_500
    var toyTractorPrice = 290.19
    var toyTractorContract = true

    countProducts += toyTractorProductCount
    nowCapacity -= toyTractorProductCount 
    resultSumPrice += (toyTractorProductCount*toyTractorPrice).toFloat()

    println("Приемка товаров из компании Toy Tractor, продукта Игрушечный Трактор, налог по контракту входит в стоимость закупки товара $toyTractorContract, в количестве $toyTractorProductCount,  по цене за штуку $toyTractorPrice ")
    println("Кол-во товаров на складе равно $countProducts общая сумма товаров $resultSumPrice вместимость товаров на складе составляет $nowCapacity ")
    println("----------------------------------------------------------------------------------------------")
    
    //происходит продажа товаров 
    val BYING_TAXE_RATE = 5
    var byingCount = 0
    var revenue:Float
    var pricePurchase:Float
    var byingTaxeRatePriceEquivalent = 0.0
    var priceFirstProduct:Float
    var cost:Float
    var profit:Float

    byingCount = 1_000
    toyCarProductCount -= 1_000
    priceFirstProduct = ((((toyCarProductCount*toyCarPrice)+tax_rate_sum)/toyCarProductCount)+100).toFloat()
    revenue = (byingCount*priceFirstProduct).toFloat() //выручка
    cost = (byingCount*toyCarPrice).toFloat()//себестоимость
    profit = revenue-cost //прибыль
    pricePurchase = (byingCount*toyCarPrice).toFloat()
    resultSumPrice -= pricePurchase

    println("Выручка составляет $revenue")
    println("Прибыль составляет $profit")
    





    
    
    
}