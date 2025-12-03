// Практическое задание: "Система оценки студентов"
// Задача: Создайте программу для расчета итоговой оценки студента с использованием различных форм if-else конструкций.

// Требования:
// Рассчитывайте оценку по различным критериям:

// Экзаменационная оценка (0-100 баллов)
// Средний балл за домашние задания (0-100)
// Посещаемость лекций (0-100%)
// Активность на семинарах (низкая/средняя/высокая)
// Наличие дополнительных работ (да/нет)

// Используйте разные формы if:

// Простой if для проверки условий допуска
// if-else для бинарных решений
// Цепочку else if для нескольких вариантов
// if как выражение для возврата значений
// Вложенные if для сложных условий

// Создайте систему расчета:

// Допуск к экзамену: посещаемость ≥ 70% и сдано ≥ 80% ДЗ
// Итоговая оценка: комбинация экзамена + ДЗ + активность
// Повышение оценки: за дополнительные работы
// Особые случаи: автопроход, пересдача

import java.io.BufferedReader
import java.io.InputStreamReader

fun readLineWithEncoding(): String? {
    val reader = BufferedReader(InputStreamReader(System.`in`, "UTF-8"))
    return reader.readLine()
}

fun main(args: Array<String>) {
    
    println("=== СИСТЕМА ОЦЕНКИ СТУДЕНТОВ ===")
    try{
        print("Введите экзаменационную оценку (0-100): ")
        var assessment:UByte = readLine()?.toUByteOrNull()?:1u
        print("Введите средний балл за ДЗ (0-100): ")
        var averageHomework:UByte = readLine()?.toUByteOrNull()?:1u
        print("Введите посещаемость (%): ")
        var attendance:UByte = readLine()?.toUByteOrNull() ?: 1u
        print("Оцените активность (1-низкая, 2-средняя, 3-высокая): ")
        var activity:UByte = readLine()?.toUByteOrNull() ?: 1u
        print("Были дополнительные работы? (да/нет): ")
        var thereAdditionalJobs:String =  readLineWithEncoding()?.trim()?.lowercase() ?: "нет"
        println("=== РЕЗУЛЬТАТЫ ===")
        if ((attendance >= 70.toUByte()) and (averageHomework >= 80.toUByte()) and (assessment >= 50.toUByte())){
            
            println("Допуск к экзамену: ✅ ДОПУЩЕН")
            var resultAssessment = if((assessment >= 79.toUByte()) and (averageHomework >= 94.toUByte()) and (activity == 3.toUByte())) 5 else if((assessment >= 69.toUByte()) and (averageHomework >= 89.toUByte()) and (activity >= 2.toUByte())) 4 else 3
            var additionalPoints = if(thereAdditionalJobs == "да") 5 else 0
            var activityPoints = if(activity == 3.toUByte()) 5 else 0
            var sumAssessment = if ((activity == 3.toUByte()) and (thereAdditionalJobs == "да") and (averageHomework == 100.toUByte())) {println("Автомат"); 100} else (assessment.toInt() + resultAssessment + additionalPoints +activityPoints)
            
            println("Балл за активность: $activityPoints")
            println("Дополнительные работы: $additionalPoints \n")
            println("Итоговый балл: $sumAssessment")
            var estimation = if(sumAssessment >= 94) 5 else if(sumAssessment >= 89) 4 else 3
            println("Оценка: $estimation")
            
        }else{
            println("Допуск к экзамену: НЕ ДОПУЩЕН")
            if ((attendance >= 70.toUByte()) and (averageHomework >= 80.toUByte())){
                println("Пересдача доступна")
            }else{
                println("Пересдача не доступна")
            }
        }
    }catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
   


}