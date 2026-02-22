public class Print {
    public static void printSuccess(String printable, String invId, FileStore store){
        System.out.print(printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
