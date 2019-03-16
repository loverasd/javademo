package com.note.lambda.lambda;


/**
 * @program: javademo
 * @description: lambda表达式
 * @author: chenp
 * @create: 2018-08-28 11:51
 **/
public class Testlambda {

    public static void main(String[] args) {
        assert isTrue();
        System.out.println("ni hao");
//        ConcurrentGreeter c = new ConcurrentGreeter();
//        c.greet();
//        System.out.println("/ ");

  }
  public static boolean isTrue(){
      for (int i=0; i <10; i++){
          if (i == 18){
              return true;
          }
      }
      return false;
  }
}
class ConcurrentGreeter extends Greeter{
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
        System.out.println("------");
        Thread t2 = new Thread(()->super.greet());
        t2.start();
        System.out.println("------");

    }
}
class Greeter{
    public void greet() {
        System.out.println("hello,world");
    }
}