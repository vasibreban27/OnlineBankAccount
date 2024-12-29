import javax.swing.*;
import java.awt.*;

public class Dashboard {
    private JFrame frame;
    private BankAccount account;
    public Dashboard() {
        account = new BankAccount("Breban Vasile" , 2000.0);

        frame = new JFrame("Online Banking - Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));

        JLabel welcomeLabel = new JLabel("Welcome, " + account.getAccountHolder() + "!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel);

        JButton balanceButton = new JButton("Check Main Account Balance");
        balanceButton.addActionListener(e -> JOptionPane.showMessageDialog(frame,"Your main account balance is: $"+ account.getBalance()));
        panel.add(balanceButton);

        JButton economyAccountBalanceButton = new JButton("Check Economy Account Balance");
        economyAccountBalanceButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Your economy account balance is: $" + account.getEconomyAccountBalance()));
        panel.add(economyAccountBalanceButton);

        JButton transactionsButton = new JButton("Make a Transaction");
        transactionsButton.addActionListener(e -> new Transaction(account));
        panel.add(transactionsButton);

        JButton economyTransactionButton = new JButton("Economy Account Transactions");
        economyTransactionButton.addActionListener(e -> new EconomyTransaction(account));
        panel.add(economyTransactionButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}