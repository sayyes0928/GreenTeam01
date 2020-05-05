package team1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class IdRe extends Model { // ID 중복확인 및 로그인시 ID가 존재하는지 확인한기 위한 클래스

	Scanner sc = new Scanner(System.in);
//	static String list[];

	void idcheck(String Id) throws IOException { // (8) : (7)에서 넘어온 ID중복 확인을 위한 메소드 실행

		String ID = Id;// (9) 입력받은 매개변수 ID를 idcheck 메소드에서 사용 가능하게 변수에 넣음
		Boolean result = true;
		String idCheck = null;
		ArrayList<String> arrUser = new ArrayList<String>();

		// System.out.println("출력확인"); 호출 확인용
		while (result == true) {
			try { // Input을 하기위해 try.catch 사용
//				System.out.println("ID 들오온 값 확인" + ID);
				BufferedReader userList = new BufferedReader(
						new InputStreamReader(new FileInputStream("d:userList.txt")));
				// System.out.println("출력확인0"); // 호출 확인용

				// (10)userList 호출 userList 객체는 userList를 모두 갖고있다.

//				while ((idCheck = userList.readLine()) != null) {
//					System.out.println("어레이 체크");
//					arrUser.add(non);
//				}
//				userList.close();

				idCheck = userList.readLine();

//				System.out.println(ID + "아이디 흐름 확인");
//				System.out.println("idchek"); // 진행 확인

				String[] list = idCheck.split(",");

				for (String s : list) {
					// System.out.println(s.trim());
				}

//				System.out.println(result + "1"); 값 변환 확인

				for (String s : list) {
					// System.out.println(s);// 진행 확인
					// System.out.println(list[2] + "정보출력 확인");

					if (ID.equals(s.trim())) {
//						System.out.println(s.trim() + "ID d와 비교하는 트립값");
						result = false;
						break;
					} else {
//						System.out.println("출력확인8");
					}
				}

//				System.out.println(result + "4");

				if (result == false) {
					System.out.println("중복되는 ID가 존재합니다.");
					System.out.println("ID를 재입력 해주세요");
					result = true;
				} else {
					break;
				}
				ID = sc.next();

				// System.out.println("ID 확인 " + ID);
//				System.out.println("출력확인5");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
			}
		}
	}

	Boolean idcheck2(String Id) throws IOException { // (8) : (7)에서 넘어온 ID중복 확인을 위한 메소드 실행

		String ID = Id;// (9) 입력받은 매개변수 ID를 idcheck 메소드에서 사용 가능하게 변수에 넣음
		Boolean result = true;
		String idCheck = null;

		// System.out.println("출력확인"); 호출 확인용
		while (result == true) {
			try { // Input을 하기위해 try.catch 사용
					// System.out.println("ID 들오온 값 확인" + ID);
				BufferedReader userList = new BufferedReader(
						new InputStreamReader(new FileInputStream("d:userList.txt")));
				// System.out.println("출력확인0"); // 호출 확인용

				// (10)userList 호출 userList 객체는 userList를 모두 갖고있다.

//				while ((idCheck = userList.readLine()) != null) {
//					System.out.println("어레이 체크");
//					arrUser.add(non);
//				}
//				userList.close();
				idCheck = userList.readLine();

				String[] list = idCheck.split(",");
				for (String s : list) {
					// System.out.println(s.trim());
				}

				for (String s : list) {
					// System.out.println(s);// 진행 확인
					if (ID.equals(s.trim())) {
						result = false;
						break;
					}
				}

				if (result == true) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
			}
		}
		return result;
	}

}