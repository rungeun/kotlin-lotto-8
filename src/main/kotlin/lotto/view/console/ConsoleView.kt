package lotto.view.console

import lotto.model.domain.Lotto
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
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it) }.also { println() }
    }
}