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