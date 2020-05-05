package team1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OutputData {
	Scanner sc = new Scanner(System.in);
	Model model = new Model();
	View view = new View();
	IdRe idre = new IdRe(); // ID 중복확인을 위한 클래스의 메소드 생성

	void update(String ID) throws IOException { // 수정메소드
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BufferedOutputStream user = null;
		String Id = ID;
		// FileOutputStream user = null; // fileOutPut을 할 객체 생성
		try { // IO에서는 필수로 설정

			user = new BufferedOutputStream(new FileOutputStream("d:" + Id + ".txt")); // 덮어쓰기위해 true 쓰지않음

			System.out.println("name 입력");
			String Name = "," + sc.next();

			System.out.println("birth 입력");
			String Birth = "," + sc.next();

			System.out.println("email 입력");
			String Email = "," + sc.next();

			System.out.println("addr 입력");
			String Addr = "," + sc.next();

			System.out.println("phone 입력");
			String Phone = "," + sc.next();
			
			System.out.println("수정이 완료되었습니다.");
			System.out.println("재 로그인 하세요./n");
			

			byte name[] = Name.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(name);
			byte birth[] = Birth.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(birth);
			byte email[] = Email.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(email);
			byte addr[] = Addr.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(addr);
			byte phone[] = Phone.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(phone);

		} catch (Exception e) {
			System.out.println(e + " => 요류");
		} finally {
			try {
				user.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	void delete(String ID) {
		String Id = ID;
		try {

			File user = new File("d:" + Id + ".txt");
			File userList =new File("d:userList.txt");
			user.delete();
			System.out.println("회원정보가 삭제되었습니다.\n");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void input() throws IOException { // (4) : (3)-1 에서 넘어온 회원가입 메소드
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BufferedOutputStream userList = null;
		BufferedOutputStream user = null;
		// FileOutputStream user = null; // fileOutPut을 할 객체 생성
		try { // IO에서는 필수로 설정
			userList = new BufferedOutputStream(new FileOutputStream("d:userList.txt", true));// (5) 입력한 정보를 저장해 텍스트 파일로
																								// 보낼 객체 생성
			// (5)-1 ID중복체크를 위한 user의 전체 ID가 들어있는 txt 파일을 userList 객체에 담는다.
			// (5)-2 userList에 등록하는 작업은 제일 마지막에 실행, 회원가입 도중 취소 할 경우
			//

			System.out.println("id 입력"); // (6) 회원가입 선택시 1.번으로 입력을 요청받음
			String IdTxt = sc.next(); // (6)

			idre.idcheck(IdTxt); // (7) ID중복확인을 위해 idcheck() 메소드로 이동, 입력받은 만들고자하는 ID값을 들고 이동

			// System.out.println("출력확인"); 메소드 실행 후 복귀 확인

			user = new BufferedOutputStream(new FileOutputStream("d:" + IdTxt + ".txt", true)); // (8) user 정보를 저장할 텍스트
																								// 파일 생성

			System.out.println("pw 입력");
			String Pw = "," + sc.next(); // (9) 구분자 "," 를 통해서 입력한 정보들을 구분한다.

			System.out.println("pw 확인 입력");
			String PwRe = "," + sc.next();

			while (!Pw.equals(PwRe)) { // (10) 비밀번호 입력 확인
				System.out.println("비밀번호가 틀렸습니다. 재입력 하세요");

				System.out.println("pw 입력");
				Pw = "," + sc.next();

				System.out.println("pw 확인 입력");
				PwRe = "," + sc.next();
			}

			System.out.println("name 입력");
			String Name = "," + sc.next();

			System.out.println("birth 입력");
			String Birth = "," + sc.next();

			System.out.println("email 입력");
			String Email = "," + sc.next();

			System.out.println("addr 입력");
			String Addr = "," + sc.next();

			System.out.println("phone 입력");
			String Phone = "," + sc.next();

			byte id[] = IdTxt.getBytes(); // (11) 입력받은 정보들을 byte 단위로 쪼개어 객체 b에 저장
			user.write(id); // (12) write method를 이용해서 b의 내용을 텍스트에 저장

			String IdTxt2 = IdTxt + ","; // (13) 등록한 uesrID를 userList에 담아 중복확인에 사용 가능하도록 한다. 구분자 사용
			byte idCheck[] = IdTxt2.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			userList.write(idCheck); // method를 이용해서 b의 내용을 bw에 write

			byte pw[] = Pw.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(pw);
			byte name[] = Name.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(name);
			byte birth[] = Birth.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(birth);
			byte email[] = Email.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(email);
			byte addr[] = Addr.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(addr);
			byte phone[] = Phone.getBytes(); // byte 단위로 쪼개어 객체 b에 저장
			user.write(phone);

		} catch (Exception e) {
			System.out.println(e + " => 요류");
		} finally {
			try {
				user.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				userList.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
// Input은 In을 해서 가져올 결과가 없기때문에 오류를 띄운다
//
//System.out.println("available = " + f2.available()); //읽어 올 수 있는 byte 수
//byte b3[] = new byte[f2.available()]; //일어올 수 있는 만큼의 byte
//
//while(f2.read(b3) != -1) {} //file의 끝을 ' -1 '로 처리한다. -1이 file 끝에 반환되기 떄문
//                  //read b를 읽어 온다.
//
//String data4 = new String(b3); //b를 정상적인 Data로 만들어줘라 
//System.out.println(data4);

// while (!(Id = sc.nextLine()).equals("quit")) {// 종료문 입력시 종료
// data 변수를 sc.next()와 같다고 했기 때문에
// data 는 Object 가 된다.
// }
