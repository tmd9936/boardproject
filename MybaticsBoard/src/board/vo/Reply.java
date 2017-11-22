package board.vo;

public class Reply {
	private int boardnum;//FK
	private int replynum;//PK
	private String name;
	private String content;
	
	public Reply() {
	}

	public Reply(int boardnum,String name, String content) {
		this.boardnum = boardnum;
		this.name = name;
		this.content = content;
	}

	

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public int getReplynum() {
		return replynum;
	}

	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Reply [boardNum=" + boardnum + ", replyNum=" + replynum + ", name=" + name + ", content=" + content
				+ "]";
	}

}
