package com.example.demo.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyWebServer;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JettyConfig  {
    @Value("${jetty.requests.logging.enabled}")
    private Boolean logEnabled = false;

    @Value("${jetty.requests.graceful.shutdown.time}")
    private Integer jettyRequestsGracefulShutdownTime;

    @Value("${jetty.threads.max:500}")
    private Integer jettyThreadsMax;

    @Bean
    public JettyServletWebServerFactory embeddedServletContainerFactory() {
        JettyServletWebServerFactory webServer = new JettyServletWebServerFactory() {
            @Override
            protected JettyWebServer getJettyWebServer(Server server) {
                StatisticsHandler handler = new StatisticsHandler();
                handler.setHandler(server.getHandler());
                server.setHandler(handler);
                server.setStopTimeout(jettyRequestsGracefulShutdownTime);
                server.setStopAtShutdown(true);

                return super.getJettyWebServer(server);
            }
        };
        webServer.setThreadPool(new QueuedThreadPool(jettyThreadsMax));
        return webServer;
    }

    private String getTimeZone() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Z");
        return "GMT" + dateFormat.format(new Date());
    }
}
