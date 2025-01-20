import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciSwingApp extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;
    private JLabel sequenceLabel;
    private JButton calculateButton;

    public FibonacciSwingApp() {
        // Setam titlul ferestrei
        setTitle("Calculator Fibonacci - Programare Dinamica");

        // Setam layout-ul ferestrei
        setLayout(new FlowLayout());

        // Cream componentele
        inputField = new JTextField(10);
        calculateButton = new JButton("Calculează Fibonacci");
        resultLabel = new JLabel("Rezultatul va apărea aici");
        sequenceLabel = new JLabel("Șirul Fibonacci va apărea aici");

        // Adaugam componentele in fereastra
        add(new JLabel("Introduceți un număr:"));
        add(inputField);
        add(calculateButton);
        add(resultLabel);
        add(sequenceLabel);

        // Configuram acțiunea butonului
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Citim valoarea introdusa de utilizator
                try {
                    int n = Integer.parseInt(inputField.getText());
                    int result = fibonacci(n);
                    String sequence = fibonacciSequence(n);

                    // Setam textul pentru rezultatul final si sirul Fibonacci
                    resultLabel.setText("Fibonacci(" + n + ") = " + result);
                    sequenceLabel.setText("Sirul Fibonacci: " + sequence);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Va rugam sa introduceti un numar valid!");
                    sequenceLabel.setText("");
                }
            }
        });

        // Setam dimensiunile ferestrei si alte optiuni
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrarea ferestrei pe ecran
    }

    // Metoda Fibonacci utilizand programare dinamica
    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Metoda pentru a obține intregul sir Fibonacci pana la n
    private String fibonacciSequence(int n) {
        if (n == 0) return "0";
        if (n == 1) return "0, 1";

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        StringBuilder sequence = new StringBuilder("0, 1");

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            sequence.append(", ").append(dp[i]);
        }

        return sequence.toString();
    }

    public static void main(String[] args) {
        // Cream și afișam fereastra aplicației
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FibonacciSwingApp().setVisible(true);
            }
        });
    }
}
