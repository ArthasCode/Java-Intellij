package APIs_minhas;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class LoggerProxy {
    private static final Map<String, Logger> loggers = new HashMap<>();

    private LoggerProxy(){}

    public static void registrarLogInfo(String message, String className){
        try {
        Logger logger = getLogger(Level.INFO, className);
        logger.info(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Logger getLogger(Level level, String name)  throws IOException {
        if(loggers.containsKey(name))
            return loggers.get(name);

        String path = "logs/" + name.replace('.', '/') + ".log";
        new File(path).getParentFile().mkdirs();

        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(path,true);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new IOException("Erro na criação do arquivo: " + e);
        }


        Logger logger = inciarLogger(level, fileHandler, name);
        loggers.put(name, logger);
        return logger;
    }

    private static Logger inciarLogger(Level level, FileHandler fileHandler, String name){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());

        Logger logger = Logger.getLogger(name);
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.setLevel(level);
        logger.setUseParentHandlers(false);

        return logger;
    }

    public static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord logRecord) {
            return String.format("[%s] [%s] %s - %s%n",
                    logRecord.getLevel(),
                    logRecord.getLoggerName(),
                    logRecord.getSourceClassName(),
                    logRecord.getMessage());
        }
    }
}
