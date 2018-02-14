import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lbloutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message =  "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + " is correct. You win! Let's play again!";
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		} finally {
			lbloutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100+1);
	}
	public GuessingGame() {
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jama's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblJamasHiloGuessing = new JLabel("Jama's Hi-Lo Guessing Game");
		lblJamasHiloGuessing.setForeground(Color.BLACK);
		lblJamasHiloGuessing.setFont(new Font("Impact", Font.BOLD, 21));
		lblJamasHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblJamasHiloGuessing.setBounds(6, 30, 438, 26);
		getContentPane().add(lblJamasHiloGuessing);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(17, 96, 306, 16);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.setBounds(323, 91, 42, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(166, 124, 117, 29);
		getContentPane().add(btnGuess);

		lbloutput = new JLabel("Enter a number above and click Guess!");
		lbloutput.setHorizontalAlignment(SwingConstants.CENTER);
		lbloutput.setBounds(69, 221, 283, 16);
		getContentPane().add(lbloutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
		// TODO Auto-generated method stub

	}
}
