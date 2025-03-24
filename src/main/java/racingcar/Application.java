package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carsStr = carInput();
        String carsList[] = carSplit(carsStr);
        errCheck_carsList(carsList);
        int tryNum = tryNumInput();
        errCheck_tryNum(tryNum);
    }
    
    public static String carInput() { // 사용자 입력 (자동차 목록)
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주를 진행할 자동차의 이름을 ','를 기준으로 분리하여 입력해주세요.(이름은 5자 이하만 가능합니다.)");
        String cars = scanner.nextLine();
        return cars;
    }
    
    public static String[] carSplit(String carsStr) { // 사용자 한테 입려받은 문자열 "," 기준으로 찢기
        String[] carsList = carsStr.split(",");
        return carsList;
    }
    
    public static int tryNumInput() { // 전진 시도 횟수 입력받기
        Scanner scanner = new Scanner(System.in);

        System.out.println("몇번의 이동을 할 지 횟수를 입력해주세요.");
        int tryNum = scanner.nextInt();
        return tryNum;
    }

    public static void errCheck_carsList(String[] carsList) throws IllegalArgumentException{ // 입력한 차 이름이 5글자 이하인지 체크
        for (String s : carsList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름이 5글자를 넘습니다.");
            }
        }
        return;
    }

    public static void errCheck_tryNum(int tryNum) throws IllegalArgumentException{ // 입력한 시도 횟수가 0이거나, 음수인지 체크
        if (tryNum < 0) {
            throw new IllegalArgumentException("시도 횟수에 음수 입력");
        } else if (tryNum == 0) {
            throw new IllegalArgumentException("시도 횟수에 0 입력");
        }
        return;
    }
}
