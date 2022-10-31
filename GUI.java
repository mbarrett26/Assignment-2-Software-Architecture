import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private float total = 0;
    private int numOfBananas = 0;
    private int numOfApples = 0;
    private JButton bananaButton, appleButton, startButton, payButton, endButton;
    private JLabel bananaLabel, appleLabel, totalLabel;
    private JFrame frame;
    private JPanel panel;

    public GUI() {

        frame = new JFrame();

        bananaButton = new JButton("Scan Banana");
        bananaButton.addActionListener(this);
        bananaButton.setEnabled(false);

        appleButton = new JButton("Scan Apple");
        appleButton.addActionListener(this);
        appleButton.setEnabled(false);

        bananaLabel = new JLabel("");
        appleLabel = new JLabel("");
        totalLabel = new JLabel("");

        startButton = new JButton("Start Session");
        startButton.addActionListener(this);

        payButton = new JButton("Accept Payment");
        payButton.addActionListener(this);
        payButton.setEnabled(false);

        endButton = new JButton("End Session");
        endButton.addActionListener(this);
        endButton.setEnabled(false);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(bananaButton);
        panel.add(appleButton);
        panel.add(bananaLabel);
        panel.add(appleLabel);
        panel.add(totalLabel);
        panel.add(startButton);
        panel.add(payButton);
        panel.add(endButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cash Register GUI");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bananaButton) {
            numOfBananas++;
            total += 0.75;
            bananaLabel.setText("Number of Bananas: " + numOfBananas);
            totalLabel.setText("Your total: $" + total);
        }

        if (e.getSource() == appleButton) {
            numOfApples++;
            total += 1.25;
            appleLabel.setText("Number of Apples: " + numOfApples);
            totalLabel.setText("Your total: $" + total);
        }

        if (e.getSource() == startButton) {
            bananaLabel.setText("Number of Bananas: 0");
            appleLabel.setText("Number of Apples: 0");
            totalLabel.setText("Your total: $0");
            bananaButton.setEnabled(true);
            appleButton.setEnabled(true);
            payButton.setEnabled(true);
            endButton.setEnabled(true);
            startButton.setEnabled(false);
        }

        if (e.getSource() == payButton) {
            bananaLabel.setText("");
            appleLabel.setText("");
            totalLabel.setText("Thank you for shopping. Have a nice day!");
            bananaButton.setEnabled(false);
            appleButton.setEnabled(false);
            payButton.setEnabled(false);
        }

        if (e.getSource() == endButton) {
            frame.dispose();
        }
    }
}
