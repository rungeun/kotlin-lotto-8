package lotto.view

enum class Guide(val text: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    override fun toString() = text
}

enum class LottoError(val message: String) {
    SIZE("로또 번호는 6개여야 합니다."),
    RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE("로또 번호는 중복될 수 없습니다."),
    NOT_NUMBER("로또 번호는 숫자여야 합니다."),
    POSITIVE("로또 번호는 양수 정수여야 합니다."),
    EMPTY("당첨 번호를 입력해주세요.");

    override fun toString() = "[ERROR] $message"
}

enum class BonusNumberError(val message: String) {
    EMPTY("보너스 번호를 입력해주세요."),
    NOT_NUMBER("보너스 번호는 숫자여야 합니다."),
    NOT_INTEGER("보너스 번호는 정수여야 합니다."),
    POSITIVE("보너스 번호는 양의 정수여야 합니다."),
    RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    SINGLE("보너스 번호는 1개의 숫자여야 합니다."),
    DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    override fun toString() = "[ERROR] $message"
}

enum class PurchaseAmountError(val message: String) {
    EMPTY("구입 금액을 입력해주세요."),
    NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    NOT_INTEGER("구입 금액은 정수여야 합니다."),
    POSITIVE("구입 금액은 양수여야 합니다."),
    MINIMUM("구입 금액은 1,000원 이상이어야 합니다."),
    UNIT("구입 금액은 1,000원 단위여야 합니다."),
    TOO_LARGE("구입 금액이 너무 큽니다.");

    override fun toString() = "[ERROR] $message"
}

enum class OutputMessage(val message: String) {
    PURCHASE_COUNT("개를 구매했습니다."),
    STATISTICS_HEADER("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");

    fun format(count: Int) = "$count$message"
    fun format(rate: String) = message.format(rate)
}

enum class LottoRank(val matchCount: Int, val prize: Int, val message: String) {
    SIXTH(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");
}

