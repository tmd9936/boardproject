package board.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import board.service.BoardDAO;
import board.vo.Board;
import board.vo.Reply;

public class BoardUI {
	private BoardDAO dao;
	private Scanner scan;

	public BoardUI() {
		dao = new BoardDAO();
		scan = new Scanner(System.in);
	}

	public void startUI() {
		while (true) {
			System.out.println("== �Խ��� ���� ���α׷� ==");
			System.out.println("1. �Խñ� ���");
			System.out.println("2. �Խñ� �б�");
			System.out.println("3. �Խñ� ����");
			System.out.println("4. �Խñ� ���");
			System.out.println("5. �Խñ� ã��");
			System.out.println("9. ������");
			System.out.print("===> ");

			int menuNum = 0;
			try {
				menuNum = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("���� �ƴ�");
				scan.nextLine();
			}

			switch (menuNum) {
			case 1:// �Խñ� �Է�
				this.insertBoard();
				break;
			case 2:// �Խñ� �б�
				this.readBoard();
				break;
			case 3:// �Խñ� ����
				this.deleteBoard();
				break;
			case 4:// ��ü �Խñ�
				this.getBoardList();
				break;
			case 5:// �Խñ� �˻�
				this.searchBoard();
				break;
			case 9:// ���α׷� ����
				scan.close();
				return;
			default:
				System.out.println("?");
				break;
			}// switch end
		} // while end
	}// method end

	// �Խñ� �Է�
	public void insertBoard() {
		System.out.println("== 1. �Խñ� �Է� ==");
		System.out.print("name: ");
		String name = scan.nextLine();
		System.out.print("title : ");
		String title = scan.nextLine();
		System.out.println("���� : ");
		String content = scan.nextLine();

		Board b = new Board(name, title, content);

		if (dao.insertBoard(b) != 0) {
			System.out.println("����");
		} else
			System.out.println("����");

	}
	// �Խñ� �б�
	public void readBoard() {
		while(true) {
			System.out.println("== 2. �Խñ� �б� ==");
			System.out.println("1. �б�");
			System.out.println("2. ���� �޴�");
			System.out.print("==>");
			
			String menu = scan.next();
			
			switch (menu) {
			case "1":
				System.out.print("��ȣ �Է� => ");
				int boardnum = scan.nextInt();
				scan.nextLine();
				Board b = dao.selectBoard(boardnum);
				if(b !=null) {
					dao.addHits(boardnum);
				
					System.out.print("�̸� : " + b.getName());
					System.out.print("���� : "+ b.getTitle());
					System.out.println("��ȸ�� : "+ b.getHits());
					System.out.println("=����=");
					System.out.println(b.getContent());
					this.replayShow(b);
				}
			case "2":
				return;
			default:
				break;
			}
		}
	}
	
	

	// �Խñ� ����
	public void deleteBoard() {
		System.out.println("3. == �Խñ� ���� ==");
		System.out.println("1. ����");
		System.out.println("2. �����޴�");
		String menu = scan.nextLine();
		switch (menu) {
		case "1":
			System.out.println("boardbyn[del] ==> ");
			int boardnum = scan.nextInt();
			scan.nextLine();
			if (dao.deleteBoard(boardnum) != 0)
				System.out.println("����");
			else
				System.out.println("����");
			break;
		case "2":
			return;
		default:
			System.out.println("����");
			break;
		}
	}

	// ��ü �Խñ�
	public void getBoardList() {
		List<Board> bList = dao.getBoardList();

		if (bList != null) {
			for (Board board : bList) {
				System.out.println(board);
			}
		}
	}

	// �Խñ� �˻�
	public void searchBoard() {
		while (true) {
			System.out.println("== 5. �˻� �޴� ==");
			System.out.println("���� �˻�? :");
			System.out.println("1. �̸�, 2. ����, 3.���� 9.����");
			System.out.print("==> ");
			int col = scan.nextInt();
			scan.nextLine();

			if(col ==9)
			{
				return;
			}
			System.out.println("Ű����");
			String word = scan.nextLine();

			Map<String, Object> map = new HashMap<>();
			map.put("col", col);
			map.put("word", word);

			List<Board> bList = dao.searchBoard(map);

			if (bList != null) {
				for (Board b : bList) {
					System.out.println(b);
				}
			}
		}

	}
	public void replayShow(Board b) {
		List<Reply> rList = dao.getReplyList(b.getBoardNum());
		if(rList != null) {
			for (Reply reply : rList) {
				System.out.println(reply);
			}
		}
		inserReply(b);
	}
	
	public void inserReply(Board b)
	{
		while(true)
		{
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� �޴�");
			int mNum = scan.nextInt();
			scan.nextLine();
			switch (mNum) {
			case 1:
				System.out.print("name : ");
				String name = scan.nextLine();
				System.out.print("���� : ");
				String content = scan.nextLine();
				Reply r = new Reply(b.getBoardNum(), name, content);
				if(dao.insertReply(r) != 0)
					System.out.println("����");
				else
					System.out.println("����");
				break;
			case 2:
				return;
			default:
				break;
			}
		}
	}
}
