package lotto.view

enum class Guide(val text: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    override fun toString() = text
}

enum class LottoExceptionMessages(val message: String) {
    SIZE("로또 번호는 6개여야 합니다."),
    RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE("로또 번호는 중복될 수 없습니다."),
    NOT_NUMBER("로또 번호는 숫자여야 합니다."),
    POSITIVE("로또 번호는 양수 정수여야 합니다."),
    EMPTY("당첨 번호를 입력해주세요.");

    override fun toString() = "[ERROR] $message"
}