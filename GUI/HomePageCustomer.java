    package GUI;

    import database.QueryBuilder;
    import database.db;

    import javax.swing.*;
    import javax.swing.border.EmptyBorder;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class HomePageCustomer extends JPanel {
        private final CardLayout card;
        private final JPanel cards;

        private Account account;

        public HomePageCustomer(CardLayout card, JPanel cards, Account account) {
            this.card = card;
            this.cards = cards;
            this.account = account;

            JPanel navbar = new Navbar(card, cards, account);
            add(navbar);

            JLabel jlTitle = new JLabel("Bestellingen");
            jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
            jlTitle.setFont(new Font("Calibri", Font.BOLD, 40));

            add(jlTitle);

            // Maak de tabel met bestellingen
            JPanel jpOrders = new JPanel();
            jpOrders.setBorder(new EmptyBorder(10, 10, 50, 10));



            String[] columnNames = {"Order ID", "Datum", "Product"};
            Object[][] emptyData = {};

            DefaultTableModel model = new DefaultTableModel(emptyData, columnNames);
            JTable jtaTable = new JTable(model);
            jtaTable.setBounds(30, 40, 200, 200);

            try {
                String joins = "LEFT JOIN orderlines ON orderlines.order_id = orders.id\n" +
                        "LEFT JOIN products ON orderlines.product_id = products.id\n";

                ResultSet rs = new QueryBuilder()
                        .select("orders.id, orders.created_at, products.product_name")
                        .table("orders " + joins)
                        .where("user_id", "=", account.getUserId())
                        .execute();


                // moet nog worden aangepast adhv the querybuilder, er was alleen geen optie voor joins en de IN operator

                while (rs.next()) {
                    String orderId = rs.getString("id");
                    String date = rs.getString("created_at");
                    String product = rs.getString("product_name");

                    Object[] row = {orderId, date, product};
                    model.addRow(row);
                }
            } catch (SQLException ignored) {}

            JScrollPane jsp = new JScrollPane(jtaTable);
            jpOrders.add(jsp);

            jtaTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = jtaTable.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        String orderId = (String) jtaTable.getModel().getValueAt(row, 0);
                        try {
                            int orderIdNumber = Integer.parseInt(orderId);
                            JPanel orderPageCustomer = new OrderPageCustomer(card, cards, orderIdNumber, account);
                            cards.add(orderPageCustomer, "orderPpageCustomer");
                            card.show(cards, "orderPpageCustomer");
                        } catch (NumberFormatException e) {
                            System.out.println("Error opening new page");
                        }
                    }
                }
            });

            add(jpOrders);
        }
    }

