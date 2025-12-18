

fun main(args: Array<String>) {
    var bankAccount: BankAccount = BankAccount(2000.0)
    bankAccount.displayBalance()
    bankAccount.createTransaction(200)
}