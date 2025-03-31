package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car[] cars = carsInfoInput();
        int tryNum = tryNumInput();
        Game(cars, tryNum);
    }
    
    public static Car[] carsInfoInput() { // 사용자 입력 (자동차 목록)
        System.out.println("경주를 진행할 자동차의 이름을 ','를 기준으로 분리하여 입력해주세요.(이름은 5자 이하만 가능합니다.)");
        String[] carList = Console.readLine().split(",");
        validateCarsList(carList);
        Car[] cars = new Car[carList.length];
        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i], 0);
        }
        return cars;
    }
    
    public static int tryNumInput() { // 전진 시도 횟수 입력받기
        System.out.println("몇번의 이동을 할 지 횟수를 입력해주세요.");
        int tryNum = Integer.parseInt(Console.readLine());
        validateTryNum(tryNum);
        return tryNum;
    }

    public static void validateCarsList(String[] carsList) throws IllegalArgumentException{ // 입력한 차 이름이 5글자 이하인지 체크
        for (String carName : carsList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름이 5글자를 넘습니다.");
            }
        }
        return;
    }

    public static void validateTryNum(int tryNum) throws IllegalArgumentException{ // 입력한 시도 횟수가 0이거나, 음수인지 체크
        if (tryNum < 0) {
            throw new IllegalArgumentException("시도 횟수에 음수 입력");
        } else if (tryNum == 0) {
            throw new IllegalArgumentException("시도 횟수에 0 입력");
        }
        return;
    }
    
    public static void Game(Car[] cars, int tryNum) {
        for(int i = 0; i < tryNum; i++) {
            moveAndDisplayStatus(cars);
            System.out.println();
        }
        displayWinner(cars);
    }

    public static void moveAndDisplayStatus(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
           randomMove(cars[i]);
        }
        for (Car car : cars) {
            car.displayCarStatus();
        }
    }

    public static void randomMove(Car car) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            car.go();
        }
    }

    public static void displayWinner(Car[] cars) {
        checkWinner(cars);

        Queue<Car> q = new LinkedList<>();

        for (Car car : cars) {
            if(car.winnerFlag == 1) {
                q.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < q.size() - 1; i++) {
            System.out.print(q.remove().carName + ", ");
        }
        System.out.println(q.remove().carName);
    }


    public static void checkWinner(Car[] cars) {
        int maxValue = 0;

        for (Car car : cars) {
            if(maxValue < car.score) {
                maxValue = car.score;
                clearWinnerList(cars);
                car.checkWinnerFlag();
            } else if (maxValue == car.score) {
                car.checkWinnerFlag();
            }
        }
    }

    public static void clearWinnerList(Car[] cars) {
        for (Car car : cars) {
            car.clearWinnerFlag();
        }
    }

}
