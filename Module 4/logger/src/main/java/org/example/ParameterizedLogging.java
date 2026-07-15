package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {

        String username = "Alice";
        int age = 25;
        double salary = 45000.50;

        logger.info("User {} logged in successfully.", username);

        logger.info("User {} is {} years old.", username, age);

        logger.debug("User {} has salary {}.", username, salary);

        logger.warn("User {} attempted invalid login {} times.", username, 3);

        logger.error("Error processing account for user {}.", username);
    }
}