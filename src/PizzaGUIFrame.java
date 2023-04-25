import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class PizzaGUIFrame extends JFrame {
    JPanel mainPnl, pizzaPnl, textPnl, buttonPnl, crustPnl, sizePnl, topinsPnl;
    JButton quitBtn, clearBtn, OrderBtn, pizzaBtn;
    JTextArea reciptTA;
    JScrollPane reciptPane;
    ButtonGroup crusts;
    JRadioButton thin, reg, deepdish;
    JComboBox size;
    JCheckBox pepperoni, sausage, mushrooms, olives, pineapple, ham;
    private ArrayList<String> topins = new ArrayList<String>();
    private String[] sizes;
    private String crustType;
    private String pizzaSize;
    private double pizzaSizeCost;

    public PizzaGUIFrame() {
        createGUI();
        setTitle("PizzaGUIFrame");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI() {
        mainPnl = new JPanel();
        pizzaPnl = new JPanel();
        textPnl = new JPanel();
        buttonPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(pizzaPnl, BorderLayout.NORTH);
        mainPnl.add(textPnl, BorderLayout.CENTER);
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();
    }

    private void createTopPnl() {
//pizza crusts
        crustPnl = new JPanel();
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Crust"));
        crustPnl.setLayout(new GridLayout(3, 1));
        crustPnl.setPreferredSize(new Dimension(150, 170));

        crusts = new ButtonGroup();
        thin = new JRadioButton("Thin");
        reg = new JRadioButton("Regular");
        deepdish = new JRadioButton("Deep-Dish");

        crusts.add(thin);
        crusts.add(reg);
        crusts.add(deepdish);
        crustPnl.add(thin);
        crustPnl.add(reg);
        crustPnl.add(deepdish);

        pizzaPnl.add(crustPnl, BorderLayout.WEST);


//pizza sizes
        sizePnl = new JPanel();
        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));
        sizes = new String[]{"Small", "Medium", "Large", "Super"};
        size = new JComboBox(sizes);
        sizePnl.setPreferredSize(new Dimension(150, 170));

        sizePnl.add(size);
        pizzaPnl.add(sizePnl, BorderLayout.CENTER);



//pizza toppings
        topinsPnl = new JPanel();
        topinsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Toppings"));
        topinsPnl.setLayout(new GridLayout(6,1));
        topinsPnl.setPreferredSize(new Dimension(150, 170));

        pepperoni = new JCheckBox("Pepperoni + $1.00");
        sausage = new JCheckBox("Sausage + $1.00");
        mushrooms = new JCheckBox("Mushrooms + $1.00");
        olives = new JCheckBox("Olives + $1.00");
        pineapple = new JCheckBox("Pineapple + $1.00");
        ham = new JCheckBox("Ham + $1.00");

        topinsPnl.add(pepperoni);
        topinsPnl.add(sausage);
        topinsPnl.add(mushrooms);
        topinsPnl.add(olives);
        topinsPnl.add(pineapple);
        topinsPnl.add(ham);

        pizzaPnl.add(topinsPnl, BorderLayout.EAST);
    }

    private void createCenterPnl() {
        reciptTA = new JTextArea(15, 30);
        reciptPane = new JScrollPane(reciptTA);

        textPnl.setPreferredSize(new Dimension(2000, 2000));
        textPnl.setBorder(new TitledBorder(new EtchedBorder(), "Recipt Screen"));
        textPnl.add(reciptPane);

    }

    private void createBottomPnl() {
        //Crust Type Buttons
        thin.addActionListener((ActionEvent ae) -> {
            if (thin.isSelected())
                crustType = "Thin Crust";
        });
        reg.addActionListener((ActionEvent ae) -> {
            if (reg.isSelected())
                crustType = "Regular Crust";
        });
        deepdish.addActionListener((ActionEvent ae) -> {
            if (deepdish.isSelected())
                crustType = "DeepDish Crust";
        });

        //Pizza Size Button
        size.addActionListener((ActionEvent ae) -> {
            pizzaSizeCost = 0;
            switch(String.valueOf(size.getSelectedItem())) {
                case "Small":
                    pizzaSize = "Small";
                    pizzaSizeCost = 8.00;
                    break;
                case "Medium":
                    pizzaSize = "Medium";
                    pizzaSizeCost = 12.00;
                    break;
                case "Large":
                    pizzaSize = "Large";
                    pizzaSizeCost = 16.00;
                    break;
                case "Super":
                    pizzaSize = "Super";
                    pizzaSizeCost = 20.00;
                    break;
            }
        });

        //Pizza Toppings Buttons
        pepperoni.addActionListener((ActionEvent ae) -> {
            if (pepperoni.isSelected())
                topins.add("Pepperoni                                              ");
        });
        sausage.addActionListener((ActionEvent ae) -> {
            if (sausage.isSelected())
                topins.add("Sausage                                                ");
        });
        mushrooms.addActionListener((ActionEvent ae) -> {
            if (mushrooms.isSelected())
                topins.add("Mushrooms                                           ");
        });
        olives.addActionListener((ActionEvent ae) -> {
            if (olives.isSelected())
                topins.add("Olives                                                      ");
        });
        pineapple.addActionListener((ActionEvent ae) -> {
            if (pineapple.isSelected())
                topins.add("Pineapple                                               ");
        });
        ham.addActionListener((ActionEvent ae) -> {
            if (ham.isSelected())
                topins.add("Ham                                                        ");
        });





        //Button Panel Buttons
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> {
            reciptTA.setText("");
        });

        OrderBtn = new JButton("Order");
        OrderBtn.addActionListener((ActionEvent ae) -> {
           recipt();
        });

        buttonPnl.setBorder(new TitledBorder(new EtchedBorder(), "Button Panel"));
        buttonPnl.setPreferredSize(new Dimension(100, 100));
        buttonPnl.setLayout(new GridLayout(1, 3));
        buttonPnl.add(quitBtn);
        buttonPnl.add(clearBtn);
        buttonPnl.add(OrderBtn);
    }


    private void recipt()
    {
        double cost = pizzaSizeCost + topins.size();
        double tax = cost * .07;
        double total = cost + tax;
        DecimalFormat money = new DecimalFormat("0.00");

        reciptTA.append("==============================================\n");
        reciptTA.append("Pizza Size:  " + pizzaSize + " \nCrust:  " + crustType + "\n");
        reciptTA.append("\n");
        reciptTA.append("Extra Toppings:\n");
        for (String Topping: topins)
        {
            reciptTA.append(Topping);
            reciptTA.append("$  1.00\n");
        }
        reciptTA.append("\n");
        reciptTA.append("\n");
        reciptTA.append("SubTotal:                                               $ " + money.format(cost) + "\n");
        reciptTA.append("Tax:                                                         $ " + money.format(tax) + "\n");
        reciptTA.append("--------------------------------------------------------------------------------\n");
        reciptTA.append("Total:                                                      $ " + money.format(total) + "\n");
        reciptTA.append("==============================================\n");
        topins.clear();

    }


}
