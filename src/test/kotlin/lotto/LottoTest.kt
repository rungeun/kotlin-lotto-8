package lotto

import lotto.model.domain.Lotto
import lotto.view.LottoExceptionMessages
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다")
    fun `개수가 6개 미만이면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(1, 2, 3)) }
            .withMessageContaining(LottoExceptionMessages.SIZE.message)
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    fun `개수가 6개 초과면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .withMessageContaining(LottoExceptionMessages.SIZE.message)
    }

    @Test
    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다")
    fun `번호가 1 미만이면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(0, 1, 2, 3, 4, 5)) }
            .withMessageContaining(LottoExceptionMessages.POSITIVE.message)
    }

    @Test
    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다")
    fun `번호가 45 초과면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .withMessageContaining(LottoExceptionMessages.RANGE.message)
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    fun `중복 번호면 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .withMessageContaining(LottoExceptionMessages.DUPLICATE.message)
    }

    @Test
    @DisplayName("로또 번호에 음수가 있으면 예외가 발생한다")
    fun `음수 포함시 예외 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(listOf(-1, 2, 3, 4, 5, 6)) }
            .withMessageContaining(LottoExceptionMessages.POSITIVE.message)
    }
}
