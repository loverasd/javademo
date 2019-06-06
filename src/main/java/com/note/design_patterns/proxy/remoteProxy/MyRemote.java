package com.note.design_patterns.proxy.remoteProxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @program: demo
 * @description: 远程接口
 * @author: chenp
 * @create: 2019-05-16 19:36
 **/
public interface MyRemote extends Remote {
    /**
     * 若是自定义的返回类型必须是可序列化的
     * @return
     * @throws RemoteException
     */
    public String sayHello() throws RemoteException;

}