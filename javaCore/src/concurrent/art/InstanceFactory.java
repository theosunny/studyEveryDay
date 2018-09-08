package concurrent.art;




public class InstanceFactory {
    public static class InstanceHolder{
        public static Instance instance = new Instance();
    }
    public static  Instance getInstance(){
        return  InstanceHolder.instance;
    }
}


class volatileSigton{

    private  volatile  static  Instance instance;

    public static Instance getInstance() {
        if (instance==null){
            synchronized (volatileSigton.class){
                if (instance==null){
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}