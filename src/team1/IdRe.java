package team1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class IdRe extends Model { // ID �ߺ�Ȯ�� �� �α��ν� ID�� �����ϴ��� Ȯ���ѱ� ���� Ŭ����

	Scanner sc = new Scanner(System.in);
//	static String list[];

	void idcheck(String Id) throws IOException { // (8) : (7)���� �Ѿ�� ID�ߺ� Ȯ���� ���� �޼ҵ� ����

		String ID = Id;// (9) �Է¹��� �Ű����� ID�� idcheck �޼ҵ忡�� ��� �����ϰ� ������ ����
		Boolean result = true;
		String idCheck = null;
		ArrayList<String> arrUser = new ArrayList<String>();

		// System.out.println("���Ȯ��"); ȣ�� Ȯ�ο�
		while (result == true) {
			try { // Input�� �ϱ����� try.catch ���
//				System.out.println("ID ����� �� Ȯ��" + ID);
				BufferedReader userList = new BufferedReader(
						new InputStreamReader(new FileInputStream("d:userList.txt")));
				// System.out.println("���Ȯ��0"); // ȣ�� Ȯ�ο�

				// (10)userList ȣ�� userList ��ü�� userList�� ��� �����ִ�.

//				while ((idCheck = userList.readLine()) != null) {
//					System.out.println("��� üũ");
//					arrUser.add(non);
//				}
//				userList.close();

				idCheck = userList.readLine();

//				System.out.println(ID + "���̵� �帧 Ȯ��");
//				System.out.println("idchek"); // ���� Ȯ��

				String[] list = idCheck.split(",");

				for (String s : list) {
					// System.out.println(s.trim());
				}

//				System.out.println(result + "1"); �� ��ȯ Ȯ��

				for (String s : list) {
					// System.out.println(s);// ���� Ȯ��
					// System.out.println(list[2] + "������� Ȯ��");

					if (ID.equals(s.trim())) {
//						System.out.println(s.trim() + "ID d�� ���ϴ� Ʈ����");
						result = false;
						break;
					} else {
//						System.out.println("���Ȯ��8");
					}
				}

//				System.out.println(result + "4");

				if (result == false) {
					System.out.println("�ߺ��Ǵ� ID�� �����մϴ�.");
					System.out.println("ID�� ���Է� ���ּ���");
					result = true;
				} else {
					break;
				}
				ID = sc.next();

				// System.out.println("ID Ȯ�� " + ID);
//				System.out.println("���Ȯ��5");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
			}
		}
	}

	Boolean idcheck2(String Id) throws IOException { // (8) : (7)���� �Ѿ�� ID�ߺ� Ȯ���� ���� �޼ҵ� ����

		String ID = Id;// (9) �Է¹��� �Ű����� ID�� idcheck �޼ҵ忡�� ��� �����ϰ� ������ ����
		Boolean result = true;
		String idCheck = null;

		// System.out.println("���Ȯ��"); ȣ�� Ȯ�ο�
		while (result == true) {
			try { // Input�� �ϱ����� try.catch ���
					// System.out.println("ID ����� �� Ȯ��" + ID);
				BufferedReader userList = new BufferedReader(
						new InputStreamReader(new FileInputStream("d:userList.txt")));
				// System.out.println("���Ȯ��0"); // ȣ�� Ȯ�ο�

				// (10)userList ȣ�� userList ��ü�� userList�� ��� �����ִ�.

//				while ((idCheck = userList.readLine()) != null) {
//					System.out.println("��� üũ");
//					arrUser.add(non);
//				}
//				userList.close();
				idCheck = userList.readLine();

				String[] list = idCheck.split(",");
				for (String s : list) {
					// System.out.println(s.trim());
				}

				for (String s : list) {
					// System.out.println(s);// ���� Ȯ��
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