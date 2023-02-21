package openclosed.refactored

import java.math.BigDecimal

class CommissionServiceRefactored() {
    private val validations = mutableListOf<CommissionValidation>()

    init {
        validations.add(MinimalSaleForCommissionValidation())
        validations.add(NonCommissionedValidation())
    }

    // this class now follow the open/close principle, is open to extension (new validations add by run the interface)
    // and closed for modification, any new validation will be make outside this class.
    fun getCommissionByValue(saleValue: BigDecimal, salesmanId: Long): BigDecimal {
        val saleDto = SaleDto(saleValue, salesmanId)
        validations.forEach {
            it.validate(saleDto)
        }

        return saleValue.multiply(BigDecimal(0.2))
    }
}