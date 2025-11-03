package lotto.model.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun generateMultiple(count: Int): List<Lotto> {
        return List(count) { generate() }
    }
}