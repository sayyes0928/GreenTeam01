package team1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	// ������ ��ȯ�� ���� �� Ŭ���� ��ü ����
	OutputData outdata = new OutputData();
	InputData indata = new InputData();
	Model model = new Model();
	View view = new View();
	// ArrayList<Model> arr = new ArrayList<Model>();

	void Start() throws IOException {// ���α׷� ���۽� ���� ���� ����

		// boolean result = true;
		view.start(); // (1) ���۸޴� ���

		Scanner sc = new Scanner(System.in); // (2) ���� �� �޴��� �Է¹޴´�
		int num = sc.nextInt(); // (2)

		while (num != 3) {// (3) while ���� ���� �޴��� �׻� �ʱ� ȭ���� ��� �� �� �ֵ��� �����.

			if (num == 1) { // 1�� �Է½� ȸ������ �Է¸޼ҵ� (input())�޼ҵ� ����

				outdata.input(); // (3)-1 ȸ������ �޼ҵ� ����
				view.start();
				num = sc.nextInt();

			} else if (num == 2) { // 2�� �Է½� �α���

				indata.print(); // (3)-2 �α��� �޼ҵ� ����
				view.start();
				num = sc.nextInt();
			}
		}
	}
}

//	}
//}

// view.Log();//�α��� �� ȭ������ �̵�. ����,���� ȭ��
//				while (num != 3) {
//					if (num == 1) {// ����
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
