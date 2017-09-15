package conway;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ConwayController extends JFrame {

	final private JPanel contentPane;
	final private Conway conway;
	private Timer timer;
	private int slow = 600;
	private int medium = 300;
	private int fast = 75;
	final private ConwayGridPanel conwayPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConwayController frame = new ConwayController();
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
	public ConwayController() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conway = new Conway(50,50);
		conwayPanel = new ConwayGridPanel(conway, 20);
		displayLiveness();

		conwayPanel.setBounds(10, 10, 700, 700);
		contentPane.add(conwayPanel);

		// create an instance of Conway and set up the timer
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				conway.step(); // run a single step each delay/1000.0 seconds
				displayLiveness();
			}
		};
		timer = new Timer(medium, taskPerformer); // FIXME redundant

		JPanel pnlButtons = new JPanel();
		pnlButtons.setBounds(726, 59, 163, 341);
		contentPane.add(pnlButtons);
		pnlButtons.setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				System.out
						.println("Simulation running at "
								+ (timer.getDelay() / 1000.0)
								+ " seconds for each step.");
			}
		});
		btnStart.setBounds(37, 16, 89, 23);
		pnlButtons.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				System.out.println("Simulation has been stopped.");
			}
		});
		btnStop.setBounds(37, 55, 89, 23);
		pnlButtons.add(btnStop);

		JButton btnStep = new JButton("Step");
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conway.step();
				displayLiveness();
			}
		});
		btnStep.setBounds(37, 94, 89, 23);
		pnlButtons.add(btnStep);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conway.clear();
				displayLiveness();
			}
		});
		btnClear.setBounds(37, 133, 89, 23);
		pnlButtons.add(btnClear);

		String[] s = { "<html><i>(none)</i></html>", "Blinker",
				"Four Blinkers", "Glider", "Gosper Glider Gun",
				"Your Design One", "Your Design Two" };
		JComboBox cmbPatterns = new JComboBox(s);
		cmbPatterns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) ((JComboBox) e.getSource())
						.getSelectedItem();
				if (selected == "Blinker")
					conway.blinker();
				else if (selected == "Four Blinkers")
					conway.fourBlinkers();
				else if (selected == "Glider")
					conway.glider();
				else if (selected == "Gosper Glider Gun")
					conway.gosperGliderGun();
				else if (selected == "Your Design One")
					conway.yourDesignOne();
				else if (selected == "Your Design Two")
					conway.yourDesignTwo();
				displayLiveness();
			}
		});
		cmbPatterns.setBounds(16, 211, 130, 20);
		pnlButtons.add(cmbPatterns);

		JButton btnLogAndCapture = new JButton("Log and Capture");
		btnLogAndCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conway.logAndCapture();
				displayLiveness();
			}
		});
		btnLogAndCapture.setBounds(16, 172, 130, 23);
		pnlButtons.add(btnLogAndCapture);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				JSlider s = (JSlider) arg0.getSource();
				switch (s.getValue()) {
				case 1:
					timer.setDelay(slow);
					break;
				case 2:
					timer.setDelay(medium);
					break;
				case 3:
					timer.setDelay(fast);
					break;
				default:
					break;
				}
			}
		});
		slider.setSnapToTicks(true);
		slider.setMinimum(1);
		slider.setMaximum(3);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(0);
		slider.setValue(2);
		slider.setPaintLabels(true);
		slider.setBounds(16, 286, 130, 39);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(1), new JLabel("Slow"));
		labelTable.put(new Integer(2), new JLabel("Medium"));
		labelTable.put(new Integer(3), new JLabel("Fast"));
		slider.setLabelTable(labelTable);
		pnlButtons.add(slider);

		JLabel lblSimulationSpeed = new JLabel("Simulation Speed:");
		lblSimulationSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimulationSpeed.setBounds(16, 247, 130, 23);
		pnlButtons.add(lblSimulationSpeed);
	}
		
	public void displayLiveness() {
		conwayPanel.displayLiveness();
	}
}
