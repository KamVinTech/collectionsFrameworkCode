package Implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class arraylistProblems {

    private static final String result_File="arrayListImplementation.txt";
    private static final boolean ALSO_ECHO_ON_CONSOLE=true;

    public static void main(String[] args) {
    
        performArrayListImplementations();

    }
    
    public static void performArrayListImplementations(){

    //1. Create an ArrayList of integers and add 10 elements (1 to 10). Print all elements.
    
    ArrayList<Integer> numbers= new ArrayList<>();

    try(PrintWriter out= new PrintWriter(new FileWriter(result_File,false))
    ){
        java.util.function.Consumer<String> log= s->{
            out.println(s);
            if (ALSO_ECHO_ON_CONSOLE) {
                System.out.println(s);
            }
        };
        log.accept("=====Arraylist Implementations and Operations=====");

        for(int i=1; i<=10; i++){
            numbers.add(i);
        }
        log.accept("initial Arraylist after adding 10 integers:" +numbers);

    //2. Insert an element at index 5.
        numbers.add(5, 7);
        log.accept("Arraylist after adding element '7' at Index '5' :" +numbers);

    
    // 3. Remove the element at index 2.
        numbers.remove(2);
        log.accept("Arraylist after removing element from Index 2: " +numbers);

    //4. Replace the element at index 3 with a new value.
        numbers.set(3, 11);
        System.out.println(numbers);
        log.accept("Arraylist after replacing the element '11' at index '3' :" +numbers);

    // 5. Retrieve the element at the last index.
        int lastItem=numbers.getLast();
        System.out.println(lastItem);

        log.accept("Element at the last Index is: "+lastItem);
    /*
     * 6. Iterate over an ArrayList using:
            a. for loop
            b. for-each loop
            c. Iterator
            d. ListIterator (reverse order)
     */
       //using Iterator (forward order) 
     Iterator<Integer> iterator= numbers.iterator();
     while (iterator.hasNext()) {
        Integer counting=iterator.next();
        log.accept("Iterating throught the arraylist elements: " +counting);
     }

     // using listIterator (Backward order)
     ListIterator<Integer> it= numbers.listIterator(numbers.size());

     while (it.hasPrevious()) {
        log.accept("Index" + it.previousIndex() + ":" + it.previous());
        
     }

     // 7. Print the size of an ArrayList before and after adding 5 elements.
     log.accept("Size of Arraylist before adding 5 new elements: "+ numbers.size());
     System.out.println("Arraylist size before adding 5 elements: " + numbers.size());
     
     for(int i=11; i<=20; i++){
        numbers.add(i);
     }

     System.out.println("Arraylist size after adding 10 elements: " + numbers.size());
     log.accept("Arraylist size after adding 10 elements: " + numbers.size());
     // 8. Trim the size of an ArrayList to its current content using `trimToSize()`.
     numbers.size();
     numbers.trimToSize();
     System.out.println(numbers);

     //9. Find the index of the first and last occurrence of a specific value.

     int target = 11;

     int firstOccurence= numbers.indexOf(target);
     int lastOccurence= numbers.lastIndexOf(target);

     System.out.println("first Occurenence of Target: " + firstOccurence);
     log.accept("First Occurence of Element '11':" + firstOccurence);
     System.out.println("Last Occurenence of Target: " + lastOccurence);
     log.accept("Last Occurence of Element '11':" + lastOccurence);
     //10. Check if an ArrayList contains a given value.

    log.accept("Does arraylist contains the target: "+ numbers.contains(target));

     // 11.Merge two ArrayLists into a third list without duplicates.

     ArrayList<Integer> list2= new ArrayList<>();
        list2.add(20);
        list2.add(40);
        list2.add(50);

     Set<Integer> mergeset= new LinkedHashSet<>();   
        mergeset.addAll(numbers);
        mergeset.addAll(list2);

        log.accept("After Removing duplicates from the 2 lists and merging them to Set:\n" +mergeset);

     List<Integer> newList= new ArrayList<>(mergeset);
     System.out.println(newList);

     // 22. Find the element with the highest frequency in the list.

     numbers.add(11);
     System.out.println(numbers);

     Map<Integer, Integer> freqencyMap=  new HashMap<>();

     for(Integer num: numbers){
        freqencyMap.put(num, freqencyMap.getOrDefault(num,0)+1);
     }

     int maxFreq=0;
     int mostFreqElement=-1;

     for(Map.Entry<Integer,Integer> entry: freqencyMap.entrySet()){
        if(entry.getValue()>maxFreq){
            maxFreq=entry.getValue();
            mostFreqElement=entry.getKey();
        }
     }
     System.out.println("Element with highest frequency:" +maxFreq);
     System.out.println("Element with highest frequency:" +mostFreqElement);
     

    } catch (IOException e) {
        System.err.println("File Writing error:" +e.getMessage());
        e.printStackTrace();
    }
}
}
