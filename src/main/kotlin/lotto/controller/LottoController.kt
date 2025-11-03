package lotto.controller

import lotto.model.domain.Lotto
import lotto.model.domain.LottoGenerator
import lotto.model.domain.PurchaseAmount
import lotto.view.console.ConsoleView

object LottoController {
    fun run(){
        val view = ConsoleView()

        val purchaseAmountInput = view.readPurchaseAmount()
        val tryCount = PurchaseAmount(purchaseAmountInput).toInt()
        val lottos: List<Lotto> = LottoGenerator().generateMultiple(tryCount)

        val winningNumbers = view.readWinningNumbers()

        val bonusNumber = view.readBonusNumber()
    }
}