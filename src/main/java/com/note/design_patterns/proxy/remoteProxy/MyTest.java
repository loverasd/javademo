package com.note.design_patterns.proxy.remoteProxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-05-16 19:46
 **/
public class MyTest {
    public static void main(String[] args) {
        new MyTest().go();
    }
    public void go(){
        try {
            MyRemote lookup =(MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            lookup.sayHello();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}