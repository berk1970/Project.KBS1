package GUI;

import database.QueryBuilder;
import database.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPanel extends JPanel implements ActionListener {

    private final CardLayout card;
    private final JPanel cards;
    private final String role;
    private final String nederlandseRole;
    private final JTextField jtUsername;
    private final JLabel errorMessage;
    private final JPasswordField jtPassword;
    private final JButton jbLogin, jbCancel, jbRegistreren;
    private Account account;

    public LoginPanel(CardLayout card, JPanel cards, String role, Account account) {
        this.card = card;
        this.cards = cards;
        this.role = role;
        this.account = account;

        setLayout(new GridLayout(0, 1));

        jbLogin = new JButton("Login");
        jbCancel = new JButton("Cancel");
        jbRegistreren = new JButton("Registeren");

        jbLogin.setPreferredSize(new Dimension(200, 60));
        jbCancel.setPreferredSize(new Dimension(200, 60));
        jbRegistreren.setPreferredSize(new Dimension(300, 40));

        jbLogin.addActionListener(this);
        jbCancel.addActionListener(this);
        jbRegistreren.addActionListener(this);

        jtUsername = new JTextField(20);
        jtPassword = new JPasswordField(20);

        JPanel jpText = new JPanel(new FlowLayout());
        JPanel jpUsername = new JPanel(new FlowLayout());
        JPanel jpPassword = new JPanel(new FlowLayout());
        JPanel jpButtons = new JPanel(new FlowLayout());

        jpUsername.add(new JLabel("Email: "));
        jpUsername.add(jtUsername);

        jpPassword.add(new JLabel("Wachtwoord: "));
        jpPassword.add(jtPassword);

        jpButtons.add(jbLogin);
        jpButtons.add(jbCancel);
        jpButtons.add(jbRegistreren);

        nederlandseRole = Objects.equals(role, "Deliverer") ? "bezorger" : "klant";
        JLabel loginAS = new JLabel("Inloggen als " + nederlandseRole);
        loginAS.setHorizontalAlignment(SwingConstants.CENTER);
        loginAS.setFont(new Font("Calibri", Font.BOLD, 40));

        errorMessage = new JLabel("");
        errorMessage.setPreferredSize(new Dimension(600, 20));
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setForeground(Color.red);

        jpText.add(loginAS);
        jpText.add(errorMessage);

        add(jpText);
        add(jpUsername);
        add(jpPassword);
        add(jpButtons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbCancel) card.show(cards, "loginOptionPanel");
        else if (e.getSource() == jbLogin) {
            String email = jtUsername.getText();
            String password = jtPassword.getText();

            Integer correctPasswordInt = 0;

            try {
                ResultSet rs = db.authenticate(email, password);

                rs.next();
                String correctPasswordStr = rs.getString(1);
                correctPasswordInt = Integer.parseInt(correctPasswordStr);

            } catch (SQLException | NumberFormatException ex) {
                errorMessage.setText(ex.getMessage());
            }

            if (correctPasswordInt == 0) {
                errorMessage.setText("Combinatie van email en wachtwoord bestaat niet!");
                return;
            }

            String roleResult = "user";

            try {

                ResultSet rs = new QueryBuilder()
                        .table("users")
                        .select("id, email, role")
                        .where("email", "=", email)
                        .execute();

                rs.next();
                String userId = rs.getString("id");

                int userIdResult = Integer.parseInt(userId);
                String emailResult = rs.getString("email");

                account.setEmail(emailResult);
                account.setUserId(userIdResult);

                roleResult = rs.getString("role");

            } catch (SQLException | NumberFormatException ex) {
                errorMessage.setText(ex.getMessage());
            }

            System.out.println(role + roleResult);
            if ((Objects.equals(role, "Customer") && !Objects.equals(roleResult, "user"))
                    || (Objects.equals(role, "Deliverer") && !Objects.equals(roleResult, "admin"))) {
                errorMessage.setText("Verkeerd accounttype!");
                return;
            }

            errorMessage.setText("");
            jtUsername.setText("");
            jtPassword.setText("");

            JPanel homePageCustomer = new HomePageCustomer(card, cards, account);
            JPanel homePageDeliverer = new HomePageDeliverer(card, cards, account);

            cards.add(homePageCustomer, "homePageCustomer");
            cards.add(homePageDeliverer, "homePageDeliverer");

            if (nederlandseRole.equals("klant")) card.show(cards, "homePageCustomer");
            else card.show(cards, "homePageDeliverer");

        } else if (e.getSource() == jbRegistreren) {
            if (Objects.equals(role, "Deliverer")) card.show(cards, "registerDeliverer");
            else card.show(cards, "registerCustomer");
        }

    }
}
