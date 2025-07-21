package log;

import java.util.logging.*;
import java.io.IOException;
import java.io.*;

public class LogIO {
    private static final Logger logger = Logger.getLogger(LogIO.class.getName());

    public static void main(String[] args) {
        try{
            FileHandler fileHandler = new FileHandler("logs/logIOInfo.log", true);

            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("logs/logIOInfo.log", true))){
                logger.info("Olá");
                logger.warning("Erro!");
                logger.severe("Erro Fatal!");
                fileWriter.newLine();
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
