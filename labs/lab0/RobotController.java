package lab0;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import robot.RobotModel;
import robot.RobotView;

public class RobotController extends JFrame {

	private JPanel contentPane;
	private String points = "";
	private JTextArea savedPoints;
	private JSlider slider;
	private int speed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotController frame = new RobotController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 */
	public RobotController() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final ImagePanel panel = new ImagePanel(new ImageIcon("images/Map.jpg").getImage());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1034, 13, 138, 269);
		contentPane.add(scrollPane);
		savedPoints = new JTextArea();
		savedPoints.setEditable(false);
		scrollPane.setViewportView(savedPoints);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				points += "(" + arg0.getX() + ", " + arg0.getY() + ")" + "\n";
				savedPoints.setText(points);
			}
		});
		getContentPane().add(panel);

		JButton btnGo = new JButton("Go!");
		btnGo.setBounds(1075, 660, 97, 25);
		contentPane.add(btnGo);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) { 
					speed = slider.getValue()/4 + 1;
			}
		});
		speed = slider.getValue()/4 + 1;
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(1075, 391, 48, 256);
		contentPane.add(slider);

		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(1079, 370, 56, 16);
		contentPane.add(lblSpeed);

		JLabel lblFast = new JLabel("Fast");
		lblFast.setBounds(1128, 399, 48, 16);
		contentPane.add(lblFast);

		JLabel lblSlow = new JLabel("Slow");
		lblSlow.setBounds(1128, 607, 56, 16);
		contentPane.add(lblSlow);

		JLabel lblCoordinates = new JLabel("Coordinates: ");
		lblCoordinates.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoordinates.setBounds(1044, 295, 128, 35);
		contentPane.add(lblCoordinates);

		final JLabel labelCurrentPosition = new JLabel("");
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				labelCurrentPosition.setText("(" + arg0.getX() + ", " + arg0.getY() + ")");
			}
		});
		labelCurrentPosition.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCurrentPosition.setBounds(1044, 322, 128, 35);
		contentPane.add(labelCurrentPosition);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guideRobot(panel);
			}
		});



	}

	public void guideRobot(JPanel panel) {
		RobotInstructions instructions = new RobotInstructions();
		RobotModel model = new RobotModel();
		RobotView view = new RobotView(model.pcs);
		model.setSpeed(speed);
		panel.add(view.getRobot());
		model.setLocation(529, 250);
		RobotMotionAdapter motion = new RobotMotionAdapter(model);
		RobotThread t = new RobotThread(motion, instructions);
		t.start();

		
	}

	public String toString() {
		return "RobotController";
	}
	
}
