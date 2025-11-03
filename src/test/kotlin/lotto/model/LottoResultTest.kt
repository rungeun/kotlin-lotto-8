package lotto.model.domain

import lotto.view.LottoRank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    @DisplayName("6개 일치시 1등")
    fun `6개 일치시 1등`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.FIRST] == 1)
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치시 2등")
    fun `5개 일치 + 보너스 일치시 2등`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.SECOND] == 1)
    }

    @Test
    @DisplayName("5개 일치 + 보너스 불일치시 3등")
    fun `5개 일치 + 보너스 불일치시 3등`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 8)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.THIRD] == 1)
    }

    @Test
    @DisplayName("4개 일치시 4등")
    fun `4개 일치시 4등`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 8, 9)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.FOURTH] == 1)
    }

    @Test
    @DisplayName("3개 일치시 5등")
    fun `3개 일치시 5등`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 8, 9, 10)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.FIFTH] == 1)
    }

    @Test
    @DisplayName("2개 이하 일치시 낙첨")
    fun `2개 이하 일치시 낙첨`() {
        val lottos = listOf(Lotto(listOf(1, 2, 8, 9, 10, 11)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.SIXTH] == 1)
    }

    @Test
    @DisplayName("여러 로또의 당첨 통계 계산")
    fun `여러 로또의 당첨 통계 계산`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),     // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)),     // 2등
            Lotto(listOf(1, 2, 3, 4, 8, 9))      // 4등
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult(lottos, winningNumbers, bonusNumber)
        val statistics = result.calculate()

        assert(statistics[LottoRank.FIRST] == 1)
        assert(statistics[LottoRank.SECOND] == 1)
        assert(statistics[LottoRank.FOURTH] == 1)
        assert(statistics[LottoRank.FIFTH] == 0)
    }
}