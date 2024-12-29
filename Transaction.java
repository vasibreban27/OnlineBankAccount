import javax.swing.*;
import java.awt.*;

public class Transaction {
    private JFrame frame;
    private BankAccount account;

    public Transaction(BankAccount account) {
        this.account = account;

        frame = new JFrame("Online Banking - Transaction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            JOptionPane.showMessageDialog(frame,"Deposited $"+amount+" to the Main Account.");
        });

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if(account.withdraw(amount)) {
                JOptionPane.showMessageDialog(frame,"Withdrew $"+amount+" from the Main Account.");
            }else{
                JOptionPane.showMessageDialog(frame,"Insuficient funds!.","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}