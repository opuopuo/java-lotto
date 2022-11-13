package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        try {
            playGame();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void playGame() {
        OutputView.printInputMoney();
        Money money = new Money(InputView.inputPurchaseMoney());
        OutputView.printBlank();
        makeLotto(money.countLotto());
        drawLottery();
    }

    private void makeLotto(int lottoCount) {
        Lottos lottos = new Lottos(LottoGenerator.generateLottos(lottoCount));
        OutputView.printPurchaseLotto(lottos.getLottos());
    }

    private void drawLottery() {
        OutputView.printInputWinningNumber();
        Lotto winningLottoNumber = new Lotto(InputView.inputWinningNumber());
        OutputView.printBlank();

        OutputView.printInputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, InputView.inputBonusNumber());
        OutputView.printBlank();
    }
}