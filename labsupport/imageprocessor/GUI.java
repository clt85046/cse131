package imageprocessor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileFilter;

import sedgewick.Picture;

/** SEE FIXMEs for problem areas **/
public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int numTopPics;
	int numMidPics;
	int heightTopPics;
	int widthTopPics;
	JMenu options;
	private WorkingPanel source1, source2, target;
	private JComboBox methods;
	private JButton go;
	private JButton rightButton;
	private JButton leftButton;
	private JButton addpic;
	private JButton trash;
	private JFileChooser fileChooser;
	private TopPanel topBar;
	private int guiWidth, guiHeight;
	private JTextField txtSource1;
	private JTextField txtSource2;
	private JTextField txtTarget;
	protected JComponent componentSelected;
	public static final DataFlavor sedgewickPicture = new DataFlavor(
			Picture.class, "Sedgewick Picture");
	public static final DataFlavor pictureLabel = new DataFlavor(JLabel.class,
			"JLabel");
	public static final DataFlavor workingPanel = new DataFlavor(
			WorkingPanel.class, "Working Panel");
	public static final DataFlavor topPanel = new DataFlavor(
			TopPanel.class, "Top Panel");
	public static final DataFlavor ID = new DataFlavor(Integer.class,
			"Integer");

	public static MenuTransform genMenuTransform(final String s,
			final ComponentFilter cf) {
		return new MenuTransform() {

			@Override
			public void transform(Picture source1, Picture source2,
					Picture target) {
				processPixels(source1, source2, target, cf);

			}

			@Override
			public String getMenuName() {
				return s;
			}

		};
	}

	public static MenuTransform genMenuTransform(final String s,
			final ColorFilter ccf) {
		return new MenuTransform() {

			@Override
			public void transform(Picture source1, Picture source2,
					Picture target) {
				processPixels(source1, source2, target, ccf);

			}

			@Override
			public String getMenuName() {
				return s;
			}

		};
	}

	public static MenuTransformable genMenuTransform(final String s,
			final PictureFilter pf) {
		return new MenuTransform() {

			@Override
			public void transform(Picture source1, Picture source2,
					Picture target) {
				processPixels(source1, source2, target, pf);

			}

			@Override
			public String getMenuName() {
				return s;
			}

		};

	}

	private JButton save;
	private WorkingPanel[] panels;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(new MenuTransformable[] {});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI(MenuTransformable[] filters) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			throw new Error("No Nimbus");
		}
		// Establishes correct position of GUI based on user's screen size
		Toolkit toolkit = getToolkit();
		Dimension screen = toolkit.getScreenSize();
		guiHeight = 515;
		guiWidth = 800;
		this.setBounds(screen.width / 2 - guiWidth / 2, screen.height / 2
				- guiHeight / 2, guiWidth, guiHeight);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Creates a file chooser with a filter for pictures
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				String extension = Utils.getExtension(f);
				if (extension != null) {
					if (extension.equals(Utils.tiff)
							|| extension.equals(Utils.tif)
							|| extension.equals(Utils.gif)
							|| extension.equals(Utils.jpeg)
							|| extension.equals(Utils.jpg)
							|| extension.equals(Utils.png)) {
						return true;
					} else {
						return false;
					}
				} else
					return false;
			}

			@Override
			public String getDescription() {
				return "All picture files";
			}
		});
		fileChooser.setCurrentDirectory(new File("images"));

		// Set up the GUI
		panels = new WorkingPanel[3];
		panels[0] = source1 = new WorkingPanel(0);
		source1.setBounds(44, 125, 189, 220);
		getContentPane().add(source1);

		panels[1] = source2 = new WorkingPanel(1);
		source2.setBounds(285, 125, 189, 220);
		getContentPane().add(source2);

		panels[2] = target = new WorkingPanel(2);
		target.setBounds(534, 125, 189, 220);
		getContentPane().add(target);

		methods = new JComboBox();
		for (Object string : filters) {
			methods.addItem(string);
		}
		methods.setBounds(138, 378, 265, 35);
		getContentPane().add(methods);

		go = new JButton("Go");
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTransformable mt = (MenuTransformable) methods
						.getSelectedItem();
				if (source1.getPicture() != null) {
					int width = source1.getPicture().width();
					int height = source1.getPicture().height();
					if (source2.getPicture() != null) {
						if (source2.getPicture().width() > width)
							width = source2.getPicture().width();
						if (source2.getPicture().height() > height)
							height = source2.getPicture().height();
					}
					target.setPicture(new Picture(width, height));
				} else
					target.setPicture(new Picture(800, 600));
				mt.transform(source1.getPicture(), source2.getPicture(),
						target.getPicture());
				repaint();
			}
		});
		go.setFont(new Font("Calibri", Font.PLAIN, 18));
		go.setBounds(427, 378, 163, 35);
		getContentPane().add(go);

		// Creates the addPic button and establishes its functionality.
		addpic = new JButton("");
		addpic.setEnabled(false);
		addpic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int returnVal = fileChooser.showOpenDialog(addpic);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					addPictureToTopBar(fileChooser.getSelectedFile());
				}
			}
		});
		addpic.setIcon(new ImageIcon("images/icons/plusIcon.png"));
		addpic.setBounds(50, 38, 50, 51);
		getContentPane().add(addpic);

		// Creates the left scroll button
		leftButton = new JButton("");
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topBar.moveLeft();
			}
		});
		leftButton.setIcon(new ImageIcon("images/icons/left_arrowIcon.png"));
		leftButton.setBounds(131, 44, 36, 37);
		getContentPane().add(leftButton);

		// Creates the right scroll button
		rightButton = new JButton("");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topBar.moveRight();
			}
		});
		rightButton.setIcon(new ImageIcon("images/icons/right_arrowIcon.png"));
		rightButton.setBounds(595, 44, 36, 37);
		getContentPane().add(rightButton);

		// Creates the topBar for displaying picture icons
		topBar = new TopPanel(this);
		topBar.setBounds(177, 38, 408, 51);
		getContentPane().add(topBar);

		// Creates the trash icon
		trash = new TrashButton("", topBar, this);
		trash.setIcon(new ImageIcon("images/icons/trashIcon.png"));
		trash.setEnabled(false);
		trash.setBounds(704, 38, 59, 51);
		getContentPane().add(trash);

		txtSource1 = new JTextField();
		txtSource1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSource1.setFocusTraversalKeysEnabled(false);
		txtSource1.setFocusable(false);
		txtSource1.setEditable(false);
		txtSource1.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtSource1.setBackground(new Color(214, 217, 233));
		txtSource1.setText("Source 1");
		txtSource1.setBounds(76, 345, 122, 28);
		getContentPane().add(txtSource1);

		txtSource2 = new JTextField();
		txtSource2.setText("Source 2");
		txtSource2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSource2.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtSource2.setFocusable(false);
		txtSource2.setFocusTraversalKeysEnabled(false);
		txtSource2.setEditable(false);
		txtSource2.setBackground(new Color(214, 217, 233));
		txtSource2.setBounds(320, 344, 122, 28);
		getContentPane().add(txtSource2);

		txtTarget = new JTextField();
		txtTarget.setText("Target");
		txtTarget.setHorizontalAlignment(SwingConstants.CENTER);
		txtTarget.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTarget.setFocusable(false);
		txtTarget.setFocusTraversalKeysEnabled(false);
		txtTarget.setEditable(false);
		txtTarget.setBackground(new Color(214, 217, 233));
		txtTarget.setBounds(568, 344, 122, 28);
		getContentPane().add(txtTarget);

		save = new JButton("");
		save.setIcon(new ImageIcon("images/icons/saveIcon.png"));
		save.setEnabled(false);
		save.setBounds(643, 38, 59, 51);
		new DropTarget(save, DnDConstants.ACTION_COPY, new DropTargetAdapter() {
			public void drop(DropTargetDropEvent dtde) {
				try {
					Transferable tr = dtde.getTransferable();
					Picture picture = (Picture) tr
							.getTransferData(sedgewickPicture);
					int returnVal = fileChooser.showSaveDialog(save);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File saveFile = fileChooser.getSelectedFile();
						picture.save(saveFile);
						System.out.println("Save successful!");
						dtde.dropComplete(true);
						topBar.addPicture(saveFile);
					}

				} catch (Exception e) {
					dtde.rejectDrop();
				}
			}
		}, true, null);
		getContentPane().add(save);

	}
	
	public void addPictureToTopBar(File f) {
		topBar.addPicture(f);
	}
	
	public WorkingPanel getSource1() {
		return source1;
	}
	
	public WorkingPanel getSource2() {
		return source2;
	}
	
	public WorkingPanel getWorkingPanel(int num) {
		return panels[num];
	}

}
