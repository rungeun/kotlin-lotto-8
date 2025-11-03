package lotto.model.domain

import lotto.view.LottoError

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {LottoError.SIZE }
        require(numbers.all { it > 0 }) {LottoError.POSITIVE }
        require(numbers.all { it in 1..45 }) {LottoError.RANGE }
        require(numbers.distinct().size == 6) {LottoError.DUPLICATE }
    }

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsNumber(number: Int): Boolean {
        return number in numbers
    }

    override fun toString(): String = numbers.toString()
}