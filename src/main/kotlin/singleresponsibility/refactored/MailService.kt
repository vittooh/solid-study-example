package singleresponsibility.refactored

class MailService {

    fun sendMailToCustomers(clothing: String) {
        println("Sending mail to customers.")
        println("new Clothing $clothing add to stock, check it out")
    }
}