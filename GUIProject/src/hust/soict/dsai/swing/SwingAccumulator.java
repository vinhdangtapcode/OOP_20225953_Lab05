package hust.soict.dsai.swing;

import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class SwingAccumulator extends JFrame implements Serializable{
	private static final long serialVersionUID = 1L;
	private JTextField tfInput;
	private JTextField tfOutput1;
	private JTextField tfOutput2;
	private int sum = 0; //Accumulated sum, init to 0
	private int product = 1; //Accumulated product, init to 1
	
	// Contructor to setup the GUI components and event handlers
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3,2));
		
		cp.add(new JLabel("Enter an Integer: "));
		
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new JLabel("The Accumulated Sum is: "));
		
		tfOutput1 = new JTextField(10);
		tfOutput1.setEditable(false);
		cp.add(tfOutput1);
		
		cp.add(new JLabel("The Accumulated Product is: "));
		
		tfOutput2 = new JTextField(10);
		tfOutput2.setEditable(false);
		cp.add(tfOutput2);
		
		setTitle("Swing Accumulator");
		setSize(350,180);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			product *= numberIn;
			tfInput.setText("");
			tfOutput1.setText(sum + "");
			tfOutput2.setText(product + "");
		}
	}
}
