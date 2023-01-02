package AllMapping.Booksdemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booksinfo {

	@Id
	private int bokid;
	private String name;
	private String author;

	public int getBokid() {
		return bokid;
	}

	public void setBokid(int bokid) {
		this.bokid = bokid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Booksinfo(int bokid, String name, String author) {
		super();
		this.bokid = bokid;
		this.name = name;
		this.author = author;
	}

	public Booksinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
