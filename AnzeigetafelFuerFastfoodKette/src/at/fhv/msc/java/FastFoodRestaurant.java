package at.fhv.msc.java;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class FastFoodRestaurant {
    private Frame _mainFrame;
    private Panel _itemPanel;
    private Label _statusLabel;
    private Frame _availabilityFrame;
    
    public FastFoodRestaurant() {
        prepareGUI();
    }
    
    private void prepareGUI() {

        _mainFrame = new Frame("Fast Food Restaurant");
        _mainFrame.setSize(400, 300);
        _mainFrame.setLayout(new GridLayout(2, 1));
        
        _itemPanel = new Panel();
        _itemPanel.setLayout(new FlowLayout());

        Button item1 = new Button("Burger");
        item1.addActionListener(new ItemButtonListener("Burger"));
        _itemPanel.add(item1);
        
        Button item2 = new Button("Drink");
        item2.addActionListener(new ItemButtonListener("Drink"));
        _itemPanel.add(item2);

        _mainFrame.add(_itemPanel);

        _statusLabel = new Label("Please choose an item.");
        _mainFrame.add(_statusLabel);

        _mainFrame.setVisible(true);
    }
    
    private class ItemButtonListener implements ActionListener {
        private String _itemName;
        private ExecutorService _executor;
        
        public ItemButtonListener(String itemName) {
            _itemName = itemName;
            _executor = Executors.newSingleThreadExecutor();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            _executor.execute(new ItemAvailabilityChecker(_itemName));
        }
    }
    
    private class ItemAvailabilityChecker implements Runnable {
        private String _itemName;
        
        public ItemAvailabilityChecker(String itemName) {
            this._itemName = itemName;
        }
        
        @Override
        public void run() {
        	
            try {
                boolean itemAvailable = checkItemAvailability(_itemName);
                
                if (itemAvailable == true) {
                    updateStatusLabel("Selected item: " + _itemName);

                } else {
                    String number = generateNumber();
                    updateStatusLabel(_itemName + " currently not available. Your pickup-number is " + number);
                    
                    _availabilityFrame = new Frame("Item Availability");
                    _availabilityFrame.setSize(300, 200);
                    _availabilityFrame.setLayout(new FlowLayout());
                    
                    Thread.sleep(2000);
                    
                    Label availabilityLabel = new Label(_itemName + " is now available.");
                    _availabilityFrame.add(availabilityLabel);
                    Label numberLabel = new Label("Your pickup-number: " + number);
                    _availabilityFrame.add(numberLabel);
                    _availabilityFrame.setVisible(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        private boolean checkItemAvailability(String itemName) {
            if (itemName.equals("Drink")) {
                return false;
            }
            
            return true;
        }
        
        private String generateNumber() {
            return String.valueOf(ThreadLocalRandom.current().nextInt(100));
        }
        
        private void updateStatusLabel(String text) {
            _statusLabel.setText(text);
        }
    }
    
    public static void main(String[] args) {
        new FastFoodRestaurant();
    }
}
