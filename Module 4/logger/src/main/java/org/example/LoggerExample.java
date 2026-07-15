package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String[] args) {

        logger.error("This is an error message");
        logger.warn("This is a warning message");

    }
}