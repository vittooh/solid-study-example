package singleresponsibility.refactored

import java.lang.Exception
import java.math.BigDecimal

class ClothingInventoryManagerRefactored(
    private val mailService: MailService,
    private val notificationMktService: NotificationMktService,
    private val priceService: PriceService
) {

    private var inventoryByType = mutableMapOf<String, MutableMap<String, BigDecimal>>()

    init {
        this.inventoryByType[PANTS_CONST] = mutableMapOf()
        this.inventoryByType[SHIRTS_CONST] = mutableMapOf()
    }

    //we isolated the other services that are not related with act of put some clothing on the stock
    // we call here, but this class will only change if the change is related to add to stock, not if by example,
    // we change the provider of the mail, or if we have to add a new logic to notify
    fun addClothingToInventory(type: String, clothingName: String) {
        if (type in listOf(PANTS_CONST, SHIRTS_CONST)) {
            val price = priceService.calcPrice(type)
            inventoryByType[type]?.put(clothingName, price);
            notificationMktService.notifyNewItemMarketing(clothingName, price)
            mailService.sendMailToCustomers(clothingName)
        } else {
            throw Exception("Don't know this type $type, will not be add to inventory")
        }
    }

    private fun notifyNewItemMarketing(clothing: String, price: BigDecimal) {
        println("Send notification to mkt team, to publish ads for item $clothing with price $price")
    }

    private fun sendMailToCustomers(clothing: String) {
        println("Sending mail to customers.")
        println("new Clothing $clothing add to stock, check it out")
    }

    companion object {
        private const val PANTS_CONST = "pants"
        const val SHIRTS_CONST = "shirts"
    }
}