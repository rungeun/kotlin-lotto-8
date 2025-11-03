package lotto.controller

import lotto.model.domain.Lotto
import lotto.view.console.ConsoleView

object LottoController {
    fun run(){
        val view = ConsoleView()

        val purchaseAmount = view.readPurchaseAmount()

        val winningNumbers = view.readWinningNumbers()
        
        val bonusNumber = view.readBonusNumber()

    }
}