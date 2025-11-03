package lotto.controller

import lotto.model.domain.Lotto
import lotto.model.domain.LottoGenerator
import lotto.model.domain.LottoResult
import lotto.model.domain.ProfitCalculator
import lotto.model.domain.PurchaseAmount
import lotto.model.domain.WinningNumber
import lotto.view.console.ConsoleView

object LottoController {
    fun run(){
        val view = ConsoleView()

        val purchaseAmountInput = view.readPurchaseAmount()
        val tryCount = PurchaseAmount(purchaseAmountInput).toInt()
        val lottos: List<Lotto> = LottoGenerator().generateMultiple(tryCount)

        view.printPurchasedLottos(lottos)
        val winningNumbersInput = view.readWinningNumbers()
        val winningNumbers = WinningNumber(winningNumbersInput).parse(winningNumbersInput)

        val bonusNumberInput = view.readBonusNumber()
        val bonusNumber = bonusNumberInput.toInt()

        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val results = lottoResult.calculate()

        view.printWinningStatistics(results)

        val calculator = ProfitCalculator()
        val profitRate = calculator.calculate(results, purchaseAmountInput.toInt())
        view.printProfitRate(profitRate)
    }
}