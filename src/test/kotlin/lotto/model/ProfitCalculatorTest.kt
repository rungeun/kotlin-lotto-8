package lotto.model

import lotto.model.domain.ProfitCalculator
import lotto.view.LottoRank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    private val calculator = ProfitCalculator()

    @Test
    @DisplayName("당첨되지 않았을 때 수익률 0%")
    fun `당첨되지 않았을 때 수익률 0%`() {
        val results = mapOf(
            LottoRank.SIXTH to 5,
            LottoRank.FIFTH to 0,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0
        )

        val rate = calculator.calculate(results, 5000)
        assert(rate == 0.0)
    }

    @Test
    @DisplayName("5등 1개 당첨시 수익률 계산")
    fun `5등 1개 당첨시 수익률 계산`() {
        val results = mapOf(
            LottoRank.SIXTH to 7,
            LottoRank.FIFTH to 1,  // 5,000원
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0
        )

        val rate = calculator.calculate(results, 8000)
        assert(rate == 62.5)
    }

    @Test
    @DisplayName("1등 당첨시 수익률 계산")
    fun `1등 당첨시 수익률 계산`() {
        val results = mapOf(
            LottoRank.SIXTH to 0,
            LottoRank.FIFTH to 0,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 1  // 2,000,000,000원
        )

        val rate = calculator.calculate(results, 1000)
        assert(rate == 200_000_000.0)
    }

    @Test
    @DisplayName("여러 등수 당첨시 수익률 계산")
    fun `여러 등수 당첨시 수익률 계산`() {
        val results = mapOf(
            LottoRank.SIXTH to 2,
            LottoRank.FIFTH to 1,   // 5,000원
            LottoRank.FOURTH to 1,  // 50,000원
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0
        )

        val rate = calculator.calculate(results, 4000)
        // (5,000 + 50,000) / 4,000 * 100 = 1,375%
        assert(rate == 1375.0)
    }

    @Test
    @DisplayName("수익률 포맷 - 소수점 첫째자리")
    fun `수익률 포맷 - 소수점 첫째자리`() {
        val formatted = calculator.formatRate(62.5)
        assert(formatted == "62.5")
    }

    @Test
    @DisplayName("수익률 포맷 - 정수")
    fun `수익률 포맷 - 정수`() {
        val formatted = calculator.formatRate(100.0)
        assert(formatted == "100.0")
    }

    @Test
    @DisplayName("수익률 포맷 - 반올림")
    fun `수익률 포맷 - 반올림`() {
        val formatted = calculator.formatRate(62.56)
        assert(formatted == "62.6")
    }
}