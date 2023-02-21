package openclosed.refactored

class NonCommissionedValidation : CommissionValidation {
    private val nonCommissioned = mutableSetOf<Long>()

    override fun validate(saleDto: SaleDto) {
        if (saleDto.salesmanId in nonCommissioned){
            throw Exception("Not allowed to receive commission")
        }
    }
}