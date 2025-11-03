package lotto.controller

import lotto.model.domain.BonusNumber
import lotto.model.domain.Lotto
import lotto.model.domain.LottoGenerator
import lotto.model.domain.LottoResult
import lotto.model.domain.ProfitCalculator
import lotto.model.domain.PurchaseAmount
import lotto.model.domain.WinningNumber
import lotto.view.LottoError
import lotto.view.console.ConsoleView

object LottoController {
    fun run() {
        val view = ConsoleView()

        val purchaseAmountInput = getPurchaseAmount(view)
        val tryCount = PurchaseAmount(purchaseAmountInput).toInt()
        val lottos: List<Lotto> = LottoGenerator().generateMultiple(tryCount)

        view.printPurchasedLottos(lottos)

        val winningNumbersInput = getWinningNumbers(view)
        val winningNumbers = WinningNumber(winningNumbersInput).parse(winningNumbersInput)

        val bonusNumber = getBonusNumber(view, winningNumbers)

        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val results = lottoResult.calculate()

        view.printWinningStatistics(results)

        val calculator = ProfitCalculator()
        val totalAmount = tryCount * 1000  // 구매 개수 * 1000원
        val profitRate = calculator.calculate(results, totalAmount)
        view.printProfitRate(profitRate)
    }

    private fun getPurchaseAmount(view: ConsoleView): String {
        while (true) {
            try {
                val input = view.readPurchaseAmount()
                PurchaseAmount(input)
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getWinningNumbers(view: ConsoleView): String {
        while (true) {
            try {
                val input = view.readWinningNumbers()
                WinningNumber(input).parse(input)
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getBonusNumber(view: ConsoleView, winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val input = view.readBonusNumber()
                return BonusNumber(input, winningNumbers).toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}