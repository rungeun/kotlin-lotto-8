package lotto.view.console

import lotto.model.domain.Lotto
import lotto.model.domain.ProfitCalculator
import lotto.view.LottoRank
import lotto.view.OutputMessage
import lotto.view.contract.Input
import lotto.view.contract.Output

class ConsoleView(
    private val input: Input = InputConsole,
    private val output: Output = InputGuide
) {
    fun readPurchaseAmount(): String {
        output.purchaseAmount()
        return input.read().also { println() }
    }

    fun readWinningNumbers(): String {
        output.winningNumber()
        return input.read().also { println() }
    }

    fun readBonusNumber(): String {
        output.bonusNumber()
        return input.read().also { println() }
    }

    fun printPurchasedLottos(lottos: List<Lotto>) {
        println(OutputMessage.PURCHASE_COUNT.format(lottos.size))
        lottos.forEach { println(it) }.also { println() }
    }

    fun printStatisticsHeader(){
        println(OutputMessage.STATISTICS_HEADER.message)
    }

    fun printWinningStatistics(results: Map<LottoRank, Int>) {
        printStatisticsHeader()
        listOf(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
            .forEach { rank ->
                println("${rank.message} - ${results[rank]}개")
            }
    }

    fun printProfitRate(rate: Double) {
        val formattedRate = ProfitCalculator().formatRate(rate)
        println(OutputMessage.PROFIT_RATE.format(formattedRate))
    }
}