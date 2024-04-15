package at.fhv.msc.java;

import java.io.*;
import java.net.*;
import java.util.concurrent.ThreadLocalRandom;

public class FastFoodServer {
    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(9999);
            
            System.out.println("Server started. Waiting for connections...");
            
            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                
                // Create new thread for each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        
        @Override
        public void run() {
            try (
                // Create input/output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            ) {
                String itemName = in.readLine();
                
                // Simulate item availability check
                boolean itemAvailable = checkItemAvailability(itemName);
                if (itemAvailable) {
                    out.println("AVAILABLE");
                } else {
                    String number = generateNumber();
                    out.println("NOT_AVAILABLE:" + number);
                }
                
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private boolean checkItemAvailability(String itemName) {
            // Implement your item availability check logic here
            // For demonstration purposes, assume item 2 is not available
            if (itemName.equals("Item 2")) {
                return false;
            }
            return true;
        }
        
        private String generateNumber() {
            // Implement your number generation logic here
            // For simplicity, let's generate a random number
            return String.valueOf(ThreadLocalRandom.current().nextInt(100));
        }
    }
}
