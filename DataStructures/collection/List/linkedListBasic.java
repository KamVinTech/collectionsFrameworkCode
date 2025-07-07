package DataStructures.collection.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class linkedListBasic{

    private static final String result_file="LinkedList-output.txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;


    public static void performLinkedListOperations(){

        LinkedList<String> linkedlist= new LinkedList<>();
        try(PrintWriter out= new PrintWriter(new FileWriter(result_file,true))
        ){
             java.util.function.Consumer<String> log= s ->{
                out.println(s);
                if(ALSO_ECHO_ON_CONSOLE){
                    System.out.println(s);
                }
            };
            log.accept("====LinkedList Operations started====");

            linkedlist.add("Renault");
            linkedlist.add("Ford");
            linkedlist.add("Aston Martin");
            linkedlist.add("Mercedes");
            linkedlist.add("BMW");
            
            log.accept("Initial LinkedList: " + linkedlist);

            linkedlist.addFirst("Kia");
            linkedlist.addLast("BYD");

            log.accept("List after Adding elements to first and last place: " + linkedlist);

            linkedlist.removeFirst();
            linkedlist.removeLast();

            log.accept("List after removing elements from first and last place: " + linkedlist);

            log.accept("Element at index 1 : " + linkedlist.get(1));

            log.accept("Iterating through LinkedList: ");
            for(String cars: linkedlist){
                log.accept(cars);
            }
            log.accept("====End of LinkedList Operations====");

        } catch (IOException e) {
            System.err.println("File writing issue :" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        performLinkedListOperations();
    }
    

}