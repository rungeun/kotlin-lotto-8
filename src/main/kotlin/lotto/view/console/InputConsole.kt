package lotto.view.console

import lotto.view.contract.Input
import camp.nextstep.edu.missionutils.Console

object InputConsole : Input {
    override fun read(): String = Console.readLine()
}