package day5;

/*
	�ڹٺ���Ŭ����
	1. ��Ű���� ����
	2. Ŭ������ ���������ڴ� public
	3. ����Ʈ������ ����
	4. ��� ��������� ���������ڴ� private
	5. getter/setter �޼ҵ� ����
*/

public class BookVO {

	private String isbn;
	private String title;
	private String writer;

	public BookVO() {
	}

	public BookVO(String isbn, String title, String writer) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
