package lotto.model.domain

import lotto.view.LottoError

class WinningNumber(input: String) {
    init {
        require(input.isNotBlank()) {LottoError.EMPTY }
    }

    fun parse(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim() }
        validate(numbers)
        return numbers.map { it.toInt() }
    }

    private fun validate(tokens: List<String>) {
        require(tokens.all { it.toIntOrNull() != null }) {LottoError.NOT_NUMBER }
    }
}