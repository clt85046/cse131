package calculator;

import java.awt.Font;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.GregorianCalendar;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Was originally written by Logan Sorrentino.
 * Some bug fixes and cleanup by Ron Cytron
 * @author roncytron
 *
 */


public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ToDo put all the textfields in an array, so we can easily pass through all of them and decrease amount of duplicated code.
	private JTextField doubleField1;
	private JTextField doubleField2;
	private JTextField intField1;
	private JTextField intField2;
	private JTextField stringField1;
	private JTextField stringField2;
	private JTextField booleanField1;
	private JTextField booleanField2;
	private JTextField[] inputFields;
	private JTextField doubleResult;
	private JTextField intResult;
	private JTextField stringResult;
	private JTextField booleanResult;
	public static Calculator calculator;

	private JTextField[] resultFields;

	private JComboBox stringOperator;
	private JButton moved1;
	private JButton moved2;
	private JButton movei1;
	private JButton movei2;
	private JButton moves1;
	private JButton moves2;
	private JButton moveb1;
	private JButton moveb2;
	private JButton[] MoveButtonArray;
	private JToggleButton toggleD;
	private JToggleButton toggleI;
	private JToggleButton toggleS;
	private JToggleButton toggleB;
	private JToggleButton[] ToggleButtonArray;
	private int moveFrom;
	private int moveTo;
	private JComboBox booleanOperator;
	private boolean b1;
	private boolean b2;
	private TextArea textArea;






	/**
	 * Create the panel.
	 */
	public Calculator() {

		getContentPane().setLayout(null);
		setBounds(0, 0, 784, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		calculator=this;




		doubleField1 = new JTextField();
		doubleField1.addMouseMotionListener(new MouseMotionAdapter() {
		});
		doubleField1.setBounds(125, 63, 79, 28);
		getContentPane().add(doubleField1);
		doubleField1.setColumns(10);
		doubleField1.setTransferHandler(new TransferHandler("text"));

		JLabel lblDouble = new JLabel("double");
		lblDouble.setBounds(33, 69, 61, 16);
		getContentPane().add(lblDouble);

		final JComboBox doubleOperation = new JComboBox();
		doubleOperation.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "/", "*"}));
		doubleOperation.setBounds(226, 64, 107, 27);
		getContentPane().add(doubleOperation);

		doubleField2 = new JTextField();
		doubleField2.setBounds(357, 63, 69, 28);
		getContentPane().add(doubleField2);
		doubleField2.setColumns(10);

		JLabel label = new JLabel("=");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(436, 67, 27, 16);
		getContentPane().add(label);

		JLabel lblInt = new JLabel("int");
		lblInt.setBounds(33, 155, 61, 16);
		getContentPane().add(lblInt);

		intField1 = new JTextField();
		intField1.setBounds(125, 149, 79, 28);
		getContentPane().add(intField1);
		intField1.setColumns(10);

		final JComboBox intOperation = new JComboBox();
		intOperation.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
		intOperation.setBounds(226, 150, 107, 27);
		getContentPane().add(intOperation);

		intField2 = new JTextField();
		intField2.setBounds(357, 149, 69, 28);
		getContentPane().add(intField2);
		intField2.setColumns(10);

		JLabel label_1 = new JLabel("=");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(436, 153, 27, 16);
		getContentPane().add(label_1);

		JLabel lblString = new JLabel("String");
		lblString.setBounds(33, 247, 61, 16);
		getContentPane().add(lblString);

		stringField1 = new JTextField();
		stringField1.setBounds(125, 241, 79, 28);
		getContentPane().add(stringField1);
		stringField1.setColumns(10);

		stringField2 = new JTextField();
		stringField2.setBounds(357, 241, 69, 28);
		getContentPane().add(stringField2);
		stringField2.setColumns(10);

		JLabel label_2 = new JLabel("=");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_2.setBounds(436, 245, 27, 16);
		getContentPane().add(label_2);

		doubleResult = new JTextField();
		doubleResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showMoveButtons();
			}
		});
		doubleResult.setEditable(false);
		doubleResult.setHorizontalAlignment(SwingConstants.RIGHT);
		doubleResult.setBounds(502, 67, 89, 20);
		getContentPane().add(doubleResult);
		doubleResult.setColumns(10);

		intResult = new JTextField();
		intResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showMoveButtons();
			}
		});
		intResult.setEditable(false);
		intResult.setHorizontalAlignment(SwingConstants.RIGHT);
		intResult.setBounds(502, 153, 89, 20);
		getContentPane().add(intResult);
		intResult.setColumns(10);

		stringResult = new JTextField();
		stringResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showMoveButtons();
			}
		});
		stringResult.setEditable(false);
		stringResult.setHorizontalAlignment(SwingConstants.RIGHT);
		stringResult.setBounds(502, 245, 89, 20);
		getContentPane().add(stringResult);
		stringResult.setColumns(10);

		booleanResult = new JTextField();
		booleanResult.setHorizontalAlignment(SwingConstants.RIGHT);
		booleanResult.setEditable(false);
		booleanResult.setColumns(10);
		booleanResult.setBounds(502, 318, 89, 20);
		getContentPane().add(booleanResult);

		JButton doubleCalculate = new JButton("Calculate");
		doubleCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				solveDouble((String)(doubleOperation.getSelectedItem()));
			}
		});
		doubleCalculate.setBounds(644, 67, 89, 23);
		getContentPane().add(doubleCalculate);

		JButton intCalculate = new JButton("Calculate");
		intCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				solveInt((String)(intOperation.getSelectedItem()));
			}
		});
		intCalculate.setBounds(644, 153, 89, 23);
		getContentPane().add(intCalculate);

		JButton stringCalculate = new JButton("Calculate");
		stringCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				solveString((String)stringOperator.getSelectedItem());
			}
		});
		stringCalculate.setBounds(644, 245, 89, 23);
		getContentPane().add(stringCalculate);

		stringOperator = new JComboBox();
		stringOperator.setModel(new DefaultComboBoxModel(new String[] {"+"}));
		stringOperator.setBounds(226, 245, 107, 20);
		getContentPane().add(stringOperator);

		JLabel lblBoolean = new JLabel("boolean");
		lblBoolean.setBounds(33, 320, 61, 16);
		getContentPane().add(lblBoolean);

		booleanField1 = new JTextField();
		booleanField1.setColumns(10);
		booleanField1.setBounds(125, 318, 79, 28);
		getContentPane().add(booleanField1);

		booleanField2 = new JTextField();
		booleanField2.setColumns(10);
		booleanField2.setBounds(357, 318, 69, 28);
		getContentPane().add(booleanField2);


		booleanOperator = new JComboBox();
		booleanOperator.setModel(new DefaultComboBoxModel(new String[] {"AND", "OR"}));
		booleanOperator.setBounds(226, 318, 107, 20);
		getContentPane().add(booleanOperator);

		JLabel label_3 = new JLabel("=");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_3.setBounds(436, 321, 27, 16);
		getContentPane().add(label_3);

		JButton booleanCalculate = new JButton("Calculate");
		booleanCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				solveBoolean((String)booleanOperator.getSelectedItem());
			}
		});
		booleanCalculate.setBounds(644, 318, 89, 23);
		getContentPane().add(booleanCalculate);

		moved1 = new JButton("Paste");
		moved1.setVisible(false);
		moved1.setActionCommand("Paste");
		moved1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=0;
				mymove(moveTo, moveFrom);
			}
		});
		moved1.setBounds(125, 91, 79, 23);
		getContentPane().add(moved1);

		moved2 = new JButton("Paste");
		moved2.setVisible(false);
		moved2.setActionCommand("Paste");
		moved2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=1;
				mymove(moveTo, moveFrom);
			}
		});
		moved2.setBounds(357, 91, 69, 23);
		getContentPane().add(moved2);

		movei2 = new JButton("Paste");
		movei2.setVisible(false);
		movei2.setActionCommand("Paste");
		movei2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=3;
				mymove(moveTo, moveFrom);
			}
		});
		movei2.setBounds(357, 177, 69, 23);
		getContentPane().add(movei2);

		moves2 = new JButton("Paste");
		moves2.setVisible(false);
		moves2.setActionCommand("Paste");
		moves2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=5;
				mymove(moveTo, moveFrom);
			}
		});
		moves2.setBounds(357, 269, 69, 23);
		getContentPane().add(moves2);

		moveb2 = new JButton("Paste");
		moveb2.setVisible(false);
		moveb2.setActionCommand("Paste");
		moveb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=7;
				mymove(moveTo, moveFrom);
			}
		});
		moveb2.setBounds(357, 346, 69, 23);
		getContentPane().add(moveb2);

		movei1 = new JButton("Paste");
		movei1.setVisible(false);
		movei1.setActionCommand("Paste");
		movei1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=2;
				mymove(moveTo, moveFrom);
			}
		});
		movei1.setBounds(125, 177, 79, 23);
		getContentPane().add(movei1);

		moves1 = new JButton("Paste");
		moves1.setVisible(false);
		moves1.setActionCommand("Paste");
		moves1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=4;
				mymove(moveTo, moveFrom);
			}
		});
		moves1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		moves1.setBounds(125, 269, 79, 23);
		getContentPane().add(moves1);

		moveb1 = new JButton("Paste");
		moveb1.setVisible(false);
		moveb1.setActionCommand("Paste");
		moveb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveTo=6;
				mymove(moveTo, moveFrom);
			}
		});
		moveb1.setBounds(125, 346, 79, 23);
		getContentPane().add(moveb1);


		toggleD = new JToggleButton("copy");
		toggleD.setMargin(new Insets(0, 0, 0, 0));
		toggleD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(toggleD.isSelected()){
					deselectAllBut(toggleD);
					moveFrom=0;
					showMoveButtons();
				}
				else{
					hideMoveButtons();
					moveFrom=-1;
				}

			}
		});
		toggleD.setBounds(596, 66, 37, 23);
		getContentPane().add(toggleD);

		toggleI = new JToggleButton("copy");
		toggleI.setMargin(new Insets(0, 0, 0, 0));
		toggleI.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(toggleI.isSelected()){
					deselectAllBut(toggleI);
					moveFrom=1;
					showMoveButtons();
				}
				else{
					hideMoveButtons();
					moveFrom=-1;
				}
			}
		});
		toggleI.setBounds(596, 152, 37, 23);
		getContentPane().add(toggleI);

		toggleS = new JToggleButton("copy");
		toggleS.setMargin(new Insets(0, 0, 0, 0));
		toggleS.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(toggleS.isSelected()){
					deselectAllBut(toggleS);
					moveFrom=2;
					showMoveButtons();
				}
				else{
					hideMoveButtons();
					moveFrom=-1;
				}
			}
		});
		toggleS.setBounds(596, 244, 37, 23);
		getContentPane().add(toggleS);

		toggleB = new JToggleButton("copy");
		toggleB.setMargin(new Insets(0, 0, 0, 0));
		toggleB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(toggleB.isSelected()){
					deselectAllBut(toggleB);
					moveFrom=3;
					showMoveButtons();
				}
				else{
					hideMoveButtons();
					moveFrom=-1;
				}
			}
		});
		toggleB.setBounds(596, 317, 37, 23);
		getContentPane().add(toggleB);

		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(101, 409, 455, 93);
		getContentPane().add(textArea);


		inputFields = new JTextField[] {
				doubleField1, doubleField2,
				intField1, intField2,
				stringField1, stringField2,
				booleanField1, booleanField2
		};

		resultFields = new JTextField[] {
				doubleResult, 
				intResult,
				stringResult,
				booleanResult
		};

		MoveButtonArray= new JButton[] {
				moved1, 
				moved2, 
				movei1, 
				movei2, 
				moves1, 
				moves2, 
				moveb1, 
				moveb2};

		ToggleButtonArray= new JToggleButton[] {toggleD, toggleI, toggleS, toggleB};


		setVisible(true);

	}



	/**
	 * 
	 * @param operator
	 */
	public void solveDouble(String operator){
		double d1;
		double d2;
		double ans;
		try{
			d1 = Double.parseDouble(doubleField1.getText());
		}
		catch(NumberFormatException nfe){
			errorDisplay("Field 1 is invalid.  Please enter a number of type double");
			return;
		}
		try{
			d2=  Double.parseDouble(doubleField2.getText());
		}
		catch(NumberFormatException nfe){
			errorDisplay("Field 2 is invalid.  Please enter a number of type double");
			return;
		}
		switch(operator.charAt(0)){
		case '+':	
			ans = Computations.addDoubles(d1, d2);
			doubleResult.setText(String.valueOf(ans));
			break;			
		case '-':	
			ans = Computations.subtractDoubles(d1, d2);
			doubleResult.setText(String.valueOf(ans));
			break;
		case '*':	
			ans = Computations.multiplyDoubles(d1, d2);
			doubleResult.setText(String.valueOf(ans));
			break;
		case '/':	
			ans = Computations.divideDoubles(d1, d2);
			doubleResult.setText(String.valueOf(ans));
			break;			
		}
	}

	public void solveInt(String operator){
		int i1;
		int i2;
		int ans;
		try{
			i1 = Integer.parseInt(intField1.getText());
		}
		catch(NumberFormatException nfe){
			errorDisplay("Field 1 is invalid.  Please enter a number of type int");
			return;
		}
		try{
			i2=  Integer.parseInt(intField2.getText());
		}
		catch(NumberFormatException nfe){
			errorDisplay("Field 2 is invalid.  Please enter a number of type int");
			return;
		}
		switch(operator.charAt(0)){
		case '+':	
			ans=Computations.addInts(i1, i2);
			intResult.setText(String.valueOf((ans)));
			break;
		case '-':	
			ans=Computations.subtractInts(i1, i2);
			intResult.setText(String.valueOf((ans)));
			break;
		case '*':	
			ans=Computations.multiplyInts(i1, i2);
			intResult.setText(String.valueOf((ans)));
			break;
		case '/':	
			ans=Computations.divideInts(i1, i2);
			intResult.setText(String.valueOf((ans)));
			break;		
		}

	}

	public void solveString(String operator){
		if(operator.equals("+")){
			stringResult.setText(stringField1.getText() + stringField2.getText());
		}
	}

	public void solveBoolean(String operator){
		stringToBoolean(booleanField1.getText(), 1);
		stringToBoolean(booleanField2.getText(), 2);
		boolean b1= this.b1;
		boolean b2= this.b2;
		if(operator.equals("AND")){
			booleanResult.setText(""+Computations.andBoolean(b1, b2));
		}
		else if(operator.equals("OR")){
			booleanResult.setText(""+Computations.orBoolean(b1, b2));
		}
		else throw new Error("Unrecognized operation " + operator);
	}

	public void stringToBoolean(String bool, int field){
		if(bool.compareTo("T")==0||bool.compareTo("t")==0||
				bool.compareTo("True")==0||bool.compareTo("true")==0){
			if(field==1){
				b1=true;
				return;
			}
			else{
				b2=true;
				return;
			}
		}
		if(bool.compareTo("F")==0||bool.compareTo("f")==0||
				bool.compareTo("False")==0||bool.compareTo("false")==0){
			if(field==1){
				b1=false;
				return;
			}
			else{
				b2=false;
				return;
			}
		}
		errorDisplay("The value in field " + field + " is unacceptable.  Please enter" +
				" true or false");
	}

	public boolean stringToBoolean(String string){
		if(string.compareTo("true")==0)
			return true;
		else 
			return false;
	}

	public void errorDisplay(String error){
		GregorianCalendar date= new GregorianCalendar();
		textArea.append(date.getTime().toString().substring(10,20)+ ") ");
		textArea.append(error +"\n");
	}


	public void mymove(int moveTo, int moveFrom){
		try {
			if(resultFields[moveFrom].getText().compareTo("")==0){
				errorDisplay("Cannot move an empty space");
				ToggleButtonArray[moveFrom].setSelected(false);
				hideMoveButtons();
				return;
			}
			String val = "";
			if(moveTo==0 || moveTo==1){
				switch (moveFrom){
				case 0:
					val = ""+
							Computations.doubleToDouble(Double.parseDouble(resultFields[moveFrom].getText()));
					break;
				case 1:
					val = ""+
							Computations.intToDouble(Integer.parseInt(resultFields[moveFrom].getText()));
					break;
				case 2:
					val = ""+
							Computations.stringToDouble((resultFields[moveFrom].getText()));
					break;
				case 3:
					val = ""+
							Computations.booleanToDouble((stringToBoolean(resultFields[moveFrom].getText())));
				}
			}
			if(moveTo==2 || moveTo==3){
				switch (moveFrom){
				case 0:
					val = ""+
							Computations.doubleToInt(Double.parseDouble(resultFields[moveFrom].getText()));
					break;
				case 1:
					val = ""+
							Computations.intToInt(Integer.parseInt(resultFields[moveFrom].getText()));
					break;
				case 2:
					val = ""+
							Computations.stringToInt((resultFields[moveFrom].getText()));
					break;
				case 3:
					val = ""+
							Computations.booleanToInt((stringToBoolean(resultFields[moveFrom].getText())));
				}
			}

			if(moveTo==4 || moveTo==5){
				switch (moveFrom){
				case 0:
					val = ""+
							Computations.doubleToString(Double.parseDouble(resultFields[moveFrom].getText()));
					break;
				case 1:
					val = ""+
							Computations.intToString(Integer.parseInt(resultFields[moveFrom].getText()));
					break;
				case 2:
					val = ""+
							Computations.stringToString((resultFields[moveFrom].getText()));
					break;
				case 3:
					val = ""+
							Computations.booleanToString((stringToBoolean(resultFields[moveFrom].getText())));
				}

			}
			if(moveTo==6 || moveTo==7){
				switch (moveFrom){
				case 0:
					val = ""+
							Computations.doubleToBoolean(Double.parseDouble(resultFields[moveFrom].getText()));
					break;
				case 1:
					val = ""+
							Computations.intToBoolean(Integer.parseInt(resultFields[moveFrom].getText()));
					break;
				case 2:
					val = ""+
							Computations.stringToBoolean((resultFields[moveFrom].getText()));
					break;
				case 3:
					val = ""+
							Computations.booleanToBoolean((stringToBoolean(resultFields[moveFrom].getText())));
				}
			}
			this.inputFields[moveTo].setText(val);
			hideMoveButtons();
			ToggleButtonArray[moveFrom].setSelected(false);
			moveFrom=-1;
		} catch(UnsupportedOperationException e) {
			errorDisplay("Unsupported Operation");  
		}
	}


	public void showMoveButtons(){
		for(int i=0; i<MoveButtonArray.length; i++){
			MoveButtonArray[i].setVisible(true);
		}
	}

	public void hideMoveButtons(){
		for(int i=0; i<MoveButtonArray.length; i++){
			MoveButtonArray[i].setVisible(false);
		}
	}
	//Deselects all ToggleButtons but the one provided as a parameter
	public void deselectAllBut(JToggleButton button){
		for(int i=0; i<ToggleButtonArray.length; i++){
			ToggleButtonArray[i].setSelected(ToggleButtonArray[i]==button);
		}
	}

	public static void main(String[] args){
		Calculator calculator = new Calculator();

	}
}

