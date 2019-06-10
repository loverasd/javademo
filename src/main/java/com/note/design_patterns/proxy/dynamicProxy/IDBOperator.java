package com.note.design_patterns.proxy.dynamicProxy;

import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * @Classname IDBOperator
 * @Description TODO
 * @Date 2019/6/10 17:56
 * @Created by x1c
 */
public interface IDBOperator {

    ArrayList<Object> request() throws InterruptedException;

}
