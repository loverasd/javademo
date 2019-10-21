package com.note.design_patterns.behavioral.chain_of_responsibility;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

/**
 * @Classname MyLogger
 * @Date 2019/10/18 9:59 上午
 * @Created by chenpan
 * @Description 日志工具
 */
@FunctionalInterface
public interface MyLogger {
    public enum Level{
        A,B,C,D,E,F;
        public Level[] all(){
            return values();
        }
    }
   public void message(String msg, Level level);

    default MyLogger appendNext(MyLogger nextMyLogger) {
        return ((msg, level) -> {
            message(msg, level);
            nextMyLogger.message(msg,level);
        });
    }

    default MyLogger log(Level[] levels, Consumer<String> consumer) {
        EnumSet enumSet = EnumSet.copyOf(Arrays.asList(levels));
        return ((msg, level) -> {
            if (enumSet.contains(level)){
                consumer.accept(msg);
            }
        });
    }

}
