package Calculator;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator
{

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Calculator");
		frame.setSize(400,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		
		JTextField display = new JTextField();
		display.setBounds(0,0,400, 50);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,5,5));
		panel.setBounds(0, 50, 400, 550);
		
		String[] buttonLabels= {
				                  "7", "8", "9", "/",
				                  "4", "5", "6", "*",
				                   "1", "2", "3", "-",
				                   "0", "C", "=", "+"
				
		                       };
		for(String label : buttonLabels) {
			JButton button = new JButton(label);
			button.setBackground(Color.LIGHT_GRAY);
			button.addActionListener(e-> {
				String currenttext = display.getText();
				
				if(label.equals("=")) {
					
					display.setText(" ");
				}
				
				else {
					display.setText(currenttext+label);
					
				}
			});
			
			panel.add(button);
		}
		
		frame.add(display);
		frame.add(panel);
       
	}
	
	String Calculation(String Calc){
		String answer = Calc;
		
		for(int i = 0;i<Calc.length(); i++) {
			
		}
		
		return answer;
	}
	

}
