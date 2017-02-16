/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package alpine.persistence;

import alpine.Config;
import alpine.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.h2.tools.Server;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

/**
 * Initializes the embedded H2 database. This can be used as a configuration
 * store or as the main database for the application.
 *
 * Refer to {@link Config.Key#DATABASE_MODE} and application.properties for
 * additional details.
 *
 * @since 1.0.0
 */
public class PersistenceInitializer implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(PersistenceInitializer.class);
    private static Server dbServer;

    public void contextInitialized(ServletContextEvent event) {
        startDbServer();
    }

    public void contextDestroyed(ServletContextEvent event) {
        stopDbServer();
    }

    private void startDbServer() {
        String mode = Config.getInstance().getProperty(Config.Key.DATABASE_MODE);
        int port = Config.getInstance().getPropertyAsInt(Config.Key.DATABASE_PORT);

        if (StringUtils.isEmpty(mode) || !(mode.equals("server") || mode.equals("embedded"))) {
            logger.error("Database mode not specified. Expected values are 'server' or 'embedded'");
        }

        if (dbServer != null || mode.equals("embedded")) {
            return;
        }
        String[] args = new String[]{
                "-tcp",
                "-tcpPort", String.valueOf(port),
                "-tcpAllowOthers"
        };
        try {
            logger.info("Attempting to start database service");
            dbServer = Server.createTcpServer(args).start();
            logger.info("Database service started");
        } catch (SQLException e) {
            logger.error("Unable to start database service: " + e.getMessage());
            stopDbServer();
        }
    }

    private void stopDbServer() {
        logger.info("Shutting down database service");
        if (dbServer != null) {
            dbServer.stop();
            dbServer.shutdown();
        }
    }

}