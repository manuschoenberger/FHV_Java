package at.fhv.msc.java;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class FastFoodRestaurant {
    private Frame mainFrame;
    private Panel itemPanel;
    private Label statusLabel;
    
    public FastFoodRestaurant() {
        prepareGUI();
    }
    
    private void prepareGUI() {
        // Create the main frame
        mainFrame = new Frame("Fast Food Restaurant");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(2, 1));
        
        // Create the item panel
        itemPanel = new Panel();
        itemPanel.setLayout(new FlowLayout());
        
        // Add food items as buttons
        Button item1 = new Button("Item 1");
        item1.addActionListener(new ItemButtonListener("Item 1"));
        itemPanel.add(item1);
        
        Button item2 = new Button("Item 2");
        item2.addActionListener(new ItemButtonListener("Item 2"));
        itemPanel.add(item2);
        
        // Add the item panel to the main frame
        mainFrame.add(itemPanel);
        
        // Create the status label
        statusLabel = new Label("Please choose an item.");
        mainFrame.add(statusLabel);
        
        // Set the main frame visibility
        mainFrame.setVisible(true);
    }
    
    private class ItemButtonListener implements ActionListener {
        private String itemName;
        
        public ItemButtonListener(String itemName) {
            this.itemName = itemName;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try (
                // Create client socket and input/output streams
                Socket clientSocket = new Socket("localhost", 9999);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            ) {
                // Send item name to server
                out.println(itemName);
                
                // Receive response from server
                String response = in.readLine();
                
                // Process server response
                if (response.equals("AVAILABLE")) {
                    updateStatusLabel("Selected item: " + itemName);
                } else if (response.startsWith("NOT_AVAILABLE:")) {
                    String number = response.substring("NOT_AVAILABLE:".length());
                    updateStatusLabel("Item not available. Your number: " + number);
                }
                
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void updateStatusLabel(String text) {
        // Update the status label on the main frame
        statusLabel.setText(text);
    }
    
    public static void main(String[] args) {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
    }
}
