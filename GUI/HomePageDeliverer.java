package GUI;

import database.QueryBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomePageDeliverer extends JPanel implements ActionListener {

    private final CardLayout card;
    private final JPanel cards;

    private JTable jtaTable;

    private JButton jbMakeRoute;

    private Account account;
    public HomePageDeliverer(CardLayout card, JPanel cards, Account account) {
        this.card = card;
        this.cards = cards;
        this.account = account;

        JPanel navbar = new Navbar(card, cards, account);
        add(navbar);

        JLabel jlTitle = new JLabel("Te bezorgen");
        jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlTitle.setFont(new Font("Calibri", Font.BOLD, 40));

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 10));

        add(jlTitle);
        add(emptyLabel);
        add(new JLabel("Kies de orders die u wilt bezorgen"));

        JPanel jpOrders = new JPanel();
        jpOrders.setPreferredSize(new Dimension(600, 350));
        jpOrders.setBorder(new EmptyBorder(10, 10, 50, 10));

        String[] columnNames = {"checks", "order ID", "datum", "stad"};
        Object[][] emptyData = {};

        DefaultTableModel model = new DefaultTableModel(emptyData, columnNames);

        ResultSet rs = new QueryBuilder()
                .select("*")
                .table("vw_undelivered_orders")
                .execute();

        try {
            while (rs.next()) {
                String orderId = rs.getString("id");
                String date = rs.getString("created_at");
                String city = rs.getString("city");

                Object[] row = {false, orderId, date, city};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        jtaTable = new JTable(model) {


            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };

        JScrollPane jsp = new JScrollPane(jtaTable);
        jpOrders.add(jsp);

        add(jpOrders);

        jbMakeRoute = new JButton("Route maken");
        jbMakeRoute.addActionListener(this);
        add(jbMakeRoute);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbMakeRoute) {
            ArrayList<Integer> selectedOrderIds = new ArrayList<Integer>();

            for(int i=0;i<jtaTable.getModel().getRowCount();i++) {
                if ((Boolean) jtaTable.getModel().getValueAt(i, 0)) {
                    String orderId = (String) jtaTable.getModel().getValueAt(i, 1);
                    try {
                        int number = Integer.parseInt(orderId);
                        selectedOrderIds.add(number);
                    } catch (NumberFormatException ignored) {}
                }
            }

            if (selectedOrderIds.size() != 0) {
                JPanel routePageDeliverer = new RoutePageDeliverer(card, cards, selectedOrderIds, account);
                cards.add(routePageDeliverer, "routePageDeliverer");
                card.show(cards, "routePageDeliverer");
            }
        }
    }
}