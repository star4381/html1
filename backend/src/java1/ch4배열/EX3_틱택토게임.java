package java1.ch4배열;

import java.util.Random;
import java.util.Scanner;

public class EX3_틱택토게임 {
	public static void main(String[] args) {
		String[] 게임판 = { "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]" };
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {	// while 1
			for(int i = 0 ; i<게임판.length ; i++) {
				System.out.print(게임판[i]);
				if(i % 3 == 2) {
					System.out.println();
				}
			} // for end
			
			// 사용자 위치 입력받기
			while( true ) { // 무한루프 [ 종료조건 : 승리판단 있을 경우 ]	// while 2
				System.out.print("위치 선택[0~8] : ");
				int 위치 = scanner.nextInt();
				if(위치 < 0 || 위치 > 8) {
					System.out.println("안내) 선택할 수 없는 번호입니다.");
				}
				if(게임판[위치].equals("[ ]")) {
					게임판[위치] = "[O]";
					break;
				} else {
					System.out.println("안내) 이미 알이 존재하는 위치입니다.");
				}
			} // while 2 end
			
			while( true ) { // while 2
				Random random = new Random();
				int 위치;
				위치 = random.nextInt(9);
				if(게임판[위치].equals("[ ]")) {
					게임판[위치] = "[X]";
					break;
				}
			} // while 2 end
			
			for(int i = 0 ; i<게임판.length ; i++) {
				if(i == 0 || i == 3 || i == 6) {					
					if(게임판[i] == "O" && 게임판[i+1] == "O" && 게임판[i+2] == "O") {
						System.out.println("승리입니다.");
					}
				}
				if(게임판[i] == "O" && 게임판[i+3] == "O" && 게임판[i+6] == "O") {
					System.out.println("승리입니다.");
				}
				if(게임판[i] == "O" && 게임판[i+1] == "O" && 게임판[i+2] == "O") {
					System.out.println("승리입니다.");
				}
				if(게임판[i] == "O" && 게임판[i+1] == "O" && 게임판[i+2] == "O") {
					System.out.println("승리입니다.");
				}
			}
			
		} // while 1 end
	}	
}

/*
	
	틱택토 게임
		[ 조건 ]
		1. 게임판 9칸 사용 -> 배열[0~8]
			1. String 배열	클래스는 비교연산자 불가능 -------->
				== : 그래서 문자열1.equals(문자열2)
				!= : !문자열.equals(문자열2)
		2. 사용자[O]가 알을 두고자 하는 위치[인덱스]
			1. 선택된 위치가 이미 다른 알이 존재하면 재입력 [ 중복 제거 ]
		3. 컴퓨터[X]가 난수생성[0~8]
			1. 난수의 위치가 이미 다른 알이 존재하면 재생성 [ 중복 제거 ]
		4. 승리자 판단 [ 1. 가로로 이기는 수 2. 세로로 이기는 수 3. 대각선으로 이기는 수 4. 무승부 ]
			
		
		[ 출력 ]
			1. 게임판 출력 예시
			[ ] [ ] [ ]
			[ ] [ ] [ ]
			[ ] [ ] [ ]
	
*/