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
    public static void main(String[] args) {
        try {
            final KContentDeliveryDriver cdn = new MongoDbContentDeliveryDriver("mongo", 27017, System.getenv("DATABASE"));
            final KevoreeModel dynamicMM = new KevoreeModel(DataManagerBuilder.create().withContentDeliveryDriver(cdn).build());
            dynamicMM.connect(new KCallback() {
                public void on(Object o) {
                    WebSocketGateway wsGateway = WebSocketGateway.expose(cdn, 8888);
                    wsGateway.start();
                }
            });
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}