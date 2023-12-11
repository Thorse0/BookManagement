package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.BookManagementController;
import model.BookLibrary;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class ListBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAuthors;
	private JTextField textFieldTitle;
	private JTextField textFieldDateOfPublication;
	private JTextField textFieldCategories;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private TreeSet<BookLibrary> bookTreeSet = new TreeSet<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListBook frame = new ListBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListBook() {
		BookManagementController bookManagementController = new BookManagementController(this);
		setTitle("List book details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 649, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setFont(new Font("Tahoma", Font.PLAIN, 20));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBounds(10, 10, 195, 359);
        contentPane.add(list);
//        JScrollPane scrollPane = new JScrollPane(list);
//        this.getContentPane().add(scrollPane);
        
        
		try {
			File file  = new File("F:\\HV kĩ thuật mật mã\\java\\Books.dat");
			FileInputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			BookLibrary bookLibrary = null;
			while((bookLibrary = (BookLibrary) ois.readObject()) != null) {
				listModel.addElement(String.valueOf(bookLibrary.getBookId()));
				bookTreeSet.add(bookLibrary);
			}
			ois.close();
		} catch (Exception e) {
			e.getStackTrace();
		}

		
		
		JButton btnShowList = new JButton("Show");
		btnShowList.addActionListener(bookManagementController);
		
		btnShowList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnShowList.setActionCommand("ShowListBook");
		btnShowList.setBounds(75, 393, 109, 41);
		contentPane.add(btnShowList);
		
		JButton btnEnterList = new JButton("Enter");
		btnEnterList.setActionCommand("EnterListBook");
		btnEnterList.addActionListener(bookManagementController);
		btnEnterList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnterList.setBounds(238, 393, 109, 41);
		contentPane.add(btnEnterList);
		
		JButton btnCloseList = new JButton("Close");
		btnCloseList.setActionCommand("CloseListBook");
		btnCloseList.addActionListener(bookManagementController);
		btnCloseList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCloseList.setBounds(401, 393, 109, 41);
		contentPane.add(btnCloseList);
		
		JLabel lbAuthorsList = new JLabel("Authors");
		lbAuthorsList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbAuthorsList.setBounds(215, 10, 85, 31);
		contentPane.add(lbAuthorsList);
		
		textFieldAuthors = new JTextField();
		textFieldAuthors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAuthors.setColumns(10);
		textFieldAuthors.setBounds(215, 52, 401, 41);
		contentPane.add(textFieldAuthors);
		
		JLabel lbTitleList = new JLabel("Title");
		lbTitleList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbTitleList.setBounds(215, 103, 85, 31);
		contentPane.add(lbTitleList);
		
		JLabel lbDateOfPublicationList = new JLabel("Date of publication");
		lbDateOfPublicationList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbDateOfPublicationList.setBounds(215, 201, 220, 31);
		contentPane.add(lbDateOfPublicationList);
		
		JLabel lbCategoriesList = new JLabel("Categories");
		lbCategoriesList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbCategoriesList.setBounds(210, 296, 157, 31);
		contentPane.add(lbCategoriesList);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(215, 144, 401, 41);
		contentPane.add(textFieldTitle);
		
		textFieldDateOfPublication = new JTextField();
		textFieldDateOfPublication.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDateOfPublication.setColumns(10);
		textFieldDateOfPublication.setBounds(215, 242, 401, 41);
		contentPane.add(textFieldDateOfPublication);
		
		textFieldCategories = new JTextField();
		textFieldCategories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCategories.setColumns(10);
		textFieldCategories.setBounds(215, 328, 401, 41);
		contentPane.add(textFieldCategories);
		

	}

	public void ShowBook() {
		
		int selectedIndex = list.getSelectedIndex();
		if (selectedIndex != -1) {
			int bookId = Integer.valueOf(listModel.getElementAt(selectedIndex));
			for (BookLibrary book : bookTreeSet) {
				if(book.getBookId() == bookId) {
					textFieldAuthors.setText(book.getAuthors());
					textFieldTitle.setText(book.getTitle());
					textFieldDateOfPublication.setText(book.getDateOfPublication());
					textFieldCategories.setText(book.getCategories());
				}
				
			}
		}
	}
	
	public void EnterBook() {
		textFieldAuthors.setText("");
		textFieldTitle.setText("");
		textFieldDateOfPublication.setText("");
		textFieldCategories.setText("");
		
	}

	public void CloseBook() {
        dispose();

        BookManagement bookManagement = new BookManagement();
        bookManagement.setVisible(true);
		
	}
	

}
