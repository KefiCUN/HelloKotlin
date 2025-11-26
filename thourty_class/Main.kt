fun main(){
    var assessment = 0
    when(assessment){
        in 90..100 -> println("Отлично")
        in 75..89 -> println("Хорошо")
        in 60..74 -> println("Удовлетворительно")
        in 0..59 -> println("Неудовлетворительно")
        else -> println("Ошибка, неверный балл")
    }
}