package lotto.model

import lotto.view.LottoError
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import lotto.model.domain.WinningNumber

class WinningNumberTest {

    @Test
    @DisplayName("빈 입력이면 예외 발생")
    fun `빈 입력이면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { WinningNumber("") }
            .withMessageContaining(LottoError.EMPTY.message)
    }

    @Test
    @DisplayName("공백만 입력하면 예외 발생")
    fun `공백만 입력하면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { WinningNumber("   ") }
            .withMessageContaining(LottoError.EMPTY.message)
    }

    @Test
    @DisplayName("문자 포함시 예외 발생")
    fun `문자 포함시 예외 발생`() {
        val winningNumber = WinningNumber("1,2,3,a,5,6")
        assertThatIllegalArgumentException()
            .isThrownBy { winningNumber.parse("1,2,3,a,5,6") }
            .withMessageContaining(LottoError.NOT_NUMBER.message)
    }

    @Test
    @DisplayName("정상 입력시 정수 리스트 반환")
    fun `정상 입력시 정수 리스트 반환`() {
        val winningNumber = WinningNumber("1,2,3,4,5,6")
        val result = winningNumber.parse("1,2,3,4,5,6")
        assert(result == listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("공백 포함 입력시 정수 리스트 반환")
    fun `공백 포함 입력시 정수 리스트 반환`() {
        val winningNumber = WinningNumber("1, 2, 3, 4, 5, 6")
        val result = winningNumber.parse("1, 2, 3, 4, 5, 6")
        assert(result == listOf(1, 2, 3, 4, 5, 6))
    }
}