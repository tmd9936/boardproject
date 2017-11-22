package board.service;

import java.util.List;
import java.util.Map;

import board.vo.Board;
import board.vo.Reply;

public interface BoardMapper {
	// �Խñ� ���
	public int insertBoard(Board b);

	// �Խñ� �б�
	public Board selectBoard(int boardnum);

	// ��ȸ�� ����
	public int addHits(int boardnum);

	// �Խñ� ����
	public int deleteBoard(int boardnum);

	// �Խñ� ��ü ���
	public List<Board> getBoardList();

	// �Խñ� �˻�*
	public List<Board> searchBoard(Map<String, Object> map);

	// ��� ���
	public int insertReply(Reply r);

	// ��� ��������
	public List<Reply> getReplyList(int boardnum);
}
