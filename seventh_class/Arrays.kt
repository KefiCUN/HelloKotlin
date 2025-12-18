// Практическое задание: "Управление складом товаров"
// Объяснение задания (без кода):
// Цель: Создать программу для управления складом товаров с использованием массивов.
// Что программа должна делать:

// Часть 1: Инициализация склада (создание массивов)
// Создать несколько параллельных массивов одинакового размера:
// Массив названий товаров
// Массив цен товаров
// Массив количеств товаров на складе
// Массив категорий товаров
// Заполнить массивы начальными данными (например, 5-10 товаров)

// Часть 2: Просмотр товаров (перебор массивов)
// Вывести весь список товаров в виде таблицы
// Использовать цикл для перебора всех массивов одновременно
// Для каждого товара показать: номер, название, цену, количество, категорию

// Часть 3: Поиск товаров (проверка in и перебор)
// Дать возможность искать товары:
// По названию (частичное совпадение)
// По категории
// По диапазону цен
// Использовать проверки in и перебор с условиями

// Часть 4: Управление остатками (изменение элементов)
// Возможность изменять количество товара на складе
// Добавлять товар при поставке
// Списывать товар при продаже
// Проверять, чтобы количество не стало отрицательным

// Часть 5: Анализ склада (работа с массивами)
// Посчитать общую стоимость всех товаров на складе
// Найти самый дорогой и самый дешевый товар
// Показать товары, которых мало осталось (меньше порога)
// Сгруппировать товары по категориям

// Часть 6: Добавление новых товаров (расширение массивов)
// Так как массивы фиксированного размера, нужно:
// Либо создать новые массивы большего размера
// Либо изначально создать массивы с запасом
// Либо использовать arrayOfNulls и заполнять постепенно


fun main() {
    var productNames:Array<String> = arrayOf("молоко", "печенье", "хлеб", "масло", "фунчоза"); // Массив названий товаров
    var productPrice:Array<Float> = arrayOf(89.5f, 45.9f, 29.8f, 159.5f, 109.5f);              // Массив цен товаров
    var productCount:Array<Int> = arrayOf(2,4,2,2,5);                                          // Массив количеств товаров на складе
    var productCategories:Array<String> = arrayOf("молочные изделия", "к чаю", "выпечка", "масла для жарки", "макаронные изделия"); // Массив категорий товаров
    var i = 0;

    fun find (){
        print("Выберите поиск: (по названию, по категории, по диапазону цен): ")
        var choseFind:String = readLine()?:" ";
        var required:Any;
        var requested:String = "";
        when (choseFind) {
            "по названию" -> {
                print("Введите название: ");
                required = readLine()?:" ";
                when{
                    (required.toString().lowercase() in productNames) -> {
                        var i:Int = enumeration(productNames, required);
                        println("| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i]} |") ;
                    };
                    else -> println("Не удалось найти");
                }
            };
            "по категории" -> {
                print("Введите категорию: ");
                required = readLine()?:" ";
                when{
                    (required.toString().lowercase() in productCategories) -> {
                        var i:Int = enumeration(productCategories, required);
                        println("| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i]} |\n") ;
                    };
                    else -> println("Не удалось найти ${required.toString().lowercase()}");
                }
            };
            "по диапазону цен" ->  {
                print("Введите первое число: ");
                required = (readLine()?:"0").toInt();
                print("Введите второе число: ");
                var required2:Any = (readLine()?:"0").toInt();
                var i:Int = 0;
                while (i < productPrice.size) {
                    if(productPrice[i].toInt() in required..(required2 as Int)) requested += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i]} |";
                    i++;
                }
                println(requested);
                

            } ;
            else -> println("Не опознана команда поиска вы ввели $choseFind");
        }
    }

    var resultStr = "________________________________________________________________\n";
    while (i < 4) {
        when (i) {
            0 ->  resultStr += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i]} |\n";
            1 ->  resultStr += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i]} |\n";
            2 ->  resultStr += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i-1]} |\n";
            3 ->  resultStr += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i-3]} |\n";
            4 ->  resultStr += "| $i | ${productNames[i]} | ${productPrice[i]} | ${productCount[i]} | ${productCategories[i-2]} |\n";
        }
        i++;
    }
    resultStr += "________________________________________________________________\n";
    
    println(resultStr);
    find();

    

}

fun add (arr:Array<T>){
    
}

fun <T> enumeration (arr:Array<T>, required:Any) : Int{
    var i:Int = 0;
    while (i < arr.size) {
        if (required is Int) {
             if (required == arr[i]) return i;
        } else if(required is String ){
            if (required.uppercase() == (arr[i].toString()).uppercase()) return i;
        } 
        i++;
    }
    println("Ошибка элемент не найден");
    return -1;
}