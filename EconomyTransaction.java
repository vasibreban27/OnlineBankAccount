import javax.swing.*;
import java.awt.*;

public class EconomyTransaction {
    private JFrame frame;
    private BankAccount account;

    public EconomyTransaction(BankAccount account) {
        this.account = account;

        frame = new JFrame("Online Banking - Economy Transactions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JButton depositButton = new JButton("Deposit to Economy Account");
        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if(account.depositToEconomyAccount(amount))
                JOptionPane.showMessageDialog(frame, "Deposited $" + amount + " to economy account.");
            else
                JOptionPane.showMessageDialog(frame, "Insuficient funds in the Main Account!","Error", JOptionPane.ERROR_MESSAGE);
        });

        JButton withdrawButton = new JButton("Withdraw from Economy Account");
        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdrawFromEconomyAccount(amount)) {
                JOptionPane.showMessageDialog(frame, "Withdrew $" + amount + " from economy account.");
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient funds in economy account!", "Error", JOptionPane.ERROR_MESSAGE);
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
