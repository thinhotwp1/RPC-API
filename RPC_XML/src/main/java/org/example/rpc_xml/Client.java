package org.example.rpc_xml;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;

public class Client {
    public static void main(String[] args) {
        try {
            // Config client call server
            XmlRpcClient client = new XmlRpcClient();
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
            client.setConfig(config);

            // Call RPC server
            Object[] params = new Object[]{5, 10};
            int sum = (int) client.execute("Calculator.sum", params);
            System.out.println("Sum: " + sum);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
