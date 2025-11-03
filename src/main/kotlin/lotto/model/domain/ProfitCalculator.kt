package lotto.model.domain

import lotto.view.LottoRank

class ProfitCalculator {

    fun calculate(results: Map<LottoRank, Int>, purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }

    fun formatRate(rate: Double): String {
        return "%.1f".format(rate)
    }
}