package model;

import java.io.Serializable;
import java.util.TreeSet;

public class BookLibrary implements Serializable, Comparable<BookLibrary>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookId;
	private String authors;
	private String title;
	private String dateOfPublication;
	private String categories;
//	public TreeSet<BookLibrary> tsb = new TreeSet<BookLibrary>();

	public BookLibrary() {

	}
	public BookLibrary(int bookId, String authors, String title, String dateOfPublication, String categories) {
		this.bookId = bookId;
		this.authors = authors;
		this.title = title;
		this.dateOfPublication = dateOfPublication;
		this.categories = categories;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	@Override
	public int compareTo(BookLibrary o) {
		return Integer.compare(this.bookId, o.bookId);
	}
	@Override
	public String toString() {
		return "BookLibrary [bookId=" + bookId + ", authors=" + authors + ", title=" + title + ", dateOfPublication="
				+ dateOfPublication + ", categories=" + categories + "]";
	}
//	public TreeSet<BookLibrary> treeSetBook(BookLibrary book) {
//		if(tsb.size() == 0) {
//			tsb.add(book);
//		}else {
//			for (BookLibrary bookLibrary : tsb) {
//				if(bookLibrary.bookId == book.bookId) {
//					tsb.remove(bookLibrary);
//					tsb.add(book);
//					break;
//				}
//			}
//			tsb.add(book);
//		}
//		
//		return tsb;
//	}
	
}
