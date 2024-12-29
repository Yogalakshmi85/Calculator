package calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements ActionListener{
	
	JFrame frame= new JFrame();
	ImageIcon icon = new ImageIcon("letter.png");
	JTextField textField;
	JButton[] numberButtons=new JButton[10];
	JButton[] functionButtons=new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton delButton, clrButton, equButton, decButton, negButton;
	JPanel panel;
	
	Font myfont=new Font("Verdana",Font.PLAIN,35);
	
	double num1=0, num2=0, res=0;
	char op;
	
	Main(){
		frame.setSize(420,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setLayout(null);
		frame.setIconImage(icon.getImage()) ;
		
		textField=new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myfont);
		textField.setEditable(false);
	
		addButton=new JButton("+");
		subButton=new JButton("-");
		mulButton=new JButton("*");
		divButton=new JButton("/");
		delButton=new JButton("del");
		clrButton=new JButton("clr");
		equButton=new JButton("=");
		decButton=new JButton(".");
		negButton=new JButton("(-)");
		
		functionButtons[0]=addButton;
		functionButtons[1]=subButton;
		functionButtons[2]=mulButton;
		functionButtons[3]=divButton;
		functionButtons[4]=decButton;
		functionButtons[5]=equButton;
		functionButtons[6]=delButton;
		functionButtons[7]=clrButton;
		functionButtons[8]=negButton;
		
		for(int i=0;i<9;i++) {
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(myfont);
			functionButtons[i].addActionListener(this);
		}
		
		for(int i=0;i<10;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(myfont);
			numberButtons[i].addActionListener(this);
		}
		
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[9]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[7]);
		panel.add(addButton);
		panel.add(numberButtons[6]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[4]);
		panel.add(subButton);
		panel.add(numberButtons[3]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[1]);
		panel.add(mulButton);
		panel.add(numberButtons[0]);
		panel.add(divButton);
		panel.add(decButton);
		panel.add(equButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Main main=new Main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1= Double.parseDouble(textField.getText());
			op='+';
			textField.setText("");;
		}
		
		if(e.getSource()==subButton) {
			num1= Double.parseDouble(textField.getText());
			op='-';
			textField.setText("");
		}
		
		if(e.getSource()==mulButton) {
			num1= Double.parseDouble(textField.getText());
			op='*';
			textField.setText("");
		}
		
		if(e.getSource()==divButton) {
			num1= Double.parseDouble(textField.getText());
			op='/';
			textField.setText("");
		}
		if(e.getSource()==equButton) {
			num2= Double.parseDouble(textField.getText());
			
			switch (op) {
			case '+': 
				res=num1+num2;
				break;
			case '-':
				res=num1-num2;
				break;
			case '*':
				res=num1*num2;
				break;
			case '/':
				res=num1/num2;
				break;
			}
			
			textField.setText(String.valueOf(res));
			num1=res;
		}
		
		if(e.getSource()==clrButton) {
			textField.setText("");
		}
		
		if(e.getSource()==delButton) {
			String string=textField.getText();
			textField.setText("");
			
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
			
		}
		
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
	}
}