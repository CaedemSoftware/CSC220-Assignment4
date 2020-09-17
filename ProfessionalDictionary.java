/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: <ProfessionalDictionary>
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
import java.util.Iterator;
import java.util.Scanner;

public class ProfessionalDictionary {

    private enum Entry {

        Book("Book", "[noun] : A written work published in printed or electronic form."),
        Book2("Book", "[verb] : To arrange for someone to have a seat on a plane."),
        Bookable("Bookable", "[adjective] : Can be ordered in advance."),
        Bookcase("Bookcase", "[noun] : A piece of furniture with shelves."),
        Bookbinder("Bookbinder", "[noun] : A person who fastens the pages of books."),
        csc("CSC220", "[noun] : Data Structures."),
        csc2("CSC220", "[adjective] : Ready to create complex data structures."),
        csc3("CSC220", "[verb] : To create data structures.");

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
        System.out.println("- DICTIONARY 220 JAVA Professional -----\n"
                + String.format("%-15s", "-----") + "powered by Google Guava -");
        Multimap<String, String> dictionaryGG = ArrayListMultimap.create();
        for (Entry word : Entry.values()) {
            dictionaryGG.put(word.getKey(), word.getValue());
        }
        String searchKey = "";
        while (!searchKey.equals("!q")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Search: ");
            searchKey = input.next().toLowerCase(); //ignore casing
            String partOfSpeech = input.nextLine().toLowerCase();
            partOfSpeech = partOfSpeech.replaceAll(" ", "");
            if (!searchKey.equals("csc220")) {
                searchKey = Character.toString(searchKey.charAt(0)).toUpperCase()
                        + searchKey.substring(1);
            }
            if (searchKey.equals("csc220")) {
                searchKey = "CSC220";
            }
            //ignore casing end

            if (dictionaryGG.containsKey(searchKey)) {
                boolean found = false;
                System.out.println(String.format("%4s", "|"));
                Iterator<String> it = dictionaryGG.get(searchKey).iterator();
                while (it.hasNext()) {
                    String entry = it.next();
                    if (!(partOfSpeech.equals("noun"))
                            && !(partOfSpeech.equals("verb"))
                            && !(partOfSpeech.equals("adjective"))
                            && !(partOfSpeech.equals(""))) {
                        System.out.println("    <2nd argument must be a part of "
                                + "speech or \"distinct\">");
                        break;
                    }
                    if (entry.contains(partOfSpeech)) {
                        System.out.println("    " + searchKey + " " + entry);
                        found = true;
                    } else if (!entry.contains(partOfSpeech)
                            && !it.hasNext() && !found) {
                        System.out.println("    <Not found>");
                    }
                }// end iterator while
            } //end contains
            else {
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
