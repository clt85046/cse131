package hello;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import sedgewick.StdDraw;

import javax.swing.event.ChangeEvent;

public class EmersonController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmersonController frame = new EmersonController();
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
	public EmersonController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JSlider happiness = new JSlider();
		final JSlider other = new JSlider();
		final JSlider temperature = new JSlider();
		temperature.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				react(temperature, happiness, other);
			}
		});
		happiness.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				react(temperature, happiness, other);
			}
		});
		other.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				react(temperature, happiness, other);
			}
		});

		temperature.setBounds(149, 25, 190, 29);
		contentPane.add(temperature);
		
		happiness.setBounds(149, 66, 190, 29);
		contentPane.add(happiness);
		
		other.setBounds(149, 107, 190, 29);
		contentPane.add(other);
		
		JLabel lblSad = new JLabel("cold");
		lblSad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSad.setBounds(77, 33, 61, 16);
		contentPane.add(lblSad);
		
		JLabel lblHot = new JLabel("hot");
		lblHot.setHorizontalAlignment(SwingConstants.CENTER);
		lblHot.setBounds(348, 33, 61, 16);
		contentPane.add(lblHot);
		
		JLabel lblSad_1 = new JLabel("sad");
		lblSad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSad_1.setBounds(76, 66, 61, 16);
		contentPane.add(lblSad_1);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(77, 107, 61, 16);
		contentPane.add(lblMin);
		
		JLabel lblHappy = new JLabel("happy");
		lblHappy.setHorizontalAlignment(SwingConstants.CENTER);
		lblHappy.setBounds(351, 66, 61, 16);
		contentPane.add(lblHappy);
		
		JLabel lblMax = new JLabel("max");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(351, 107, 61, 16);
		contentPane.add(lblMax);
	}
	
	private void react(JSlider temperature, JSlider happiness, JSlider other) {
		double temp = 2.0*temperature.getValue()/100.0 - 1.0;
		double mood = 2.0*happiness.getValue()/100.0 - 1.0;
		double thing = 2.0 * other.getValue()/100.0 - 1.0;
		StdDraw.clear();
		Emerson.emote(0.5, 0.5, 0.5, 0.5, temp, mood, thing);
//		Emerson.emote(0.25, 0.75, 0.25, 0.25, temp, -1*mood, thing);
//		Emerson.emote(0.75, 0.25, 0.25, 0.25, -1*temp, mood, thing);
//		Emerson.emote(0.75, 0.75, 0.25, 0.25, temp, mood, -1*thing);
		StdDraw.show();
	}
}
