package lotto.view.contract

interface Output {
    fun purchaseAmount(purchaseAmount: String)
    fun winningNumber(numbers: String)
    fun bonusNumber(number: String)
}