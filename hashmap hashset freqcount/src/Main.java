import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> names=new HashSet<>();
        names.add("k");
        names.add("m");
        names.add("ki");
        names.remove("k");

        for(String i:names){
            System.out.println(i+" ");
        }

        Map<String,String > phom=new HashMap<>();
        phom.put("ee","09090909");
        phom.put("ke","09090999");
        Set<String> values=phom.keySet();
        for(String i:values){
            System.out.println(i+" "+phom.get(i));
        }
        Set<Map.Entry<String,String>> val=phom.entrySet();
        for(Map.Entry<String,String> i :val){
            System.out.println(i.getKey()+" "+i.getValue());
        }

    }
}