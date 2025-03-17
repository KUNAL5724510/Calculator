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
			
			button.addActionListener(e-> {
				String currenttext = display.getText();
				
				if(label.equals("=")) {
					
					display.setText(String.valueOf(evaluateExpression(display.getText())));
				}
				else if(label.equals("C")) {
					display.setText("");
				}
				else {
					display.setText(currenttext+label);
					
				}
			});
			
			panel.add(button);
			button.setOpaque(true);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setBackground(Color.LIGHT_GRAY); // Set base color only once

            
			button.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			        button.setBackground(Color.DARK_GRAY);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        button.setBackground(Color.LIGHT_GRAY);
			    }

			    public void mousePressed(java.awt.event.MouseEvent evt) {
			        button.setBackground(Color.GRAY); // Temporary click color
			    }

			    public void mouseReleased(java.awt.event.MouseEvent evt) {
			        button.setBackground(Color.LIGHT_GRAY); // Restore after release
			    }
			});


		}
		
		
		
		frame.add(display);
		frame.add(panel);
       
	}
	
	static int evaluateExpression(String expression) {
        int result = 0;
        int num = 0;
        char lastOperator = '+'; // Assume first operation is addition

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Build the number
            }

            if (!Character.isDigit(ch) || i == expression.length() - 1) {
                // Perform the previous operation
                if (lastOperator == '+') {
                    result += num;
                } else if (lastOperator == '-') {
                    result -= num;
                } else if (lastOperator == '*') {
                    result *= num;
                } else if (lastOperator == '/') {
                    result /= num;
                }

                // Reset num and store new operator
                num = 0;
                lastOperator = ch;
            }
        }

        return result;
    }
	

}
