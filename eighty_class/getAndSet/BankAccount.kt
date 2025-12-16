

class BankAccount(
    val accountNumber: String,
    _balance: Double = 0.0,
    _dailyWithdrawLimit: Double = 50000.0,
    _withdrawnToday: Double = 0.0
) {

    var balance: Double = _balance
        set(value){
            if (value >= 0) {
                println("Баланс изменен: $field -> $value");
                field = value; 
            }
        }
    var isOverdrawt: Boolean = true
        get() = if (balance < 0) true else false;

    val formattedBalance: String
        get() = String.format("%.2f", balance) + " руб.";
    
    var dailyWithdrawLimit: Double = _dailyWithdrawLimit
        set(value){
            if ((value >= 0.0) && (value <= 1000000.0)) {
                field = value; 
            }
        }
    
    private var withdrawnToday: Double = _withdrawnToday

    var _transactions: MutableList<String> = mutableListOf();
    private val transactions
        get() = _transactions

        

    fun withdraw(amount: Double): Boolean {
        if ((amount <= balance) && (withdrawnToday <= amount)) {
            balance -= amount;
            withdrawnToday += amount;
            transactions.add("[время] Снятие: $amount руб.");
            return true;
        } else return false;
    }
        
}