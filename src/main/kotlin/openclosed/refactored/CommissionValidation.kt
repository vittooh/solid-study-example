package openclosed.refactored

import java.math.BigDecimal

interface CommissionValidation {

    fun validate(saleDto: SaleDto)
}