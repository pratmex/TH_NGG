package pratmex;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NumberGuessingGame {
	
	private JFrame frame;
	private JTextField input;
	private JLabel titleLabel;
	private JLabel guessNumber;
	private JLabel guessUpdate;
	private JLabel totalGuesses;
	private JButton ok;
	
	private int number;
	private int temp;
	private int score;
	
	private Random random;
	
	private void numberGuessingGame() {
	    random = new Random();
		frame = new JFrame();
	    input = new JTextField();
	    titleLabel = new JLabel();
		guessNumber = new JLabel();
		guessUpdate = new JLabel();
		totalGuesses = new JLabel();
		ok = new JButton();
		
		score = 0;
		number = 0;
		temp = random.nextInt(1,101);
		
		titleLabel.setText("Guess a number between 1 to 100");
		titleLabel.setFont(new Font("consolas", Font.BOLD, 35));
		titleLabel.setForeground(new Color(0x98B4D4));
		titleLabel.setBounds(95,80,600,37);
		
		guessNumber.setText("Enter a number : ");
		guessNumber.setFont(new Font("consolas", Font.PLAIN, 30));
		guessNumber.setForeground(Color.WHITE);
		guessNumber.setBounds(190,170,286,32);
		
		input.setBounds(480,168,100,40);
		input.setBackground(Color.BLACK);
		input.setForeground(Color.WHITE);
		input.setFont(new Font("consolas", Font.BOLD,35));
		input.setBorder(BorderFactory.createEmptyBorder());
		
		ok.setText("Let\'s Go!");
		ok.setFont(new Font("consolas",Font.BOLD,25));
		ok.setBounds(190,230,125,30);
		ok.setBorder(BorderFactory.createEmptyBorder());
		ok.setBackground(Color.BLACK);
		ok.setForeground(Color.GRAY);
		ok.setFocusable(false);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Integer.parseInt(input.getText());
				if(number >= (temp + 15)) {
					guessUpdate.setText("It\'s a too high guess!");
					guessUpdate.setFont(new Font("consolas",Font.BOLD,35));
					guessUpdate.setBounds(190,300,450,40);
					guessUpdate.setForeground(Color.RED);
					score++;
				}
				if(number <= (temp - 15)) {
					guessUpdate.setText("It\'s a too low guess!");
					guessUpdate.setFont(new Font("consolas",Font.BOLD,35));
					guessUpdate.setBounds(190,300,450,40);
					guessUpdate.setForeground(Color.RED);
					score++;
				}
				if((number > temp) && (number <= (temp + 14))) {
					guessUpdate.setText("It\'s a high guess!");
					guessUpdate.setFont(new Font("consolas",Font.BOLD,35));
					guessUpdate.setBounds(190,300,450,40);
					guessUpdate.setForeground(Color.YELLOW);
					score++;
				}
				if((number < temp) && number >= (temp - 14)) {
					guessUpdate.setText("It\'s a low guess!");
					guessUpdate.setFont(new Font("consolas",Font.BOLD,35));
					guessUpdate.setBounds(190,300,450,40);
					guessUpdate.setForeground(Color.YELLOW);
					score++;
				}
				if(number == temp) {
					guessUpdate.setText("It\'s a perfect guess!");
					guessUpdate.setFont(new Font("consolas",Font.BOLD,35));
					guessUpdate.setBounds(190,300,450,40);
					guessUpdate.setForeground(Color.GREEN);
					score++;
					
					totalGuesses.setText("Total guesses : " + String.valueOf(score));
					totalGuesses.setFont(new Font("consolas",Font.BOLD,35));
					totalGuesses.setBounds(190,400,400,40);
					totalGuesses.setForeground(new Color(0xF0F8FF));
					
					input.setEditable(false);
					ok.setEnabled(false);
				}
			}
		});
		
		frame.setSize(800,550);
		frame.setTitle("Number Guessing Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(titleLabel);
		frame.add(guessNumber);
		frame.add(input);
		frame.add(ok);
		frame.add(guessUpdate);
		frame.add(totalGuesses);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		NumberGuessingGame ngg = new NumberGuessingGame();
		ngg.numberGuessingGame();
	}

}
