package lotto.view.console

import lotto.view.Guide
import lotto.view.contract.Output

object InputGuide : Output {
    override fun purchaseAmount() {
        println(Guide.PURCHASE_AMOUNT)
    }

    override fun winningNumber() {
        println(Guide.WINNING_NUMBER)
    }

    override fun bonusNumber() {
        println(Guide.BONUS_NUMBER)
    }

}