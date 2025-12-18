// Практическое задание: "Тренажер математики"
// Задача: Создайте интерактивную программу-тренажер для изучения математики с использованием всех видов циклов.

// Требования:
// Реализуйте различные режимы тренировки:

// Таблица умножения (вложенные циклы)
// Арифметические примеры на время (while с условием)
// Проверка знаний (do-while пока не будет правильный ответ)
// Прогрессивная сложность (цикл с изменяющимся условием)

// Используйте все виды циклов:
// for с диапазонами для таблиц
// while для игр на время
// do-while для повторения неправильных ответов
// Вложенные циклы для сложных структур

// Добавьте управление циклами:

// break для досрочного завершения
// continue для пропуска определенных заданий
// Метки для управления вложенными циклами

fun main(args: Array<String>) {
    var menuHelp:String = """
=== Тренажер Математики ===

Выберите действие:
1. Таблица умножения
2. Арифметические примеры на время 
3. Меню помошник
4. Выход
                         """;
    println(menuHelp);
    var command:String ;
    while(true){
        print("Ваша команда: ");
        command = ((readLine()?:" ").toString());
        when(command){
            
            "1" -> multiplicationTable();
            "2" -> arithmeticExamplesForTime();
            "3" -> println(menuHelp);
            else -> {
                println("Выход");
                break;
            };
       }
    }
}

fun multiplicationTable(){
    for (i in 1..10) {
        for (j in 1..10){
            print("${i*j} ");
        }
        println();
    }
}

fun arithmeticExamplesForTime(){
    var counter:UByte = 1u;
    var resultUser:Short = 1;
    var randNumber1:Short = (1..100).random().toShort();
    var randNumber2:Short = (1..100).random().toShort();
    var randOperation:UShort = (1..2).random().toUShort();
    var resultQuestion:Short = 0; 
    while(counter <= 10.toUByte()){
        
        var resultTrue:Short = when(randOperation){
            1.toUShort() -> {
                print("Пример $counter. $randNumber1 + $randNumber2 = ");
                resultUser = readLine()?.toShortOrNull()?:1;
                (randNumber1+randNumber2).toShort();
            };
            2.toUShort() -> {
                print("Пример $counter. $randNumber1 - $randNumber2 = ");
                resultUser = readLine()?.toShortOrNull()?:1;
                (randNumber1-randNumber2).toShort();
            };
            else -> 0.toShort();
        };

        if (resultTrue == resultUser){
            println("Правильный ответ: $resultTrue. Вы ответили: $resultUser. Ответ является верным");
            resultQuestion = (resultQuestion.toShort() + 1).toShort();
        } else {
            println("Правильный ответ: $resultTrue. Вы ответили: $resultUser. Ответ является неверным");
        }
        
        randNumber1 = (1..100).random().toShort();
        randNumber2 = (1..100).random().toShort();
        randOperation = (1..2).random().toUShort();
        counter++;
        
    }
    println("Примеры кончились! Вы решили 10 примеров, из них $resultQuestion правильных!");
}


fun getType(value: Any): String {
    return value::class.simpleName ?: "Unknown"
}
