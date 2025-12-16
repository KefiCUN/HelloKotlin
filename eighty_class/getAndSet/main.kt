fun main() {
    val account = BankAccount("1234567890")
    
    println(account.formattedBalance) // "0.00 руб."
    account.balance = 10000.0
    println(account.isOverdrawt) // false
    
    val success = account.withdraw(3000.0)
    println("Снятие успешно: $success") // true
    println(account.formattedBalance) // "7000.00 руб."
    
    // Попытка снять больше дневного лимита
    account.withdraw(60000.0) // false
}