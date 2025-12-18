// Практическое задание: "Конвертер единиц измерения"
// Задача: Напишите программу, которая демонстрирует работу с различными типами данных через конвертацию единиц измерения.

// Требования:
// Объявите переменные разных типов:

// celsiusTemp (Float) - температура в Цельсиях
// distanceKm (Double) - расстояние в километрах
// fileSizeBytes (Long) - размер файла в байтах
// isMetricSystem (Boolean) - используется ли метрическая система
// measurementUnit (Char) - символ единицы измерения (например, 'C', 'F', 'K')
// conversionNote (String) - пояснительная строка

// Выполните преобразования:

// Цельсии → Фаренгейты: (celsius × 9/5) + 32
// Километры → Мили: km × 0.621371
// Байты → Мегабайты: bytes ÷ 1,048,576

// Используйте различные системы счисления:

// Одно значение задайте в шестнадцатеричной системе
// Одно значение - в двоичной
// Примените строковые шаблоны для красивого вывода результатов




fun main(args: Array<String>) {
    //объявляем переменные 
    var celsiusTemp:Float = 4.5f;
    var faringateTemp:Float = (celsiusTemp*9.0f/5.0f)+32.0f;
    var distanceKm:Double = 12.5;
    var distanceMm:Double = distanceKm*0.621371;
    var fileSizeBytes:Long = 1_123_432_456L;
    var fileSizeMBytes:Long = fileSizeBytes/1_048_576L;
    var isMetricSystem:Boolean = true;
    var measurementUnit:Char = 'C';

    var conversionNote:String = """
                                    === КОНВЕРТЕР ЕДИНИЦ ИЗМЕРЕНИЯ ==
                                    
                                    Исходные данные:
                                    Температура: $celsiusTemp°C
                                    Расстояние: $distanceKm км
                                    Размер файла: $fileSizeBytes байт
                                    Используется метрическая система: $isMetricSystem
                                    Символ единицы: $measurementUnit


                                    Результаты преобразований:
                                    $celsiusTemp°C = $faringateTemp°F
                                    $distanceKm км = $distanceMm миль
                                    $fileSizeBytes байт = $fileSizeBytes Мбайт

                                    Шестнадцатеричное представление 0xA5
                                    Двоичное представление: 0b10100101

                                """;

    println(conversionNote);



}