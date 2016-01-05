package fr.mleduc.docker.kevoree.gateway;

import org.KevoreeModel;
import org.kevoree.modeling.KCallback;
import org.kevoree.modeling.cdn.KContentDeliveryDriver;
import org.kevoree.modeling.drivers.mongodb.MongoDbContentDeliveryDriver;
import org.kevoree.modeling.memory.manager.DataManagerBuilder;
import org.kevoree.modeling.plugin.WebSocketGateway;

import java.net.UnknownHostException;

/**
 * Created by mleduc on 04/01/16.
 */
public class Startup {
    public static void main(String[] args) throws UnknownHostException {
        final KContentDeliveryDriver cdn = new MongoDbContentDeliveryDriver("localhost", 27017, System.getenv("DATABASE"));
        WebSocketGateway wsGateway = WebSocketGateway.expose(cdn, 8888);
        wsGateway.start();
    }
}
