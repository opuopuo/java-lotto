package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeType {
    THREE(3, false, "3개 일치 (5,000원) - ", (profit -> profit * 5_000)),
    FOUR(4, false, "4개 일치 (50,000원) - ", (profit -> profit * 50_000)),
    FIVE(5, false, "5개 일치 (1,500,000원) - ", (profit -> profit * 1_500_000)),
    FIVE_BONUS(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", (profit -> profit * 30_000_000)),
    SIX(6, false, "6개 일치 (2,000,000,000원) - ", (profit -> profit * 2_000_000_000));

    private int type;
    private boolean bonus;
    private String message;
    private Function<Integer, Integer> expression;

    PrizeType(int type, boolean bonus, String message, Function<Integer, Integer> expression) {
        this.type = type;
        this.bonus = bonus;
        this.message = message;
        this.expression = expression;
    }

    public int calculateProfit(int count) {
        return expression.apply(count);
    }

    public static PrizeType getPrizeType(int count, boolean bonus) {
        return Arrays.stream(PrizeType.values())
                .filter(prize -> prize.type == count && prize.bonus == bonus)
                .findFirst()
                .orElse(null);
    }
}