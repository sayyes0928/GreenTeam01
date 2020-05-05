package team1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	// 데이터 교환을 위한 각 클래스 객체 생성
	OutputData outdata = new OutputData();
	InputData indata = new InputData();
	Model model = new Model();
	View view = new View();
	// ArrayList<Model> arr = new ArrayList<Model>();

	void Start() throws IOException {// 프로그램 시작시 제일 먼저 시작

		// boolean result = true;
		view.start(); // (1) 시작메뉴 출력

		Scanner sc = new Scanner(System.in); // (2) 선택 할 메뉴를 입력받는다
		int num = sc.nextInt(); // (2)

		while (num != 3) {// (3) while 문을 통해 메뉴가 항상 초기 화면을 출력 할 수 있도록 만든다.

			if (num == 1) { // 1번 입력시 회원정보 입력메소드 (input())메소드 실행

				outdata.input(); // (3)-1 회원가입 메소드 실행
				view.start();
				num = sc.nextInt();

			} else if (num == 2) { // 2번 입력시 로그인

				indata.print(); // (3)-2 로그인 메소드 실행
				view.start();
				num = sc.nextInt();
			}
		}
	}
}

//	}
//}

// view.Log();//로그인 된 화면으로 이동. 수정,삭제 화면
//				while (num != 3) {
//					if (num == 1) {// 수정
//						view.Re();
//						outdata.update();
//						break;
//					} else if (num == 2) {
//						view.Re();
//						outdata.delete();
//						break;
//					} else {
//						break;
//					}
//				}
//				break;
// Start method
// Controller class
