import Messenger

class EmailMessenger(): Messenger {
    
    override fun sendMessage(message: String) {
        println("Отправляется сообщение $message через email")
    }
}