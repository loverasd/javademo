package com.note.design_patterns.behavioral.chain_of_responsibility;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

/**
 * @Classname Logger
 * @Date 2019/10/17 3:23 下午
 * @Created by chenpan
 * @Description
 */
@FunctionalInterface
public interface ChainLogger {
    public enum LoggerLevel {
        INFO, DEBUG, WANING, ERROR;

        public static LoggerLevel[] all() {
            return values();
        }
    }

    abstract void message(String msg, LoggerLevel severity);

    default ChainLogger appendNext(ChainLogger nextChainLogger) {//日志对象链
        return ((msg, severity) -> {
            message(msg, severity);
            nextChainLogger.message(msg, severity);
        });
    }

    /**
     * 打印日志方法
     *
     * @param levels
     * @return
     */
    static ChainLogger log(LoggerLevel[] levels, Consumer<String> writeMsg) {
        int i=0 ;
        EnumSet<LoggerLevel> loggerLevels = EnumSet.copyOf(Arrays.asList(levels));
        return ((msg, severity) -> {
            System.out.println(loggerLevels.toString());
            if (loggerLevels.contains(severity)) {
                System.out.println(severity + "2");
                writeMsg.accept(msg);
            }
        });
    }

    static ChainLogger consoleLog(LoggerLevel... levels) {
        return log(levels, msg -> System.err.println("writing to console: " + msg));
    }

    static ChainLogger fileLog(LoggerLevel... levels) {
        return log(levels, msg -> System.err.print("writing to file: " + msg));
    }

    static ChainLogger mailLog(LoggerLevel... levels) {
        return log(levels, msg -> System.err.println("sending mail: " + msg));
    }

    public static void main(String[] args) {
        ChainLogger consoleLog = consoleLog(LoggerLevel.INFO);
        ChainLogger chainLogger = consoleLog.appendNext(fileLog(LoggerLevel.WANING)).appendNext(mailLog(LoggerLevel.ERROR));

        chainLogger.message("test2",LoggerLevel.ERROR);
    }
}
