package DataStructures.collection.Map;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hashmapBasic {


    private static final String result_File= "Hashmap-output.txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;

    public static void performMapOperations(){

        Map<Integer,String> cityMap= new HashMap<>();
        Scanner sc= new Scanner(System.in);

        try(PrintWriter out= new PrintWriter(new FileWriter(result_File,false))
        ){
            java.util.function.Consumer<String> log= s -> {
                out.println(s);
                if (ALSO_ECHO_ON_CONSOLE) {
                    System.out.println(s);
                }
            };
                log.accept("Initiating map operations: ");
                cityMap.put(1, "Delhi");
                cityMap.put(2, "Dehradun");
                cityMap.put(3, "Sonipat");
                cityMap.put(4, "Shimla");
                cityMap.put(5, "Manali");
                cityMap.put(6, "Chandigarh");
                log.accept("Initial CityMap: " + cityMap);

                log.accept("Enter a Key:");
                int pos= sc.nextInt();
                sc.nextLine();
                log.accept("Enter the city name:");
                String newCity= sc.nextLine();

                cityMap.put(pos, newCity);
                
                log.accept("Map After Adding new item: " + cityMap);

                log.accept("Enter the position to search the city: ");
                int SearchKey= sc.nextInt();
                if(cityMap.containsKey(SearchKey)){
                    log.accept(SearchKey + " -> " + cityMap.get(SearchKey));
                }
                else{
                    log.accept(SearchKey  + " Not found.");
                }
                log.accept("Enter the Key to remove:");
                int keyToRemove= sc.nextInt();
                cityMap.remove(keyToRemove);
                log.accept("Map after removing key:" + cityMap);

                log.accept("Iterating through Map:");
                for(Map.Entry<Integer,String> entry: cityMap.entrySet()){
                    log.accept(entry.getKey() + " -> " + entry.getValue());
                }
                log.accept("====End of HashMap Operations====");

            } catch (IOException e) {
                System.err.println("error writing file:" + e.getMessage());
            }
        }


        public static void main(String[] args) {
            performMapOperations();
        }
    }

