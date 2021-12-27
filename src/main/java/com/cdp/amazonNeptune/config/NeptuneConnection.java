package com.cdp.amazonNeptune.config;


import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.driver.ser.Serializers;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;


@Configuration
public class NeptuneConnection {

    @Bean
    public Cluster cluster() {
        return Cluster.build()
                .addContactPoint("cdp1-instance-1.cqugljcslroz.us-east-1.neptune.amazonaws.com")
                .port(8182)
                .enableSsl(true)
                .serializer(Serializers.GRAPHBINARY_V1D0)
                .create();
    }

    @Bean
    public GraphTraversalSource g(Cluster cluster) {
        return traversal().withRemote(DriverRemoteConnection.using(cluster));
    }
}
