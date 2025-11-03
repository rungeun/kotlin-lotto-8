package lotto.model.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 번호 1개 생성")
    fun `로또 번호 1개 생성`() {
        val generator = LottoGenerator()
        val lotto = generator.generate()
        assert(lotto != null)
    }

    @Test
    @DisplayName("로또 번호 여러 개 생성")
    fun `로또 번호 여러 개 생성`() {
        val generator = LottoGenerator()
        val lottos = generator.generateMultiple(5)
        assert(lottos.size == 5)
    }

    @Test
    @DisplayName("생성된 로또는 모두 다른 번호 조합")
    fun `생성된 로또는 모두 다른 번호 조합`() {
        val generator = LottoGenerator()
        val lottos = generator.generateMultiple(10)
        val uniqueLottos = lottos.distinct()
        assert(lottos.size == uniqueLottos.size)
    }
}