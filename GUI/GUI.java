package GUI;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {

    private final CardLayout card;

    private Account account;

    public GUI() throws IOException {
        setTitle("NeryGadgets system");
        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cards = new JPanel();
        card = new CardLayout();
        cards.setLayout(card);

        account = new Account();

        JPanel loginOptionPanel = new LoginOptionPanel(card, cards);
        JPanel loginPanelDeliverer = new LoginPanel(card, cards, "Deliverer", account);
        JPanel loginPanelCustomer = new LoginPanel(card, cards, "Customer", account);
        JPanel registerCustomer = new RegisterCustomer(card, cards, account);
        JPanel registerDeliverer = new RegisterDeliver(card, cards, account);


        cards.add(loginOptionPanel, "loginOptionPanel");
        cards.add(loginPanelDeliverer, "loginPanelDeliverer");
        cards.add(loginPanelCustomer, "loginPanelCustomer");
        cards.add(registerCustomer, "registerCustomer");
        cards.add(registerDeliverer, "registerDeliverer");


        add(cards);
        setVisible(true);
    }
}
