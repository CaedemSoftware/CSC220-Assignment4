/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: <StandardDictionary>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package CSC220;

/**
 * @author Ze Lei <SFSU>
 */
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Scanner;

public class StandardDictionary {

    private enum Entry {

        Book("Book", "A written work published in printed or electronic form."),
        Book2("Book", "To arrange for someone to have a seat on a plane."),
        Bookable("Bookable", "Can be ordered in advance."),
        Bookcase("Bookcase", "A piece of furniture with shelves."),
        Bookbinder("Bookbinder", "A person who fastens the pages of books."),
        csc("CSC220", "Data Structures."),
        csc2("CSC220", "Ready to create complex data structures."),
        csc3("CSC220", "To create data structures.");

        private String key;
        private String value;

        private Entry() {

        }

        private Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        System.out.println("- DICTIONARY 220 JAVA Standard -----\n"
                + String.format("%-11s", "-----") + "powered by Google Guava -");
        Multimap<String, String> dictionaryGG = ArrayListMultimap.create();
        for (Entry word : Entry.values()) {
            dictionaryGG.put(word.getKey(), word.getValue());
        }
        String searchKey = "";
        while (!searchKey.equals("!q")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Search: ");
            searchKey = input.nextLine().toLowerCase(); //ignore casing
            if (!searchKey.equals("csc220")) {
                searchKey = Character.toString(searchKey.charAt(0)).toUpperCase()
                        + searchKey.substring(1);
            }
            if (searchKey.equals("csc220")) {
                searchKey = "CSC220";
            }
            //ignore casing end

            if (dictionaryGG.containsKey(searchKey)) {
                System.out.println(String.format("%4s", "|"));
                for (String entry : dictionaryGG.get(searchKey)) {
                    System.out.println("    " + searchKey + ": " + entry);
                }
            } else {
                if (searchKey.equals("!q")) {
                    break;
                }
                System.out.println(String.format("%4s", "|"));
                System.out.println("    <Not found>");
            }

            System.out.println(String.format("%4s", "|"));
        }
        System.out.println("-----THANK YOU-----");
    }

}
