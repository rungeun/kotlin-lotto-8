package lotto.model.domain

import lotto.view.PurchaseAmountError
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PurchaseAmountTest {

    @Test
    @DisplayName("빈 입력이면 예외 발생")
    fun `빈 입력이면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("") }
            .withMessageContaining(PurchaseAmountError.EMPTY.message)
    }

    @Test
    @DisplayName("공백만 입력하면 예외 발생")
    fun `공백만 입력하면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("   ") }
            .withMessageContaining(PurchaseAmountError.EMPTY.message)
    }

    @Test
    @DisplayName("문자 입력시 예외 발생")
    fun `문자 입력시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("abc") }
            .withMessageContaining(PurchaseAmountError.NOT_NUMBER.message)
    }

    @Test
    @DisplayName("소수점 포함시 예외 발생")
    fun `소수점 포함시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("1000.5") }
            .withMessageContaining(PurchaseAmountError.NOT_INTEGER.message)
    }

    @Test
    @DisplayName("음수 입력시 예외 발생")
    fun `음수 입력시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("-1000") }
            .withMessageContaining(PurchaseAmountError.POSITIVE.message)
    }

    @Test
    @DisplayName("0 입력시 예외 발생")
    fun `0 입력시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("0") }
            .withMessageContaining(PurchaseAmountError.POSITIVE.message)
    }

    @Test
    @DisplayName("1000원 미만 입력시 예외 발생")
    fun `1000원 미만 입력시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("300") }
            .withMessageContaining(PurchaseAmountError.MINIMUM.message)
    }

    @Test
    @DisplayName("1000원 단위가 아니면 예외 발생")
    fun `1000원 단위가 아니면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("1200") }
            .withMessageContaining(PurchaseAmountError.UNIT.message)
    }

    @Test
    @DisplayName("너무 큰 값 입력시 예외 발생")
    fun `너무 큰 값 입력시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { PurchaseAmount("2000000000000") }
            .withMessageContaining(PurchaseAmountError.NOT_INTEGER.message)
    }

    @Test
    @DisplayName("정상 입력시 로또 구매 개수 반환")
    fun `정상 입력시 로또 구매 개수 반환`() {
        val purchaseAmount = PurchaseAmount("5000")
        assert(purchaseAmount.toInt() == 5)
    }

    @Test
    @DisplayName("1000원 입력시 1개 반환")
    fun `1000원 입력시 1개 반환`() {
        val purchaseAmount = PurchaseAmount("1000")
        assert(purchaseAmount.toInt() == 1)
    }
}