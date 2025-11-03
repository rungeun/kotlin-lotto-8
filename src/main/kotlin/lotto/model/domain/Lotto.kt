package lotto.model.domain

import lotto.view.LottoExceptionMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LottoExceptionMessages.SIZE }
        require(numbers.all { it > 0 }) { LottoExceptionMessages.POSITIVE }
        require(numbers.all { it in 1..45 }) { LottoExceptionMessages.RANGE }
        require(numbers.distinct().size == 6) { LottoExceptionMessages.DUPLICATE }
    }

    // TODO: 추가 기능 구현
}