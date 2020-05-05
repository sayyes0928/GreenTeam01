package team1;

import java.io.BufferedReader;
import java.io.FileReader;

public class View {
	// UserInfo my = new UserInfo();


	void start() { // 시작메뉴를 화면에 출력하는 메소드
		System.out.println("회원관리프로그램");
		System.out.println("[1] 가입");
		System.out.println("[2] 로그인");
		System.out.println("[3] 종료");
		System.out.print("번호를 입력해주세요: ");
	}

	void Log() { // 로그인 화면 메소드
			
			System.out.println( "님이 로그인 되셨습니다.");
//			System.out.println("[] ID: " + id);
//		//	System.out.println("[] PassWord: " + model.getPass());
//			System.out.println("[] Name: " + name);
//			System.out.println("[] Year: " +bir);
//			System.out.println("[] Tell: " + tel);
//			System.out.println("[] Addres: " + addr);
//			System.out.println("[] Mail: " + mail);
//			System.out.println("[1] 수정, [2] 삭제, [3] 로그아웃");
//			
		} 

	void update() {
		System.out.println("원하시는 기능의 번호를 입력해 주세요.");
		System.out.println("[1]정보수정 [2]정보삭제 [3]종료");

	}
}
