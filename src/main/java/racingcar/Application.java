package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        carsInfoInput();
        int tryNum = tryNumInput();
        Game(carsList, tryNum);
    }
    
    public static void carsInfoInput() { // 사용자 입력 (자동차 목록)
        System.out.println("경주를 진행할 자동차의 이름을 ','를 기준으로 분리하여 입력해주세요.(이름은 5자 이하만 가능합니다.)");
        String[] carList = carSplit(Console.readLine());
        validateCarsList(carList);
        Car[] cars = new Car[carList.length];
    }
    
    public static String[] carSplit(String carsStr) { // 사용자 한테 입려받은 문자열 "," 기준으로 찢기
        return carsStr.split(",");
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
    
    public static void Game(String[] carsList, int tryNum) {
        int[] moveCnt = new int[carsList.length];
        for (int i = 0; i < carsList.length; i++){
            moveCnt[i] = 0;
        }
        for (int i = 0; i < tryNum; i++) {
            moveCnt = move(carsList, moveCnt);
            printEachMove(carsList, moveCnt);
        }

        String[] winner = checkWinner(carsList, moveCnt);
        System.out.print("최종 우승자 : ");
        int winnerCnt = 0;
        for(int i=0; i < winner.length; i++) {
            if (winner[i] == null){
                break;
            }
            winnerCnt++;
        }
        for (int i = 0; i < winnerCnt-1; i++) {
            System.out.print(winner[i] + ", ");
        }
        System.out.println(winner[winnerCnt-1]);

    }

    public static int[] move(String[] carsList, int[] moveCnt) {
        for (int i = 0; i < carsList.length; i++) {
           moveCnt = randomMove(moveCnt, i);
        }
        return moveCnt;
    }

    public static int[] randomMove(int[] moveCnt, int i) {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            moveCnt[i]++;
        }
        return moveCnt;
    }

    public static void printEachMove(String[] carsList, int[] moveCnt){
        for (int i = 0; i < carsList.length; i++) {
            System.out.print(carsList[i] + " : ");
            for (int j =0; j < moveCnt[i]; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String[] checkWinner(String[] carsList, int[] moveCnt) {
        int maxValue = 0;
        int cnt = 0;
        String[] winner = new String[moveCnt.length];
        for (int i = 0; i < moveCnt.length; i++) {
            if(moveCnt[i] == maxValue) {
                winner[cnt] = carsList[i];
                cnt++;
            } else if (moveCnt[i] > maxValue) {
                Arrays.fill(winner, null);
                cnt = 0;
                winner[cnt] = carsList[i];
                cnt++;
                maxValue = moveCnt[i];
            }
        }
        return winner;
    }

}
