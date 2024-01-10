import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Calculator implements ActionListener{

	JFrame frame;
	JTextField Field;
	
	JPanel panel;
	ArrayList<JButton> Numbers = new ArrayList<>();
	ArrayList<JButton> Operators = new ArrayList<>();
	JButton add, sub, multiply, divide, decimal, equals, delete, clear;
	
	Font myFont = new Font("Bookman Old Style",Font.BOLD,30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.decode("#59b5c5"));
		
		Field = new JTextField();
		Field.setBounds(140, 25, 300, 50);
		Field.setFont(myFont);
		Field.setEditable(false); //user cannot write
		
		
		add = new JButton("+");
		sub = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		decimal = new JButton(",");
		equals = new JButton("=");
		delete = new JButton("<-");
		clear = new JButton("C");
		
		
		Operators.add(add);
		Operators.add(sub);
		Operators.add(multiply);
		Operators.add(divide);
		Operators.add(decimal);
		Operators.add(equals);
		Operators.add(delete);
		Operators.add(clear);
		
		
		for(int x = 0;x<8;x++) {
			Operators.get(x).addActionListener(this);
			Operators.get(x).setFont(myFont);
			Operators.get(x).setFocusable(false);
			Operators.get(x).setBackground(Color.decode("#dd7722"));
		}
		for(int x=0;x<10;x++) {
			Numbers.add(new JButton(String.valueOf(x)));
			Numbers.get(x).addActionListener(this);
			Numbers.get(x).setFont(myFont);
			Numbers.get(x).setFocusable(false);
			Numbers.get(x).setBackground(Color.white);
		}
		
		//Setting Button sizes and positions
		clear.setBounds(0,0,150,70);
		delete.setBounds(155,0,70,70);
		divide.setBounds(230,0,70,70);
		Numbers.get(7).setBounds(0, 75, 72, 70);
		Numbers.get(8).setBounds(75, 75, 75, 70);
		Numbers.get(9).setBounds(155, 75, 70, 70);
		multiply.setBounds(230,75,70,70);
		Numbers.get(4).setBounds(0, 150, 72, 70);
		Numbers.get(5).setBounds(75, 150, 75, 70);
		Numbers.get(6).setBounds(155, 150, 70, 70);
		sub.setBounds(230,150,70,70);
		Numbers.get(1).setBounds(0, 225, 72, 70);
		Numbers.get(2).setBounds(75, 225, 75, 70);
		Numbers.get(3).setBounds(155, 225, 70, 70);
		add.setBounds(230,225,70,70);
		Numbers.get(0).setBounds(0,300,150,70);
		decimal.setBounds(155,300,70,70);
		equals.setBounds(230,300,70,70);
		
		//Creating the panel, which will contain the buttons
		panel = new JPanel();
		panel.setBounds(140,100,300,370);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#4399a8"));
		
		//Adding the buttons to the panel
		panel.add(clear);
		panel.add(delete);
		panel.add(divide);
		panel.add(Numbers.get(7));
		panel.add(Numbers.get(8));
		panel.add(Numbers.get(9));
		panel.add(multiply);
		panel.add(Numbers.get(4));
		panel.add(Numbers.get(5));
		panel.add(Numbers.get(6));
		panel.add(sub);
		panel.add(Numbers.get(1));
		panel.add(Numbers.get(2));
		panel.add(Numbers.get(3));
		panel.add(add);
		panel.add(Numbers.get(0));
		panel.add(decimal);
		panel.add(equals);
		
		frame.add(panel);
		frame.add(Field);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int x = 0; x<10;x++) {
			if(e.getSource() == Numbers.get(x)) {
				Field.setText(Field.getText().concat(String.valueOf(x)));
			}
		}
		if(e.getSource()==decimal) {
			Field.setText(Field.getText().concat("."));
		}
		if(e.getSource()==add) {
			num1 = Double.parseDouble(Field.getText());
			operator ='+';
			Field.setText("");
		}
		if(e.getSource()==sub) {
			num1 = Double.parseDouble(Field.getText());
			operator ='-';
			Field.setText("");
		}
		if(e.getSource()==multiply) {
			num1 = Double.parseDouble(Field.getText());
			operator ='*';
			Field.setText("");
		}
		if(e.getSource()==divide) {
			num1 = Double.parseDouble(Field.getText());
			operator ='/';
			Field.setText("");
		}
		if(e.getSource()==equals) {
			num2=Double.parseDouble(Field.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
			}
			Field.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clear) {
			Field.setText("");
		}
		if(e.getSource() == delete) {
			String text = Field.getText();
			Field.setText("");
			for(int x = 0; x<text.length()-1;x++) {
				Field.setText(Field.getText()+text.charAt(x));
			}
		}
	}
}
