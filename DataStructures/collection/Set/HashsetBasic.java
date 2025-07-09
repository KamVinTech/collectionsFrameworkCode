package DataStructures.collection.Set;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * TreeSet will maintain the sorting. As it will automatically sort the set without explicitly using the
 *  collections.sort();
 * Treeset removes duplicates and ensure uniqueness. Required when validating against expected order.
 * LinkedHashSet will maintain the Insertion order. Operations would be same as Set.
 * if you need Key-Value + Sorted by Key, then use Treemap.
 */

public class HashsetBasic {

    private static final String set_result_file="set-output.txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;

    public static void performSetOperations(){

        Set<String> set= new HashSet<>();
        Scanner sc= new Scanner(System.in);

        try(
            PrintWriter out= new PrintWriter(new FileWriter(set_result_file,true))
            ){
                java.util.function.Consumer<String> log =s -> {
                    out.println(s);
                    if (ALSO_ECHO_ON_CONSOLE)
                    {
                        System.out.println(s);
                    } 
                };
                    log.accept("====Set (HashSet) Operations====");
                     
                    set.add("Dog");
                    set.add("Cat");
                    set.add("Parrot");
                    set.add("cock");
                    set.add("cat");
                    log.accept("Initial Elements of Set : " + set);

                    log.accept("Enter an animal name to remove from the set :");
                    String toRemove= sc.nextLine();
                    if(set.remove(toRemove)){
                        log.accept(toRemove + "was removed from the set.");
                    }else{
                        log.accept(toRemove + "was not found in the set");
                    }

                    log.accept("Current Set : " + set);

                    log.accept("Enter an animal name to check whether it exists or not :");
                    String search =  sc.nextLine();
                    if(set.contains(search)){
                        log.accept(search + "Animal exist in the set.");
                    }else{
                        log.accept(search + "Animal doesn't exist in the set.");
                    }                    

                    log.accept("Iterating through set: ");
                    for(String animal:set){
                        System.out.println(animal);
                    }

                    List<String> sortedList= new ArrayList<>(set);
                    Collections.sort(sortedList);
                    log.accept("Sorted Set (Via List) :" + sortedList);
                    log.accept("====End of Operations====");

                } catch (IOException e) {
                    System.err.println("Error writing to file: " +e.getMessage());
                }finally{
                    sc.close();
                }
            }

    public static void main(String[] args) {
        performSetOperations();
    }


}
