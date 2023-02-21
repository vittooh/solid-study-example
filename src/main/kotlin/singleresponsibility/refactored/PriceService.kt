package singleresponsibility.refactored

import java.math.BigDecimal

class PriceService {

    fun calcPrice(type : String): BigDecimal {
        return if (type == ClothingInventoryManagerRefactored.SHIRTS_CONST) {
            BigDecimal.TEN
        } else {
            BigDecimal(25.0)
        }
    }
}