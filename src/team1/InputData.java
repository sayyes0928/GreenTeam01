package team1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputData {

	Scanner sc = new Scanner(System.in);
	View view = new View();
	IdRe idre = new IdRe();
	Model model = new Model();
	OutputData outdata = new  OutputData();
	String Id = null;
	String pass = null;
	String num;
	Boolean result;

	Boolean print() throws IOException {
		try {// 로그인 선택시 출력화면
			System.out.println("로그인을 선택하셨습니다.\n");
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.println("========================\n");
			System.out.println("ID:");

			Id = sc.nextLine(); // ID 입력시
			model.setId(Id);

			idre.idcheck2(Id);
			// System.out.println(idre.idcheck2(Id));

			if (idre.idcheck2(Id) == true) {
				System.out.println("가입된 ID가 없습니다.");
			} else {
				System.out.println("비밀번호를 입력하세요");
				pass = sc.next();
				password(pass);
				if (true) {
					result = true;
					view.update();
					num = sc.next();
				} 
			}
			
			if (num.equals("1")) {
				outdata.update(model.getId());
			} else if(num.equals("2")){
				outdata.delete(model.getId());

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	Boolean password(String pass) throws IOException { // 패스워드 메소드
		boolean result = false;
		try {
		//	System.out.println("체크 2");
			String passw = pass;

			BufferedReader userInfo = new BufferedReader(
					new InputStreamReader(new FileInputStream("d:" + model.getId() + ".txt")));

			String userinfo = userInfo.readLine();

			String[] list = userinfo.split(",");

			for (String s : list) {// user정보 배열 생성
			}

			if (passw.equals(list[1])) {
				System.out.println("로그인에 성공했습니다.");
				result = true;
			} else {
				System.out.println("비밀번호가 맞지 않습니다.");
			}
			if (result == true) {
				System.out.println("ID : "+list[0]);
				model.setId(list[0]); //클래스에서 사용 가능하도록 set
				
				System.out.println("name : "+list[2]);
				model.setName(list[2]);
				
				System.out.println("birth : "+list[3]);
				model.setBir(list[3]);
				
				System.out.println("tel : "+list[4]); 
				model.setTel(list[4]);
				
				System.out.println("address : "+list[5]);
				model.setAddr(list[5]);
				
				System.out.println("mail : "+list[6]+"\n");
				model.setMail(list[6]);
			}
		//	System.out.println("체크 3");
			userInfo.close();
		} catch (Exception e) {
		} finally {

		}
		return result; // 비밀번호가 맞으면 true 반환
	}

}
