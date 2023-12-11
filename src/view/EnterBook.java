package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BookManagementController;
import model.BookLibrary;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.TreeSet;

import javax.swing.JButton;

public class EnterBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBookId;
	private JTextField textFieldAuthors;
	private JTextField textFieldTitle;
	private JTextField textFieldDateOfPublication;
	private JTextField textFieldCategories;
	private TreeSet<BookLibrary> bookTreeSet = new TreeSet<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterBook frame = new EnterBook();
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
	public EnterBook() {
		BookManagementController bookManagementController = new BookManagementController(this);
		setTitle("Enter book details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 759, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBookId = new JLabel("Book Id");
		lbBookId.setBounds(54, 29, 85, 31);
		lbBookId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lbBookId);
		
		textFieldBookId = new JTextField();
		textFieldBookId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldBookId.setBounds(369, 19, 331, 41);
		contentPane.add(textFieldBookId);
		textFieldBookId.setColumns(10);
		
		JLabel lbTitle = new JLabel("Title");
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbTitle.setBounds(54, 186, 85, 31);
		contentPane.add(lbTitle);
		
		JLabel lbDateOfPublication = new JLabel("Date of publication");
		lbDateOfPublication.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbDateOfPublication.setBounds(54, 270, 223, 31);
		contentPane.add(lbDateOfPublication);
		
		JLabel lbCategories = new JLabel("Categories");
		lbCategories.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbCategories.setBounds(54, 355, 166, 31);
		contentPane.add(lbCategories);
		
		JLabel lbAuthors = new JLabel("Authors");
		lbAuthors.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbAuthors.setBounds(54, 106, 85, 31);
		contentPane.add(lbAuthors);
		
		textFieldAuthors = new JTextField();
		textFieldAuthors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAuthors.setColumns(10);
		textFieldAuthors.setBounds(369, 96, 331, 41);
		contentPane.add(textFieldAuthors);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(369, 176, 331, 41);
		contentPane.add(textFieldTitle);
		
		textFieldDateOfPublication = new JTextField();
		textFieldDateOfPublication.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDateOfPublication.setColumns(10);
		textFieldDateOfPublication.setBounds(369, 260, 331, 41);
		contentPane.add(textFieldDateOfPublication);
		
		textFieldCategories = new JTextField();
		textFieldCategories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCategories.setColumns(10);
		textFieldCategories.setBounds(369, 345, 331, 41);
		contentPane.add(textFieldCategories);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("EnterEnterBook");
		btnEnter.addActionListener(bookManagementController);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnter.setBounds(356, 422, 109, 41);
		contentPane.add(btnEnter);
		
		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("SaveEnterBook");
		btnSave.addActionListener(bookManagementController);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSave.setBounds(183, 422, 109, 41);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.setActionCommand("CloseEnterBook");
		btnClose.addActionListener(bookManagementController);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClose.setBounds(524, 422, 109, 41);
		contentPane.add(btnClose);
		
		
		
	}

	public void EnterBookFunc() {
		textFieldBookId.setText("");
		textFieldAuthors.setText("");
		textFieldTitle.setText("");
		textFieldDateOfPublication.setText("");
		textFieldCategories.setText("");
		
	}

	public void SaveBook() {
		try {
			// lấy ra dữ liệu trong file
			try {
				File file  = new File("F:\\HV kĩ thuật mật mã\\java\\Books.dat");
				FileInputStream is = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(is);
				BookLibrary bookLibrary = null;
				while((bookLibrary = (BookLibrary) ois.readObject()) != null) {
					bookTreeSet.add(bookLibrary);
				}
				ois.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
			
			//ghi đè hoặc thêm mới vào file
			File file  = new File("F:\\HV kĩ thuật mật mã\\java\\Books.dat");
			FileOutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			int bookId = Integer.valueOf(textFieldBookId.getText());
			String authors = textFieldAuthors.getText();
			String title =textFieldTitle.getText();
			String dateOfPublication =textFieldDateOfPublication.getText();
			String categories =textFieldCategories.getText();
			
			BookLibrary bookLibrary = new BookLibrary(bookId, authors, title, dateOfPublication, categories);
			if(bookTreeSet.size() == 0) {
				bookTreeSet.add(bookLibrary);
			}else {
				for (BookLibrary book : bookTreeSet) {
					if(bookLibrary.getBookId() == book.getBookId()) {
						bookTreeSet.remove(book);
						bookTreeSet.add(bookLibrary);
						break;
					}
				}
				bookTreeSet.add(bookLibrary);
			}
			for (BookLibrary book : bookTreeSet) {
				oos.writeObject(book);		
			}
			
			oos.flush();
			oos.close();
			JOptionPane.showMessageDialog(this, "Lưu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

	public void CloseBook() {
        dispose();

        BookManagement bookManagement = new BookManagement();
        bookManagement.setVisible(true);
		
	}

	
}
