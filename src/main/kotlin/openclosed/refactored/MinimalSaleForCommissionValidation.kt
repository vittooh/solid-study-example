package openclosed.refactored

import java.lang.Exception
import java.math.BigDecimal

class MinimalSaleForCommissionValidation : CommissionValidation {
    override fun validate(saleDto: SaleDto) {
        if(saleDto.saleValue < BigDecimal.valueOf(1000)){
            throw Exception("Value is to low to receive commission")
        }
    }
}