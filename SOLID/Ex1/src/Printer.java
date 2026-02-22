import java.util.*;
public class Printer {
    public void printErrors(List<String> errors){
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
    public void printSuccess(StudentRecord rec, String id, int count){
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + count);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
    public void printRaw(String raw){
        System.out.println("INPUT: "+ raw);
    }
    
}
