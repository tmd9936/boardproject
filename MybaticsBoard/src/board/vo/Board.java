package board.vo;

import java.util.List;

public class Board {
	private int boardNum;//PK
	private String name;
	private String title;
	private String content;
	private int hits;
	private String indate;
	private List<Reply> rlist;
	
	
	
	public Board() {
	}
	
	public Board(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;
		hits = 0;
	}

	
	
	public List<Reply> getRlist() {
		return rlist;
	}

	public void setRlist(List<Reply> rlist) {
		this.rlist = rlist;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", indate=" + indate + "]";
	}
	
	
	
	
	
}
