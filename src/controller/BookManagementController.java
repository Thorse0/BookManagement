package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BookManagement;
import view.EnterBook;
import view.ListBook;

public class BookManagementController implements ActionListener{
	

	BookManagement bookManagement;
	EnterBook enterBook;
	ListBook listBook;
	public BookManagementController(BookManagement bookManagement) {
		this.bookManagement = bookManagement;
	}
	public BookManagementController(EnterBook enterBook) {
		this.enterBook = enterBook;
	}
	public BookManagementController(ListBook listBook) {
		this.listBook = listBook;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Enter book details")) {
			bookManagement.OpenEnterBook();
			
		}else if(cm.equals("List book details")) {
			bookManagement.OpenListBook();
			
		}else if(cm.equals("Exit program")) {
			bookManagement.ExitProgram();
			
		}else if(cm.equals("EnterEnterBook")) {
			enterBook.EnterBookFunc();
			
		}else if(cm.equals("SaveEnterBook")){
			enterBook.SaveBook();
			
		}else if(cm.equals("CloseEnterBook")) {
			enterBook.CloseBook();
			
		}else if(cm.equals("ShowListBook")) {

			listBook.ShowBook();
			
		}else if(cm.equals("EnterListBook")) {
			listBook.EnterBook();
			
		}else if(cm.equals("CloseListBook")) {
			listBook.CloseBook();
			
		}
		
	}

}
