package com.finntech.scamcontrol;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.GraphDatabaseAPI;
import org.neo4j.server.WrappingNeoServerBootstrapper;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ServerConfigurator;

public class Application {

    public static void main(String[] args) throws Exception {
        GraphDatabaseAPI graphDatabaseService = (GraphDatabaseAPI) new GraphDatabaseFactory().newEmbeddedDatabaseBuilder("build/graphdb").newGraphDatabase();
        ServerConfigurator config = new ServerConfigurator(graphDatabaseService);
        config.configuration().setProperty(
                Configurator.WEBSERVER_PORT_PROPERTY_KEY, 7575);
        WrappingNeoServerBootstrapper bootstrapper = new WrappingNeoServerBootstrapper(graphDatabaseService, config);

        bootstrapper.start();

    }
}
