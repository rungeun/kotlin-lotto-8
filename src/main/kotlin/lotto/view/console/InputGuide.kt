package lotto.view.console

import lotto.view.Guide
import lotto.view.contract.Output

object InputGuide : Output {
    override fun purchaseAmount(purchaseAmount: String) {
        println(Guide.PURCHASE_AMOUNT)
    }

    override fun winningNumber(numbers: String) {
        println(Guide.WINNING_NUMBER)
    }

    override fun bonusNumber(number: String) {
        println(Guide.BONUS_NUMBER)
    }

}