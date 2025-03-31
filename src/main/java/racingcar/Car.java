package racingcar;

public class Car {
    String carName;
    int score;
    int winnerFlag;

    Car(String carName, int score) {
        this.carName = carName;
        this.score = score;
    }

    void go() {
        score++;
    }

    void displayCarStatus() {
        System.out.print(carName + " : ");
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    void checkWinnerFlag() {
        winnerFlag = 1;
    }

    void clearWinnerFlag() {
        winnerFlag = 0;
    }
}
