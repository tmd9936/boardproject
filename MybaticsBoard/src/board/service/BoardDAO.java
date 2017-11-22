package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import board.vo.Reply;

public class BoardDAO implements BoardMapper{
	
//	public static void main(String[] args) {
//		BoardDAO dao = new BoardDAO();
//		//Board b = new Board("nameOne","titleOne","contentOne");
//		//dao.insertBoard(b);
//		
//		//Board b = dao.selectBoard(1);
//		//System.out.println(b.toString());
//		
//		//dao.addHits(1);
//		
//		//dao.deleteBoard(6);
//		
//		//List<Board> bl = dao.getBoardList();	
//		//System.out.println(bl.toString());
//		
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("col", 3);
//		map.put("word", "One");
//		
//		List<Board> bl = dao.searchBoard(map);
//		
//		System.out.println(bl.toString());
//
//		System.out.println("end!!");
//	}

	private SqlSessionFactory factory = MyBatisconfig.getSqlSessionFactory();
	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		int result = 0;
		try {
			result = bm.insertBoard(b);
			session.commit();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return result;
	}

	@Override
	public Board selectBoard(int boardnum) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		Board b = null;
		try {
			b = bm.selectBoard(boardnum);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return b;
	}

	@Override
	public int addHits(int boardnum) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		int result = 0;
		
		try {
			result = bm.addHits(boardnum);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		return result;
	}

	@Override
	public int deleteBoard(int boardnum) {
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		int result = 0;
		
		try {
			result = bm.deleteBoard(boardnum);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		List<Board> b = null;
		
		try {
			b = bm.getBoardList();
		} finally {
			session.close();
		}
		
		return b;
	}

	@Override
	public List<Board> searchBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		List<Board> b = null;
		
		try {
			b = bm.searchBoard(map);
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return b;
	}

	@Override
	public int insertReply(Reply r) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		int result = 0;
		
		try {
			result = bm.insertReply(r);
			session.commit();
		} finally {
			session.close();
			// TODO: handle finally clause
		}
		
		return result;
	}

	@Override
	public List<Reply> getReplyList(int boardnum) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardMapper bm = session.getMapper(BoardMapper.class);
		
		List<Reply> rlist = null;
		
		try {
			rlist = bm.getReplyList(boardnum);

		} finally {
			session.commit();
			// TODO: handle finally clause
		}
		
		return rlist;
	}

}
