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
	IdRe idre = new IdRe(); // ID �ߺ�Ȯ���� ���� Ŭ������ �޼ҵ� ����

	void update(String ID) throws IOException { // �����޼ҵ�
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BufferedOutputStream user = null;
		String Id = ID;
		// FileOutputStream user = null; // fileOutPut�� �� ��ü ����
		try { // IO������ �ʼ��� ����

			user = new BufferedOutputStream(new FileOutputStream("d:" + Id + ".txt")); // ��������� true ��������

			System.out.println("name �Է�");
			String Name = "," + sc.next();

			System.out.println("birth �Է�");
			String Birth = "," + sc.next();

			System.out.println("email �Է�");
			String Email = "," + sc.next();

			System.out.println("addr �Է�");
			String Addr = "," + sc.next();

			System.out.println("phone �Է�");
			String Phone = "," + sc.next();
			
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("�� �α��� �ϼ���./n");
			

			byte name[] = Name.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(name);
			byte birth[] = Birth.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(birth);
			byte email[] = Email.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(email);
			byte addr[] = Addr.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(addr);
			byte phone[] = Phone.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(phone);

		} catch (Exception e) {
			System.out.println(e + " => ���");
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
			System.out.println("ȸ�������� �����Ǿ����ϴ�.\n");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void input() throws IOException { // (4) : (3)-1 ���� �Ѿ�� ȸ������ �޼ҵ�
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BufferedOutputStream userList = null;
		BufferedOutputStream user = null;
		// FileOutputStream user = null; // fileOutPut�� �� ��ü ����
		try { // IO������ �ʼ��� ����
			userList = new BufferedOutputStream(new FileOutputStream("d:userList.txt", true));// (5) �Է��� ������ ������ �ؽ�Ʈ ���Ϸ�
																								// ���� ��ü ����
			// (5)-1 ID�ߺ�üũ�� ���� user�� ��ü ID�� ����ִ� txt ������ userList ��ü�� ��´�.
			// (5)-2 userList�� ����ϴ� �۾��� ���� �������� ����, ȸ������ ���� ��� �� ���
			//

			System.out.println("id �Է�"); // (6) ȸ������ ���ý� 1.������ �Է��� ��û����
			String IdTxt = sc.next(); // (6)

			idre.idcheck(IdTxt); // (7) ID�ߺ�Ȯ���� ���� idcheck() �޼ҵ�� �̵�, �Է¹��� ��������ϴ� ID���� ��� �̵�

			// System.out.println("���Ȯ��"); �޼ҵ� ���� �� ���� Ȯ��

			user = new BufferedOutputStream(new FileOutputStream("d:" + IdTxt + ".txt", true)); // (8) user ������ ������ �ؽ�Ʈ
																								// ���� ����

			System.out.println("pw �Է�");
			String Pw = "," + sc.next(); // (9) ������ "," �� ���ؼ� �Է��� �������� �����Ѵ�.

			System.out.println("pw Ȯ�� �Է�");
			String PwRe = "," + sc.next();

			while (!Pw.equals(PwRe)) { // (10) ��й�ȣ �Է� Ȯ��
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. ���Է� �ϼ���");

				System.out.println("pw �Է�");
				Pw = "," + sc.next();

				System.out.println("pw Ȯ�� �Է�");
				PwRe = "," + sc.next();
			}

			System.out.println("name �Է�");
			String Name = "," + sc.next();

			System.out.println("birth �Է�");
			String Birth = "," + sc.next();

			System.out.println("email �Է�");
			String Email = "," + sc.next();

			System.out.println("addr �Է�");
			String Addr = "," + sc.next();

			System.out.println("phone �Է�");
			String Phone = "," + sc.next();

			byte id[] = IdTxt.getBytes(); // (11) �Է¹��� �������� byte ������ �ɰ��� ��ü b�� ����
			user.write(id); // (12) write method�� �̿��ؼ� b�� ������ �ؽ�Ʈ�� ����

			String IdTxt2 = IdTxt + ","; // (13) ����� uesrID�� userList�� ��� �ߺ�Ȯ�ο� ��� �����ϵ��� �Ѵ�. ������ ���
			byte idCheck[] = IdTxt2.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			userList.write(idCheck); // method�� �̿��ؼ� b�� ������ bw�� write

			byte pw[] = Pw.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(pw);
			byte name[] = Name.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(name);
			byte birth[] = Birth.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(birth);
			byte email[] = Email.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(email);
			byte addr[] = Addr.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(addr);
			byte phone[] = Phone.getBytes(); // byte ������ �ɰ��� ��ü b�� ����
			user.write(phone);

		} catch (Exception e) {
			System.out.println(e + " => ���");
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
// Input�� In�� �ؼ� ������ ����� ���⶧���� ������ ����
//
//System.out.println("available = " + f2.available()); //�о� �� �� �ִ� byte ��
//byte b3[] = new byte[f2.available()]; //�Ͼ�� �� �ִ� ��ŭ�� byte
//
//while(f2.read(b3) != -1) {} //file�� ���� ' -1 '�� ó���Ѵ�. -1�� file ���� ��ȯ�Ǳ� ����
//                  //read b�� �о� �´�.
//
//String data4 = new String(b3); //b�� �������� Data�� �������� 
//System.out.println(data4);

// while (!(Id = sc.nextLine()).equals("quit")) {// ���Ṯ �Է½� ����
// data ������ sc.next()�� ���ٰ� �߱� ������
// data �� Object �� �ȴ�.
// }
