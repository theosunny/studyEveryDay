package chapter03.abstractDemo;

public class ma {
    public static void main(String[] args){
        AbstractClass impl = new ImplClass();
        impl.lock();
    }
}
