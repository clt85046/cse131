package lab3.viz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lab3.Model;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends JFrame {

	private JPanel contentPane;
	private Model model;
	private Board board;
	
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Controller(Model model) {
		this.model = model;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(model.getRows(), model.getCols(), 0, 0));
		board = new Board(model);
		for (int rows = 0; rows < model.getRows(); rows ++){
			for(int cols = 0; cols < model.getCols(); cols ++){
				final int row = rows;
				final int col = cols;
				contentPane.add(board.getButton(row, col));
				board.getButton(row, col).addMouseListener(
						new MouseAdapter(){
							public void mouseClicked(MouseEvent e){
								if(e.getButton() == 1){
									board.press(row, col);
								}else if (e.getButton() == 3){
									board.rightClick(row, col);
								}
							}

						});
			}
		}

	}
	
	/**
	 * Create the frame.
	 */
	public Controller() {
		this(
				new Model(25, 25, .15)
				);
	}

}
