package singleresponsibility.refactored

import java.math.BigDecimal

class NotificationMktService {

    fun notifyNewItemMarketing(clothing: String, price: BigDecimal) {
        println("Send notification to mkt team, to publish ads for item $clothing with price $price")
    }
}