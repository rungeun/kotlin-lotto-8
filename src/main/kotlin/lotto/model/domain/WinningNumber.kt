package lotto.model.domain

import lotto.view.LottoError

class WinningNumber(input: String) {
    init {
        require(input.isNotBlank()) {LottoError.EMPTY }
    }

    fun parse(input: String): List<Int> {
        val tokens = input.split(",").map { it.trim() }
        validate(tokens)
        val numbers = tokens.map { it.toInt() }
        Lotto(numbers) // Lotto 클래스에서 중복 검증
        return numbers
    }

    private fun validate(tokens: List<String>) {
        require(tokens.size == 6) { LottoError.SIZE }
        require(tokens.all { it.toIntOrNull() != null }) {LottoError.NOT_NUMBER }
    }
}