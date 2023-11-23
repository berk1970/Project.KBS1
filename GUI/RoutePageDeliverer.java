package GUI;

import database.QueryBuilder;
import database.db;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class RoutePageDeliverer extends JPanel implements ActionListener {

    private final CardLayout card;
    private final JPanel cards;

    private JTable jtaTable;

    private JButton jbDone, jbCancel;

    private Account account;


    public RoutePageDeliverer(CardLayout card, JPanel cards, ArrayList<Integer> orderIds, Account account) {
        this.card = card;
        this.cards = cards;
        this.account = account;

        JPanel navbar = new Navbar(card, cards, account);
        add(navbar);

        JLabel jlTitle = new JLabel("Locaties te bezorgen");
        jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlTitle.setFont(new Font("Calibri", Font.BOLD, 40));

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 10));

        add(jlTitle);
        add(emptyLabel);
        add(new JLabel("De volgorde van de orders is de volgorde van de route, vink af wat er bezorgd is"));

        JPanel jpOrders = new JPanel();
        jpOrders.setPreferredSize(new Dimension(600, 350));
        jpOrders.setBorder(new EmptyBorder(10, 10, 50, 10));

        ArrayList<ArrayList<Object>> data = calculateRoute(orderIds);

        String[] columnNames = {"bezorgd", "order ID", "stad", "lat", "lng"};
        Object[][] emptyData = {};

        DefaultTableModel model = new DefaultTableModel(emptyData, columnNames);
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

        for (int i = 0; i < data.size(); i++) {
            String orderId = (String) data.get(i).get(0);
            String city = (String) data.get(i).get(1);
            Double lat = (Double) data.get(i).get(2);
            Double lng = (Double) data.get(i).get(3);

            Object[] rowData = {false, orderId, city, lat, lng};
            //System.out.println(orderId + " " + city);
            model.addRow(rowData);
        }

        JScrollPane jsp = new JScrollPane(jtaTable);
        jpOrders.add(jsp);

        add(jpOrders);

        jbDone = new JButton("klaar");
        jbDone.addActionListener(this);
        add(jbDone);

        jbCancel = new JButton("annuleren");
        jbCancel.addActionListener(this);
        add(jbCancel);
    }

    public static ArrayList<ArrayList<Object>> calculateRoute(ArrayList<Integer> orderIds) {

        double STARTING_CITY_LAT = 52.372800; // Amsterdam
        double STARTING_CITY_LNG = 4.893600;

        String orderIdsString = orderIds.toString().replace("[","(").replace("]",")");
        String joins = "LEFT JOIN users ON orders.user_id = users.id\n" +
                "LEFT JOIN cities ON users.city = cities.id\n" +
                "WHERE orders.id IN " + orderIdsString;


        ResultSet resultSet = new QueryBuilder()
                .select("orders.id, cities.city, cities.lat, cities.lng")
                .table("orders " + joins)
                .execute();


        // moet nog worden aangepast adhv the querybuilder, er was alleen geen optie voor joins en de IN operator

        ArrayList<ArrayList<Object>> unorderedData = new ArrayList<>();

        try {

            while (resultSet.next()) {
                ArrayList<Object> row = new ArrayList<>();
                row.add(resultSet.getString("id"));
                row.add(resultSet.getString("city"));

                String latStr = resultSet.getString("lat");
                String lngStr = resultSet.getString("lng");

                double lat = Double.parseDouble(latStr);
                double lng = Double.parseDouble(lngStr);

                row.add(lat);
                row.add(lng);

                unorderedData.add(row);
            }

        } catch (SQLException ignored) {}

        //System.out.println(unorderedData);
        ArrayList<ArrayList<Object>> orderedData = new ArrayList<>();

        double lastLat = STARTING_CITY_LAT;
        double lastLng = STARTING_CITY_LNG;

        ArrayList<Integer> orderedRows = new ArrayList<Integer>();

        for (int i = 0; i < unorderedData.size(); i++) {
            double shortestDistance = -1;
            int shortestDistanceRowIndex = 0;
            ArrayList<Object> shortestDistanceRow = null;

            for (int j = 0; j < unorderedData.size(); j++) {
                if (orderedRows.contains(j)) continue;

                double lat = (Double) unorderedData.get(j).get(2);
                double lng = (Double) unorderedData.get(j).get(3);

                double distance = distance(lastLat, lat, lastLng, lng, 0, 0);

                //System.out.println(i + " " + unorderedData.get(j).get(0) + " " + unorderedData.get(j).get(1) + " " + distance);

                if (shortestDistance == -1 || distance < shortestDistance) {
                    shortestDistance = distance;
                    shortestDistanceRowIndex = j;
                    shortestDistanceRow = unorderedData.get(j);
                }
            }


            orderedData.add(shortestDistanceRow);
            orderedRows.add(shortestDistanceRowIndex);
        }

        //System.out.println(orderedData);
        return orderedData;
    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbDone) {

            for(int i=0;i<jtaTable.getModel().getRowCount();i++) {
                if ((Boolean) jtaTable.getModel().getValueAt(i, 0)) {
                    String orderId = (String) jtaTable.getModel().getValueAt(i, 1);

                    String query = "UPDATE orders SET shipment_date = NOW() WHERE id =" + " '" + orderId + "'";
                    db.execute(query, true);
                }
            }

            JPanel homePageDeliverer = new HomePageDeliverer(card, cards, account);
            cards.add(homePageDeliverer, "homePageDeliverer");
            card.show(cards, "homePageDeliverer");
        } else if (e.getSource() == jbCancel) {
            card.show(cards, "homePageDeliverer");
        }
    }
}
