
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Searching {

    public static void main(String[] args) {
        // The program below is meant for testing the search algorithms you'll write
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        System.out.println("How many books to create?");
        int numberOfBooks = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            books.add(new Book(i, "name for the book " + i));
        }

        System.out.println("Id of the book to search for?");
        int idToSearchFor = Integer.valueOf(scanner.nextLine());

        System.out.println("");
        System.out.println("Searching with linear search:");
        long start = System.currentTimeMillis();
        int linearSearchId = linearSearch(books, idToSearchFor);
        System.out.println("The search took " + (System.currentTimeMillis() - start) + " milliseconds.");
        if (linearSearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(linearSearchId));
        }

        System.out.println("");

        System.out.println("");
        System.out.println("Seaching with binary search:");
        start = System.currentTimeMillis();
        int binarySearchId = binarySearch(books, idToSearchFor);
        System.out.println("The search took " + (System.currentTimeMillis() - start) + " milliseconds.");
        if (binarySearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(binarySearchId));
        }

    }

    public static int linearSearch(ArrayList<Book> books, int searchedId) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == searchedId) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ArrayList<Book> books, long searchedId) {

        // Binary Search prerequisits that data searched is in order.
//        Collections.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book book1, Book book2) {
//                return Integer.compare(book1.getId(), book2.getId());
//            }
//        });

        // assuming the variable searched exits
        // assuming the variable list exits


        // Binary search implementation:

//        int begin = 0;
//        Book lastbook = books.get(books.size()-1);
//        int end = lastbook.getId();

//        for (int i = begin; i < end; i++) {
//            int middle = (end + begin) / 2;
//            if (books.get(middle).getId() == (int) searchedId) {
//                return middle;
//            }
//            if (books.get(middle).getId() < (int) searchedId) {
//                begin = middle + 1;
//            }
//            if (books.get(middle).getId() > (int) searchedId) {
//                begin = middle - 1;
//            }
//        }
//
//        or
        int begin = 0;
        int end = books.size() - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            Book middleBook = books.get(middle);
            long middleId = middleBook.getId();

            if (middleId == searchedId) {
                return middle; // Return the index of the found book
            } else if (middleId < searchedId) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}

