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
			System.out.println("== 게시판 관리 프로그램 ==");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 읽기");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록");
			System.out.println("5. 게시글 찾기");
			System.out.println("9. 나가기");
			System.out.print("===> ");

			int menuNum = 0;
			try {
				menuNum = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("숫자 아님");
				scan.nextLine();
			}

			switch (menuNum) {
			case 1:// 게시글 입력
				this.insertBoard();
				break;
			case 2:// 게시글 읽기
				this.readBoard();
				break;
			case 3:// 게시글 삭제
				this.deleteBoard();
				break;
			case 4:// 전체 게시글
				this.getBoardList();
				break;
			case 5:// 게시글 검색
				this.searchBoard();
				break;
			case 9:// 프로그램 종료
				scan.close();
				return;
			default:
				System.out.println("?");
				break;
			}// switch end
		} // while end
	}// method end

	// 게시글 입력
	public void insertBoard() {
		System.out.println("== 1. 게시글 입력 ==");
		System.out.print("name: ");
		String name = scan.nextLine();
		System.out.print("title : ");
		String title = scan.nextLine();
		System.out.println("내용 : ");
		String content = scan.nextLine();

		Board b = new Board(name, title, content);

		if (dao.insertBoard(b) != 0) {
			System.out.println("성공");
		} else
			System.out.println("실패");

	}
	// 게시글 읽기
	public void readBoard() {
		while(true) {
			System.out.println("== 2. 게시글 읽기 ==");
			System.out.println("1. 읽기");
			System.out.println("2. 상위 메뉴");
			System.out.print("==>");
			
			String menu = scan.next();
			
			switch (menu) {
			case "1":
				System.out.print("번호 입력 => ");
				int boardnum = scan.nextInt();
				scan.nextLine();
				Board b = dao.selectBoard(boardnum);
				if(b !=null) {
					dao.addHits(boardnum);
				
					System.out.print("이름 : " + b.getName());
					System.out.print("제목 : "+ b.getTitle());
					System.out.println("조회수 : "+ b.getHits());
					System.out.println("=내용=");
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
	
	

	// 게시글 삭제
	public void deleteBoard() {
		System.out.println("3. == 게시글 삭제 ==");
		System.out.println("1. 삭제");
		System.out.println("2. 상위메뉴");
		String menu = scan.nextLine();
		switch (menu) {
		case "1":
			System.out.println("boardbyn[del] ==> ");
			int boardnum = scan.nextInt();
			scan.nextLine();
			if (dao.deleteBoard(boardnum) != 0)
				System.out.println("성공");
			else
				System.out.println("실패");
			break;
		case "2":
			return;
		default:
			System.out.println("없음");
			break;
		}
	}

	// 전체 게시글
	public void getBoardList() {
		List<Board> bList = dao.getBoardList();

		if (bList != null) {
			for (Board board : bList) {
				System.out.println(board);
			}
		}
	}

	// 게시글 검색
	public void searchBoard() {
		while (true) {
			System.out.println("== 5. 검색 메뉴 ==");
			System.out.println("뭐로 검색? :");
			System.out.println("1. 이름, 2. 제목, 3.내용 9.종료");
			System.out.print("==> ");
			int col = scan.nextInt();
			scan.nextLine();

			if(col ==9)
			{
				return;
			}
			System.out.println("키워드");
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
			System.out.println("1. 리플 입력");
			System.out.println("2. 상위 메뉴");
			int mNum = scan.nextInt();
			scan.nextLine();
			switch (mNum) {
			case 1:
				System.out.print("name : ");
				String name = scan.nextLine();
				System.out.print("내용 : ");
				String content = scan.nextLine();
				Reply r = new Reply(b.getBoardNum(), name, content);
				if(dao.insertReply(r) != 0)
					System.out.println("성공");
				else
					System.out.println("실패");
				break;
			case 2:
				return;
			default:
				break;
			}
		}
	}
}
