// Практическое задание: "Система фильтрации данных"
// Объяснение задания (без кода):
// Цель: Показать, как лямбды упрощают операции с данными.

// Что программа будет делать (простым языком):
// Ты делаешь программу для работы со списком чисел. Нужно уметь:

// Фильтровать числа (оставлять только те, что подходят под условие)

// Преобразовывать числа (каждое число как-то изменять)

// Проверять все числа на условие

// Вместо того чтобы писать отдельные функции для каждой операции, ты будешь передавать лямбды — маленькие правила, что делать с каждым числом.

// Часть 1: Данные для работы
// Создать список чисел от 1 до 20. Это будут наши данные.

// Часть 2: Функция-фильтр (принимает лямбду)
// Создать функцию filterNumbers(), которая:

// Принимает список чисел

// Принимает лямбду-условие (правило, по которому отбирать числа)

// Возвращает новый список только с теми числами, для которых лямбда вернула true

// Часть 3: Функция-преобразователь (принимает лямбду)
// Создать функцию transformNumbers(), которая:

// Принимает список чисел

// Принимает лямбду-преобразование (правило, как изменить каждое число)

// Возвращает новый список с изменёнными числами

// Часть 4: Демонстрация (показываем мощь лямбд)
// Показать меню, где пользователь выбирает операцию:

// Показать только чётные числа

// Показать только нечётные числа

// Показать числа больше 10

// Возвести все числа в квадрат

// Удвоить все числа

// Показать числа как строки (например, "Число: 5")

fun filterNumbers (arrNumbs:List<Int>, condition:(Int) -> Boolean) : MutableList<Int> {

    var arrFilter:MutableList<Int> = mutableListOf();
    for (i in arrNumbs.indices) {
        if(condition(arrNumbs[i])) {
            arrFilter.add(arrNumbs[i]);
        }  
    } 
    return arrFilter;
}

fun <E, R> transformNumbers (arrNumbs:List<R>, transformElement: (R) -> E)  : MutableList<E>  {
    var arrTransform:MutableList<E> = mutableListOf();
    for (i in arrNumbs.indices) {
        arrTransform.add(transformElement(arrNumbs[i]));
    } 
    return arrTransform;
}

fun main(args: Array<String>) {
    
    var arrNumbs: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
    var arrResults: MutableList<Int>;
    val welcomeStr: String = "Добро пожаловать в систему фильтрации данных.";
    val helpStr: String = """
Выберите операцию: 
1. Показать только чётные числа
2. Показать только нечётные числа   
3. Показать числа больше 10
4. Возвести все числа в квадрат
5. Удвоить все числа
6. Показать числа как строки (например, "Число: 5")
                       """;

    println(welcomeStr);
    println(helpStr);
    var command: Int = 0;
    while (true) {
        print(">");
        command = (readLine()?:"0").toInt();
        when (command){
            1 -> {
                arrResults =  filterNumbers(arrNumbs, {x:Int -> x%2 == 0} );
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            2 -> {
                arrResults =  filterNumbers(arrNumbs, {x:Int -> x%2 != 0} );
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            3 -> {
                arrResults =  filterNumbers(arrNumbs, {x:Int -> x>10} );
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            4 -> {
                arrResults =  transformNumbers(arrNumbs, {x:Int -> x*x});
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            5 -> {
                arrResults =  transformNumbers(arrNumbs, {x:Int -> x*2});
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            6 -> {
                var arrResults =  transformNumbers(arrNumbs, { x: Int -> "Число: $x" });
                print("[");
                for (i in arrResults) print("" + i + if(!(i == arrResults[arrResults.lastIndex])) "," else "");
                print("]");
            };
            else -> {
                println("Выход");
                break;
            }
        }
    }
}