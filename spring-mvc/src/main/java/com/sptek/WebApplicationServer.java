package com.sptek;

import org.junit.platform.commons.logging.LoggerFactory;

import java.io.File;
import java.util.logging.Logger;

public class WebApplicationServer {

    private static final Logger log = (Logger) LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception{
        Tomcat tomcat = new Tomcat();
        String webappDirLocation = "webapp/";
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsoluteFile());
        log.info("configuration app with baseDir : {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}