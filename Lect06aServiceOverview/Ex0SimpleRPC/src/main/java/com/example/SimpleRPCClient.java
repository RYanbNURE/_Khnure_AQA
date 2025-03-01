package com.example;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Scanner;

public class SimpleRPCClient {
    public static void main(String[] args) throws Exception {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter method name (add/subtract/multiply/divide) or 'exit' to quit: ");
            String method = scanner.nextLine().trim();
            if (method.equalsIgnoreCase("exit")) break;

            try {
                System.out.print("Enter first number: ");
                int x = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Enter second number: ");
                int y = Integer.parseInt(scanner.nextLine().trim());

                Object[] params = new Object[]{x, y};
                Object result = client.execute("Calculator." + method, params);
                System.out.println("Result: " + result);
            } catch (XmlRpcException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");
            }
            System.out.println(); // Add a blank line for readability
        }
    }
}