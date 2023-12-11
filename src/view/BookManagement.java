package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controller.BookManagementController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class BookManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagement frame = new BookManagement();
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
	public BookManagement() {
		
		BookManagementController bookManagementController = new BookManagementController(this);
		
		setTitle("Book management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 470, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 456, 366);
		contentPane.add(panel);
		panel.setLayout(null);
	
		
		JButton btnEnterBook = new JButton("Enter book details");
		btnEnterBook.addActionListener(bookManagementController);
		btnEnterBook.setBounds(10, 25, 434, 103);
		btnEnterBook.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(btnEnterBook);
		
		JButton btnListBook = new JButton("List book details");
		btnListBook.addActionListener(bookManagementController);
		btnListBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListBook.setBounds(10, 138, 434, 103);
		btnListBook.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(btnListBook);
		
		JButton btnExitProgram = new JButton("Exit program");
		btnExitProgram.addActionListener(bookManagementController);
		btnExitProgram.setBounds(10, 251, 434, 103);
		btnExitProgram.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(btnExitProgram);

	}

	public void OpenEnterBook() {
        dispose();

        EnterBook enterBook = new EnterBook();
        enterBook.setVisible(true);
	}

	public void OpenListBook() {
        dispose();

        ListBook listBook = new ListBook();
        listBook.setVisible(true);
	}
	
	public void ExitProgram() {
		dispose();
	}

	
}
