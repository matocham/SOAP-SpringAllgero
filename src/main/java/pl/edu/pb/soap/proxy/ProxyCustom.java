package pl.edu.pb.soap.proxy;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mateusz on 23.04.2017.
 */
public class ProxyCustom extends ProxySelector {
    @Override
    public List<Proxy> select(URI uri) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost",4040));
        return Arrays.asList(proxy);
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Connection to "+uri+" failed");
    }
}
