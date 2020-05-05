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
		try {// �α��� ���ý� ���ȭ��
			System.out.println("�α����� �����ϼ̽��ϴ�.\n");
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���.");
			System.out.println("========================\n");
			System.out.println("ID:");

			Id = sc.nextLine(); // ID �Է½�
			model.setId(Id);

			idre.idcheck2(Id);
			// System.out.println(idre.idcheck2(Id));

			if (idre.idcheck2(Id) == true) {
				System.out.println("���Ե� ID�� �����ϴ�.");
			} else {
				System.out.println("��й�ȣ�� �Է��ϼ���");
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

	Boolean password(String pass) throws IOException { // �н����� �޼ҵ�
		boolean result = false;
		try {
		//	System.out.println("üũ 2");
			String passw = pass;

			BufferedReader userInfo = new BufferedReader(
					new InputStreamReader(new FileInputStream("d:" + model.getId() + ".txt")));

			String userinfo = userInfo.readLine();

			String[] list = userinfo.split(",");

			for (String s : list) {// user���� �迭 ����
			}

			if (passw.equals(list[1])) {
				System.out.println("�α��ο� �����߽��ϴ�.");
				result = true;
			} else {
				System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
			}
			if (result == true) {
				System.out.println("ID : "+list[0]);
				model.setId(list[0]); //Ŭ�������� ��� �����ϵ��� set
				
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
		//	System.out.println("üũ 3");
			userInfo.close();
		} catch (Exception e) {
		} finally {

		}
		return result; // ��й�ȣ�� ������ true ��ȯ
	}

}
