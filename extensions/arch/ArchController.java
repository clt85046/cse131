package arch;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArchController extends JFrame {

	private JPanel contentPane;
	private Arch arch;
	private int numMasses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArchController frame = new ArchController();
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
	public ArchController() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numMasses = 23;
		arch = new Arch(numMasses);
		
		JButton btnRound = new JButton("1 Round");
		btnRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run(1);
			}
		});
		btnRound.setBounds(27, 11, 89, 23);
		contentPane.add(btnRound);
		
		JButton btnRounds = new JButton("10 Rounds");
		btnRounds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run(1);
			}
		});
		btnRounds.setBounds(27, 46, 89, 23);
		contentPane.add(btnRounds);
		
		JButton btnRounds_1 = new JButton("100 Rounds");
		btnRounds_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run(100);
			}
		});
		btnRounds_1.setBounds(27, 81, 89, 23);
		contentPane.add(btnRounds_1);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arch.run();
			}
		});
		btnRun.setBounds(27, 116, 89, 23);
		contentPane.add(btnRun);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arch.stop();
			}
		});
		btnStop.setBounds(27, 151, 89, 23);
		contentPane.add(btnStop);
	}
	
	private void run(int numRounds) {
		System.out.print("Running.....");
		for (int i=0; i < numRounds; ++i) {
			arch.round();
		}
		System.out.println("....done");
	}

}
