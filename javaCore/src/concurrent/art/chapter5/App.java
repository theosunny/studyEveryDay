package concurrent.art.chapter5;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>(32);
        for (Map.Entry entry:map.entrySet()){
            entry.getValue();
        }
    }
}
