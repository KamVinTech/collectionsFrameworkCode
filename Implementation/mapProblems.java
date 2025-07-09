package Implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapProblems {

    private static final String result_File="mapImplementation.txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;

    public static void performMapImplementation(){

        Map<Integer, Integer> num= new HashMap<>();

        try(PrintWriter out= new PrintWriter(new FileWriter(result_File,false))
        ){
            java.util.function.Consumer<String> log= s->{
                out.println(s);
                if (ALSO_ECHO_ON_CONSOLE) {
                    System.out.println(s);
                }
            };
            /*
             * 1. Basic Map Operations

                1. Create a HashMap<Integer, String> and insert 5 key-value pairs.
                2. Retrieve the value for a given key.
                3. Update the value of an existing key.
                4. Remove a key-value pair by key.
                5. Check if a key or value exists in the map.
                6. Print the size of the map.
                7. Iterate through the map using:
                    a. keySet()
                    b. entrySet()
                    c. values()
             */
            log.accept("=====Map Operation Implementation Started=====");

            num.put(1,1);
            num.put(2,3);
            num.put(3,5);
            num.put(4,7);
            num.put(5,11);
            log.accept("Prime Number's map after adding 5 K-V pair:" + num);

            //2. finding the value of a given key.
            Integer key= 3;
            Integer val= num.get(key);

            log.accept("Given Key has the Value: " + val);

            //3. Update the value of an existing key.
            num.put(2, 13);
            log.accept("Updated value for 'Key: 2' is: " +num);

            //4. Checking the key or the value present in the map.
            int presKey=4;
            if(num.containsKey(presKey)){
                log.accept("the key '4' is present in the map.");
            }else{
                log.accept("the key '4' not present in the map.");
            }
            int presVal=17;
            if(num.containsValue(presVal)){
               log.accept("the value '17' is present in the map."); 
            }else{
                log.accept("the value '17' not present in the map.");
            }

            //6. Printing the size of the map.

           log.accept("the size of the Map is: " + num.size());

           //7. Iterating through map.
           for(Map.Entry<Integer,Integer> entry:num.entrySet()){
            log.accept("Key :" +entry.getKey() + ", Value :" + entry.getValue());
           }


           //7. Sorting the map by ascending order.

           Map<Integer,Integer> sortedMap=new TreeMap<>(num);
           log.accept("Sorted map with key-values in ASC order: ");
           for(Map.Entry<Integer,Integer> entry: sortedMap.entrySet()){
            log.accept("Key:" + entry.getKey() + ", Value: " + entry.getValue());
           }

        } catch (IOException e) {
            System.err.println("File writing issue: "+e.getMessage());
        }


    }
    public static void main(String[] args) {
        performMapImplementation();
    }

}
