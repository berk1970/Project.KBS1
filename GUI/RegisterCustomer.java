package GUI;

import database.QueryBuilder;
import database.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterCustomer extends JPanel implements ActionListener {

    private final CardLayout card;
    private final JPanel cards;
    private final JTextField naam;
    private final JTextField stad;
    private final JPasswordField wachtwoord;
    private final JButton cancelButton;
    private final JButton registerButton;

    private Account account;

    public RegisterCustomer(CardLayout card, JPanel cards, Account account) {
        this.card = card;
        this.cards = cards;
        this.account = account;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Registreren als klant");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.PAGE_START;
        add(titleLabel, gbc);

        JLabel naamLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(naamLabel, gbc);

        naam = new JTextField(40);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(naam, gbc);

        JLabel stadLabel = new JLabel("Stad:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(stadLabel, gbc);

        stad = new JTextField(40);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(stad, gbc);

        JLabel wachtwoordLabel = new JLabel("Wachtwoord:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(wachtwoordLabel, gbc);

        wachtwoord = new JPasswordField(40);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(wachtwoord, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerButton = new JButton("Registreren");
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            card.show(cards, "loginOptionPanel");
        }
        if(e.getSource() == registerButton){
            String query = new QueryBuilder()
                    .insertInto("users")
                    .columns("email", "city", "password")
                    .values(naam.getText(), stad.getText(), wachtwoord.getText())
                    .build();

            db.execute(query, true);

            try {

                ResultSet rs = new QueryBuilder()
                        .table("users")
                        .select("id, email")
                        .where("email", "=", naam.getText())
                        .execute();

                rs.next();
                String userId = rs.getString("id");

                int userIdResult = Integer.parseInt(userId);
                String emailResult = rs.getString("email");

                account.setEmail(emailResult);
                account.setUserId(userIdResult);


            } catch (SQLException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }

            naam.setText("");
            stad.setText("");
            wachtwoord.setText("");

            JPanel homePageCustomer = new HomePageCustomer(card, cards, account);
            cards.add(homePageCustomer, "homePageCustomer");

            card.show(cards, "homePageCustomer");
        }
    }
}
