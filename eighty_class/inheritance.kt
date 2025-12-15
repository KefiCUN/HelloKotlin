

// Задание: "Система транспортных средств"
// Что нужно сделать:
// Часть 1: Создание базового класса
// Создай базовый класс Vehicle (Транспортное средство) со свойствами:

// brand (марка) — строка

// maxSpeed (максимальная скорость) — число

// fuelType (тип топлива) — строка

// И методы:

// start() — выводит "Транспортное средство запущено"

// stop() — выводит "Транспортное средство остановлено"

// getInfo() — возвращает строку с информацией о транспорте

// ВАЖНО: Класс должен позволять наследование, методы должны позволять переопределение.

// Часть 2: Создание классов-наследников
// Создай три класса, которые наследуются от Vehicle:

// Car (Автомобиль) — добавляет:

// Свойство: doorCount (количество дверей) — число

// Переопределяет getInfo(): добавляет информацию о количестве дверей

// Новый метод: honk() — выводит "Би-бип!"

// Motorcycle (Мотоцикл) — добавляет:

// Свойство: hasSidecar (есть ли коляска) — логическое

// Переопределяет start(): выводит "Мотоцикл заведён с рычанием"

// Переопределяет getInfo(): добавляет информацию о коляске

// Truck (Грузовик) — добавляет:

// Свойство: cargoCapacity (грузоподъёмность в тоннах) — число

// Переопределяет stop(): выводит "Грузовик остановился с пневматическим шипением"

// Новый метод: loadCargo(weight: Double) — принимает вес груза, проверяет не превышает ли грузоподъёмность

// Часть 3: Демонстрация в main()
// В функции main() сделай следующее:

// Создай по одному объекту каждого типа:

// Автомобиль: Toyota, 180 км/ч, бензин, 4 двери

// Мотоцикл: Harley, 220 км/ч, бензин, без коляски

// Грузовик: Volvo, 120 км/ч, дизель, грузоподъёмность 10 тонн

// Покажи полиморфизм:

// Создай список List<Vehicle> и добавь в него все три объекта

// В цикле вызови getInfo() для каждого элемента списка

// Продемонстрируй уникальные возможности:

// Для автомобиля вызови honk()

// Для грузовика вызови loadCargo(8.5) (8.5 тонн)

// Попробуй для грузовика loadCargo(12.0) (12 тонн — должно быть сообщение о перегрузе)

// Покажи переопределённые методы:

// Вызови start() для мотоцикла (должно быть особое сообщение)

// Вызови stop() для грузовика (должно быть особое сообщение)

open class Vehicle ( 

    val brand : String = "", 
    val maxSpeed : Int = 0,
    val fuelType : String = ""

) {

    open fun start() = println("Транспортное средство запущено");
    open fun stop() = println("Транспортное средство остановлено");
    open fun getInfo() : String = "Транспортное средство: $brand. Имеет максимальную скорость: $maxSpeed. Тип топлива: $fuelType."; 

}



class Car (

    brand : String = "", 
    maxSpeed : Int = 0,
    fuelType : String = "",
    val doorCount : Int = 0,

) : Vehicle (brand, maxSpeed, fuelType) {

    override fun getInfo() : String {

        var result : String = super.getInfo(); 
        result += " Количество дверей: $doorCount";
        return result;
    } 

    fun honk() = println("Би-бип!");
}


class Motorcycle(
    brand : String = "", 
    maxSpeed : Int = 0,
    fuelType : String = "",
    val hasSidecar : Boolean = false 
) : Vehicle (brand, maxSpeed, fuelType) {

    override fun start() = println("Мотоцикл заведён с рычанием");
    override fun getInfo() : String {
        var result : String = super.getInfo(); 
        result += "Коляска: " + if( hasSidecar ) "Есть" else "Нету";
        return result;
    }

}



class Truck(
    brand : String = "", 
    maxSpeed : Int = 0,
    fuelType : String = "",
    val cargoCapacity : Int = 0 
) : Vehicle (brand, maxSpeed, fuelType) {

    override fun stop() = println("Грузовик остановился с пневматическим шипением");
    fun loadCargo(weight: Double) {
        if( cargoCapacity.toDouble() > weight ) println("Данный вес можно перевести");
        else println("Данный вес нельзя перевести");
    }

}



fun main(args: Array<String>) {

    var toyota = Car("Toyota", 180, doorCount = 4);
    var harley = Motorcycle("Harley", 220, "бензин");
    var volvo = Truck("Volvo", 120, "дизель", 10);

    var vehicleList : List<Vehicle> = listOf(toyota, harley, volvo);

    for ( i in vehicleList ) {
        i.getInfo();
    }

    toyota.honk();

    volvo.loadCargo(8.5);
    volvo.loadCargo(12.5);
    volvo.stop();

    harley.start();



}