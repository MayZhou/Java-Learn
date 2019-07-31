package com.mayzhou.internet.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author MayZhou
 */
public class InetAddressTest {
    public static void main(String[] args) {
        if (args.length>0){
            for (String arg : args) {
                System.out.println(arg);
            }

            String host = args[0];

            InetAddress[] addresses = new InetAddress[0];
            try {
                addresses = InetAddress.getAllByName(host);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        }
        else {
            try {
                InetAddress localHOstAddress = InetAddress.getLocalHost();
                System.out.println(localHOstAddress);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
