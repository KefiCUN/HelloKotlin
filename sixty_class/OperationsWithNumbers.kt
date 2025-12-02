// Практическое задание: "Финансовый калькулятор"
// Задача: Создайте программу для различных финансовых расчетов с использованием всех изученных операций.

// Требования:
// Реализуйте следующие расчеты:

// Сложный процент: A = P × (1 + r/n)^(n×t)
// Ежемесячный платеж по кредиту: PMT = P × (r×(1+r)^n) / ((1+r)^n - 1)
// Конвертация валюты с учетом комиссии
// Распределение бюджета по категориям в процентах
// Используйте различные типы операций:
// Арифметические (+, -, *, /, %)
// Составные присваивания (+=, -=, *=)
// Инкремент/декремент для счетчиков
// Побитовые операции для "флагов" скидок

import kotlin.math.pow


//флаг для того чтобы всего однажды запросить данные
var flagDataUser = true;
// основная сумма
var principal:Float = 0.0f;
// сложный процент
var compoundInterest:Float = 0.0f;
// процентная ставка
var rate:Float = 0.0f; 
// начисления в год
var annualAccruals:UByte = 1U;
// срок в годах
var periodsCount:UByte = 1U;
// результирующая строка
var result:String = "";
// платеж по кредиту
var loanPayment:Float = 0.0f;



// входные данные от пользователя
fun requestDataUser() {
    if (flagDataUser) {
        try {
            print("Но для начала введите основную сумму: ");
            principal = readLine()?.toFloatOrNull() ?: 0.0f;
            
            print("Введите процентную ставку: ");
            rate = readLine()?.toFloatOrNull() ?: 0.0f;
            
            print("Введите срок в годах: ");
            val yearsInput = readLine()?.toIntOrNull() ?: 1;
            periodsCount = if (yearsInput in 0..255) yearsInput.toUByte() else 1u;
            
            print("Введите количество начислений в год: ");
            val accrualsInput = readLine()?.toIntOrNull() ?: 1;
            annualAccruals = if (accrualsInput in 0..255) accrualsInput.toUByte() else 1u;
            
            flagDataUser = false;
        } catch (e: Exception) {
            println("Ошибка ввода данных: ${e.message}")
        }
    }
}

fun main(args: Array<String>) {

    // строка приветствия
    var helloStr:String = """

=== ФИНАНСОВЫЙ КАЛЬКУЛЯТОР ===

1. Расчет сложного процента
2. Расчет платежа по кредиту  
3. Конвертация валюты
4. Распределение бюджета
5. Выход 
Выберите операцию: """;
    
    // Ожидаем ввода кода операции от пользователя
    print(helloStr);
    var selectedOperationInput = readLine()?.toIntOrNull() ?: 1;
    var selectedOperation:UByte = if (selectedOperationInput in 0..255) selectedOperationInput.toUByte() else 1u;
    var frag:Boolean = false;
    //работает пока пользователь не введет число больше 4
    while(selectedOperation in 1u..4u){

        if(frag){
            print("Выберите операцию: ");
            selectedOperationInput = readLine()?.toIntOrNull() ?: 1;
            selectedOperation = if (selectedOperationInput in 0..255) selectedOperationInput.toUByte() else 1u;
            print(selectedOperation)
        } else{
            frag = true;
        }
        // выполнение действий по коду операции
        when (selectedOperation){
            // вычисление сложного процента
            1.toUByte() -> {
                requestDataUser();
                // вычисляем по формуле A = P × (1 + r/n)^(n×t)
                compoundInterest = principal * (1 + rate / annualAccruals.toFloat()).pow(annualAccruals.toInt() * periodsCount.toInt());
                // форматируем отчет по вычислениям
                result = " Сложный процент равен: $compoundInterest";
                println(result);
            };
            
            // Расчет платежа по кредиту
            2.toUByte() -> {
                requestDataUser();
                //ежемесячный платеж по кредиту вычисляется по формуле PMT = P × (r×(1+r)^n) / ((1+r)^n - 1)
                loanPayment =  principal * (1 + rate / annualAccruals.toFloat()).pow(annualAccruals.toInt() * periodsCount.toInt());
                result = "Ежемесячный платеж по кредиту будет равен: $loanPayment";
                println(result);
            };

            //Конвертация валюты
            3.toUByte() -> {
                print("""
Конвертации доступные в конвертере на сегодня: (Писать в валюту нужно так же как тут и описано):
Dollar, Ruble, Euro. """);
                val COMMISSION_RATE:Float = 0.0000001f;
                print("Введите сумму конвертации: ");
                var sum:Float =  readLine()?.toFloatOrNull() ?: 0.0f;
                print("Введите валюту, которую хотите конвертировать: ");
                var self_currencies:String = ((readLine()?:" ").toString());
                var currenciesMap:MutableMap<String,Float> = when(self_currencies){
                    "Dollar" -> mutableMapOf("Ruble" to 0.013f, "Euro" to 1.16f);
                    "Ruble" -> mutableMapOf("Dollar" to 81.90f, "Euro" to 94.08f);
                    "Euro" -> mutableMapOf("Dollar" to 0.86f, "Ruble" to 90.82f);
                    else -> mutableMapOf();
                };
                print("Введите валюту, в которую хотите конвертировать: ");
                var currencies:String = ((readLine()?:" ").toString());
                var targetAmount:Float;
                var commission:Float;
                var finalSum:Float;
                targetAmount = sum * (currenciesMap[currencies] ?: 1.0f);
                commission = targetAmount * (COMMISSION_RATE / 100);
                finalSum = targetAmount - commission;
                result = """
Ваша введенная сумма $sum
Коммиссия $commission
Итого у вас выйдет $finalSum
                """;
                println(result);
                
            };
        }
    }
    
}