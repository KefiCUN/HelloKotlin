
    class BankAccount(
        private var balance: Double = 0.0
    ) {

        fun displayBalance() {
            println("Ваш баланс: $balance")
        }

        fun createTransaction(amount: Int) {
            var transaction: Transaction = Transaction(200.0)
            transaction.execute()
        }
        
        inner class Transaction(
            var amount: Double = 0.0
        ) {

            fun execute() {
                this@BankAccount.balance -= amount
                this@BankAccount.displayBalance() 
            }
        } 

    }