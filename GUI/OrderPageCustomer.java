package GUI;

import database.QueryBuilder;
import database.db;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPageCustomer extends JPanel implements ActionListener{

    private final CardLayout card;
    private final JPanel cards;
    private int orderId;
    private final JButton cancelButton;

    private Account account;

    public OrderPageCustomer(CardLayout card, JPanel cards, int orderId, Account account) {
        this.card = card;
        this.cards = cards;
        this.orderId = orderId;
        this.account = account;

        setLayout(new BorderLayout());


        JPanel navbar = new Navbar(card, cards, account);
        add(navbar, BorderLayout.NORTH);

        JPanel jpInfo = new JPanel();
        jpInfo.setLayout(new GridLayout(0, 1));
        jpInfo.setBorder(new EmptyBorder(10, 10, 50, 10));


        String createdAt = "";
        String payedDate = "";
        String quantity = "";
        String product = "";
        String description = "";
        String price = "";

        try {
            String joins = "LEFT JOIN orderlines ON orderlines.order_id = orders.id\n" +
                    "LEFT JOIN products ON products.id = orderlines.product_id\n";

            ResultSet rs = new QueryBuilder()
                    .select("orders.created_at, orders.payed, orderlines.quantity, products.product_name, products.description, products.price")
                    .table("orders " + joins)
                    .where("orders.id", "=", orderId)
                    .execute();

            // moet nog worden aangepast adhv the querybuilder, er was alleen geen optie voor joins en de IN operator

            rs.next();

            createdAt = rs.getString("created_at");
            payedDate = rs.getString("payed");
            quantity = rs.getString("quantity");
            product = rs.getString("product_name");
            description = rs.getString("description");
            price = rs.getString("price");

        } catch (SQLException ignored) {}

        JLabel productLabel = new JLabel("Productnaam: " + product);
        JLabel prijsLabel = new JLabel("Prijs: " + price);
        JLabel datumGemaaktLabel = new JLabel("Datum aangemaakt: " + createdAt);
        JLabel datumLabel = new JLabel("Datum gekocht: " + payedDate);
        JLabel aantalLabel = new JLabel("Aantal: " + quantity);
        JLabel beschrijvingLabel = new JLabel("Beschrijving: " + description);



        jpInfo.add(new JLabel("Order ID: " + orderId));
        jpInfo.add(productLabel);
        jpInfo.add(prijsLabel);
        jpInfo.add(datumGemaaktLabel);
        jpInfo.add(datumLabel);
        jpInfo.add(aantalLabel);
        jpInfo.add(beschrijvingLabel);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);

        jpInfo.add(cancelButton, BorderLayout.SOUTH);
        add(jpInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton){
            card.show(cards, "homePageCustomer");
        }
    }
}
