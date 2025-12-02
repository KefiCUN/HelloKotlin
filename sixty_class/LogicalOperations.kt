// Практическое задание: "Система проверки доступа"
// Задача: Создайте программу для проверки доступа пользователя к системе с использованием сложных условий.

// Требования:
// Проверка пользователя по нескольким критериям:

// Возраст (должен быть ≥ 18)
// Наличие подписки (true/false)
// Уровень доступа (от 1 до 5)
// Страна (разрешенные: "RU", "US", "DE", "FR")
// Время доступа (день/ночь)
// Лицензионный ключ (формат: XXX-XXX-XXX, где X — цифра или буква)

// Используйте различные типы условий:

// Операции отношения (>, <, >=, <=, ==, !=)
// Логические операции (and, or, xor, !)
// Проверка диапазонов (in, !in)
// Комбинации условий

// Создайте многоуровневую систему доступа:
// Базовый доступ: возраст ≥ 18 + подписка
// Расширенный доступ: базовый + уровень ≥ 3
// Полный доступ: расширенный + страна из разрешенных + лицензионный ключ
// Ночной режим: только для уровней 4-5

//метод  для работы со строкой содержащей boolean 
fun safeToBoolean(input: String?): Boolean {
    return try {
        input?.toBoolean() ?: false;
    } catch (e: IllegalArgumentException) {
        false;
    }
}

fun main(){
    println("=== СИСТЕМА ПРОВЕРКИ ДОСТУПА ===");
    print("Введите возраст пользователя: ");
    var age:UByte = readLine()?.toUByteOrNull()?:1u;
    print("Есть ли подписка? (true/false): ");
    var thereSubscription:Boolean = safeToBoolean(readLine());
    print("Введите уровень доступа (1-5): ");
    var accessLevel:UByte = readLine()?.toUByteOrNull()?:1u;
    print("Введите код страны (RU, US, DE, FR): ");
    var countryCode:String = readLine()?:" ";
    print("Введите лицензионный ключ: ");
    var licenseKey:String = readLine()?:" ";
    print("Сейчас день или ночь? (day/night): ");
    var dayOrNight:String = readLine()?:" ";
    println("=== СИСТЕМА ПРОВЕРКИ ДОСТУПА ===");
    var allowedCountryCode:MutableMap<String, Boolean> = mutableMapOf("RU" to true, "US" to true, "DE" to true, "FR" to true);

    if((age >= 18.toUByte()) and (thereSubscription)){
        
        println("Базовый доступ:✅ ДОСТУП РАЗРЕШЕН");
        if(accessLevel >= 3.toUByte()){

            println("Расширенный доступ: ✅ ДОСТУП РАЗРЕШЕН  ");
            if((countryCode in allowedCountryCode.keys) and !(licenseKey.isEmpty())){
                
                println("Полный доступ: ✅ ДОСТУП РАЗРЕШЕН");
                if((accessLevel == 4.toUByte()) or (accessLevel == 5.toUByte())){
                    println("Ночной режим:  ✅ ДОСТУП РАЗРЕШЕН");
                }else{
                    println("Ночной режим:  ДОСТУП ЗАПРЕЩЕН");
                }
            }else{
                println("Полный доступ: ДОСТУП ЗАПРЕЩЕН");
            }
        }else{
            println("Расширенный доступ: ДОСТУП ЗАПРЕЩЕН");
        }
    }else{

        println("Базовый доступ: ДОСТУП ЗАПРЕЩЕН");
    }

}