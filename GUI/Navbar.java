package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navbar extends JPanel implements ActionListener {

    private CardLayout card;
    private JPanel cards;
    private JButton jtName, jtLogout;

    private Account account;


    public Navbar(CardLayout card, JPanel cards, Account account) {
        this.card = card;
        this.cards = cards;

        setSize(600, 60);
        setBackground(Color.LIGHT_GRAY);

        // Maak een flowlayout voor de navbar

        // Knoppen voor de navigatiebalk
        jtName = new JButton(account.getEmail());
        jtLogout = new JButton("Uitloggen");
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(360, 50));

        jtLogout.addActionListener(this);

        // Voeg de knoppen toe aan de navigatiebalk
        add(jtName);
        add(emptyLabel);
        add(jtLogout);

        // Voeg de navigatiebalk toe aan het JFrame
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jtLogout) {
            card.show(cards, "loginOptionPanel");
        }
    }
}
