package openclosed.notrefactored

import java.lang.Exception
import java.math.BigDecimal

class CommissionService {

    private val nonCommission = mutableSetOf<Long>()

    // Open closed principle say that a class must be close to change but open to extension
    //whenever we have a new validation to calc the commission this class will change
    // breaking the open closed principle.
    fun getCommissionByValue(saleValue: BigDecimal, salesmanId: Long): BigDecimal {
        if (salesmanId in nonCommission){
            throw Exception("Not allowed to receive commission")
        }

        if(saleValue < BigDecimal.valueOf(1000)){
            throw Exception("Value is to low to receive commission")
        }

        return saleValue.multiply(BigDecimal(0.2))
    }
}