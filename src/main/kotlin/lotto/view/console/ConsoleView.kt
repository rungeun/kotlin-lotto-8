package lotto.view.console

import lotto.view.contract.Input
import lotto.view.contract.Output

class ConsoleView(
    private val input: Input = InputConsole,
    private val output: Output = InputGuide
) {
    fun readPurchaseAmount(): String {
        output.purchaseAmount()
        return input.read()
    }

    fun readWinningNumbers(): String {
        output.winningNumber()
        return input.read()
    }

    fun readBonusNumber(): String {
        output.bonusNumber()
        return input.read()
    }
}