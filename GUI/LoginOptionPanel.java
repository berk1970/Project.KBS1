package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginOptionPanel extends JPanel implements ActionListener {

    private CardLayout card;
    private JPanel cards;
    private JButton jbDeliverer, jbCustomer;
    public LoginOptionPanel(CardLayout card, JPanel cards) throws IOException {
        this.card = card;
        this.cards = cards;

        setLayout(new GridLayout(0, 1));

        jbDeliverer = new JButton("als bezorger");
        jbCustomer = new JButton("als klant");

        jbDeliverer.setPreferredSize(new Dimension(200, 60));
        jbCustomer.setPreferredSize(new Dimension(200, 60));

        jbDeliverer.addActionListener(this);
        jbCustomer.addActionListener(this);

        JLabel jlInloggen = new JLabel("Inloggen");
        jlInloggen.setHorizontalAlignment(SwingConstants.CENTER);
        jlInloggen.setFont(new Font("Calibri", Font.BOLD, 40));

        BufferedImage myPicture = ImageIO.read(new File("images/delivery_truck.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(200, 200, Image.SCALE_FAST)));

        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.add(jbDeliverer);
        jPanel.add(jbCustomer);

        add(picLabel);
        add(jlInloggen);
        add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbDeliverer) {
            card.show(cards, "loginPanelDeliverer");
        } else if (e.getSource() == jbCustomer) {
            card.show(cards, "loginPanelCustomer");
        }
    }
}
