package lotto.model.domain

import lotto.view.PurchaseAmountError

class PurchaseAmount(input: String) {

    private val count: Int

    init {
        require(input.isNotBlank()) { PurchaseAmountError.EMPTY }
        val amount = parseAmount(input)
        validateAmount(amount)
        count = calculateCount(amount)
    }

    private fun parseAmount(input: String): Int {
        val value = input.toDoubleOrNull()
        require(value != null) { PurchaseAmountError.NOT_NUMBER }
        require(value == value.toInt().toDouble()) { PurchaseAmountError.NOT_INTEGER }
        return input.toInt()
    }

    private fun validateAmount(amount: Int) {
        require(amount > 0) { PurchaseAmountError.POSITIVE }
        require(amount >= MINIMUM_AMOUNT) { PurchaseAmountError.MINIMUM }
        require(amount % LOTTO_PRICE == 0) { PurchaseAmountError.UNIT }
        require(amount <= MAX_AMOUNT) { PurchaseAmountError.TOO_LARGE }
    }

    private fun calculateCount(amount: Int): Int {
        return amount / LOTTO_PRICE
    }

    fun toInt(): Int = count

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MINIMUM_AMOUNT = 1000
        private const val MAX_AMOUNT = 1_000_000_000
    }
}