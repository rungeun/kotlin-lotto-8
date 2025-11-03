package lotto.model.domain

import lotto.view.LottoRank


class LottoResult(
    private val lottos: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun calculate(): Map<LottoRank, Int> {
        val results = mutableMapOf<LottoRank, Int>()
        LottoRank.values().forEach { results[it] = 0 }

        lottos.forEach { lotto ->
            val rank = determineRank(lotto)
            results[rank] = results.getValue(rank) + 1
        }

        return results
    }

    private fun determineRank(lotto: Lotto): LottoRank {
        val matchCount = lotto.countMatches(winningNumbers)
        val bonusMatch = lotto.containsNumber(bonusNumber)

        return when {
            matchCount == 6 -> LottoRank.FIRST
            matchCount == 5 && bonusMatch -> LottoRank.SECOND
            matchCount == 5 -> LottoRank.THIRD
            matchCount == 4 -> LottoRank.FOURTH
            matchCount == 3 -> LottoRank.FIFTH
            else -> LottoRank.SIXTH
        }
    }
}