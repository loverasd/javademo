package test1;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-23 15:01
 **/
public class A{
    String name ;

    boolean isA;

    public A(String name, boolean isA) {
        this.name = name;
        this.isA = isA;
        try {
            this.isA=true;
            init();
        } catch (Exception e) {
            this.isA=false;
            e.printStackTrace();
        }

    }
    void init() throws Exception{
        this.name ="a";
        throw  new Exception("1231231");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A() {
        this.name = "1231";
        this.setName("nihao");
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", isA=" + isA +
                '}';
    }

    public static void main(String[] args) {
        A a = new A("b",true);
        System.out.println(a.toString());
    }
}