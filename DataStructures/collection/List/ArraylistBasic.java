package DataStructures.collection.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArraylistBasic {

    public static final String result_File="arrayList-output-txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;

    public static void arrayListOperations(){
        List<String> aList= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
       
        try(
            PrintWriter out= new PrintWriter(new FileWriter(result_File,true))
            ){
                java.util.function.Consumer<String> log =s ->{
                    out.println(s);
                    if(ALSO_ECHO_ON_CONSOLE)
                    {
                        System.out.println(s);
                    }
                };
                log.accept("====Starting ArrayList Operations====");

    
       
        aList.add("Computer Science");
        aList.add("Electrical");
        aList.add("Electronics");
        aList.add("Mechanical");
        aList.add("Civil");
        aList.add("Aeronautics");
        log.accept("Initial List: " + aList);

        aList.add(1,"Robotics");
        log.accept("After Inserting 'Robotics' at index 1 :" + aList);

        aList.remove("Electrical");
        log.accept("After removing 'electrical' : " +aList);

        aList.set(2,"Chemical");
        log.accept("After updating index 2 to 'Chemical' : " + aList);

        log.accept("Searching for an Element: ");
        String Search= sc.nextLine();
        if(aList.contains(Search)){
            log.accept(Search + " is present at Index " + aList.indexOf(Search));
        }
        else{
            log.accept(Search + "is not in the list.");
        }

        log.accept("Iterating using the for-each loop: ");
        for(String engg:aList){
            log.accept(engg);
        }

        Collections.sort(aList);
        log.accept("Sorted List : " + aList);
        
        log.accept("====End of Operations====\n");

    } catch (IOException e) {
        System.err.println("File Writing Error: "+ e.getMessage());
    }finally{
        sc.close();
    }
        
    }
    public static void main(String[] args) {
        arrayListOperations();


    }


}
