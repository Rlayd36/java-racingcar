package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carsStr = carInput();
        String carsList[] = carSplit(carsStr);
    }
    
    public static String carInput() { // 사용자 입력 (자동차 목록)
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("경주를 진행할 자동차들을 ','를 기준으로 분리하여 입력해주세요.(이름은 5자 이하만 가능합니다.)");
        String cars = scanner.nextLine();
        return cars;
    }
    
    public static String[] carSplit(String carsStr) {
        String[] carsList = carsStr.split(",");
        return carsList;
    }
    
    
    
}
