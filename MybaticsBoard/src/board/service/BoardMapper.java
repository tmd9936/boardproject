package board.service;

import java.util.List;
import java.util.Map;

import board.vo.Board;
import board.vo.Reply;

public interface BoardMapper {
	// 게시글 등록
	public int insertBoard(Board b);

	// 게시글 읽기
	public Board selectBoard(int boardnum);

	// 조회수 증가
	public int addHits(int boardnum);

	// 게시글 삭제
	public int deleteBoard(int boardnum);

	// 게시글 전체 목록
	public List<Board> getBoardList();

	// 게시글 검색*
	public List<Board> searchBoard(Map<String, Object> map);

	// 댓글 등록
	public int insertReply(Reply r);

	// 댓글 가져오기
	public List<Reply> getReplyList(int boardnum);
}
