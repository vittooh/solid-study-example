package singleresponsibility.notrefactored

import java.lang.Exception
import java.math.BigDecimal

class ClothingInventoryManager {

    private var inventoryByType = mutableMapOf<String, MutableMap<String, BigDecimal>>()

    init {
        this.inventoryByType[PANTS_CONST] = mutableMapOf()
        this.inventoryByType[SHIRTS_CONST] = mutableMapOf()
    }

    //this class is breaking single responsibility, this class has 4 reasons to change
    // if the calc for the price changes.
    // if the logic to send mail to customers change.
    // if the logic to notify mkt change.
    // if the logic to add to inventory change, and this class is made for this purpose, not the other 3.
    fun addClothingToInventory(type: String, clothingName: String) {
        if (type in listOf(PANTS_CONST, SHIRTS_CONST)) {
            val price = if (type == SHIRTS_CONST) {
                BigDecimal.TEN
            } else {
                BigDecimal(25.0)
            }
            inventoryByType[type]?.put(clothingName, price);
            sendMailToCustomers(clothingName)
            notifyNewItemMarketing(clothingName, price)
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
        private const val SHIRTS_CONST = "shirts"
    }
}