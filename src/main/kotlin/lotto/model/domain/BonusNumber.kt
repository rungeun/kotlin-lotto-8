package lotto.model.domain

import lotto.view.BonusNumberError

class BonusNumber(input: String, winningNumbers: List<Int>) {

    private val number: Int

    init {
        require(input.isNotBlank()) { BonusNumberError.EMPTY }
        require(!input.contains(",")) { BonusNumberError.SINGLE }

        val value = input.toDoubleOrNull()
        require(value != null) { BonusNumberError.NOT_NUMBER }
        require(value == value.toInt().toDouble()) { BonusNumberError.NOT_INTEGER }

        number = value.toInt()

        require(number > 0) { BonusNumberError.POSITIVE }
        require(number in 1..45) { BonusNumberError.RANGE }
        require(number !in winningNumbers) { BonusNumberError.DUPLICATE }
    }

    fun toInt(): Int = number
}