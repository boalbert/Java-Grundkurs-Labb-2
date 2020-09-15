// Interface

package com.labb;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static AdList adBooks = new AdList();

    public static void main(String[] args) {

        System.out.println("Hello and welcome to the program!");
        System.out.println("Labb 2 - Albert Andersson");
        System.out.println("---------------------------------");

        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.print("Enter choice (Press 0 for menu): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    newBookAd();
                    break;
                case 2:
                    adBooks.printBookAds();
                    break;
                case 3:
                    removeBookAd();
                    break;
                case 4:
                    searchBookAd();
                    break;
                case 5:
                    updatePriceBookAd();
                    break;
                case 6:
                    bookSold();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Exiting program...");
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\t 0 - Show instructions");
        System.out.println("\t 1 - Post book ad");
        System.out.println("\t 2 - Show book ad(s)");
        System.out.println("\t 3 - Remove book ad");
        System.out.println("\t 4 - Search for book ad");
        System.out.println("\t 5 - Update price for book ad");
        System.out.println("\t 6 - Mark book as sold");
        System.out.println("\t 7 - Exit program");
    }

    private static void newBookAd() {
        int adId = (int) (1 + Math.random() * 4000);
        System.out.println("Creating Book ad....");
        System.out.print("Enter a (short) name for your ad: ");
        String nameOfAd = sc.nextLine().toUpperCase();
        System.out.print("Enter name of seller: ");
        String nameOfSeller = sc.nextLine();
        System.out.print("Enter title of the book: ");
        String bookTitle = sc.nextLine();
        System.out.print("Enter author of book: ");
        String authorBook = sc.nextLine();
        System.out.print("Enter book genre: ");
        String bookGenre = sc.nextLine();
        System.out.print("Enter price (SEK): ");
        double price = sc.nextDouble();
        sc.nextLine();

        BookAd newAdbook = new BookAd(nameOfSeller, nameOfAd, price, adId, authorBook, bookTitle, bookGenre);

        adBooks.addNewBook(newAdbook);
        System.out.println("\nNew book ad posted (ID# " + adId +").");
    }

    public static void removeBookAd() {
        System.out.print("Enter ID# for book ad you want to remove: ");
        int id = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(id);
        if (existingBookAd == null) {
            System.out.println("Unable to find ad.");
            return;
        }

        if(adBooks.removeBookAd(existingBookAd)) {
            System.out.println("Book ad has been removed!");
        } else {
            System.out.println("Unable to remove book ad.");
        }
    }

    public static void searchBookAd() {
        System.out.print("Enter book ID#: ");
        int searchBookId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(searchBookId);
        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
            return;
        }

        System.out.println("Found book ad: " +
                "\n\t" + existingBookAd.getNameOfAd() + "\t-" +
                "-\nID# " + existingBookAd.getAdId() +
                "\nSeller: " + existingBookAd.getNameOfSeller() +
                "\nTitle: " + existingBookAd.getTitleOfBook() +
                "\nAuthor: " + existingBookAd.getAuthorOfBook() +
                "\nGenre: " + existingBookAd.getGenreOfBook() +
                "\nPrice: " + existingBookAd.getPrice() + " SEK");
    }

    public static void updatePriceBookAd() {
        System.out.println("L");
        System.out.print("Enter book ID#: ");
        int searchBookId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(searchBookId);
        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
            return;
        }
        System.out.println(
        "\nBook title: " + existingBookAd.getTitleOfBook() +
                " (" + existingBookAd.getAuthorOfBook() + ")" +
                "\nCurrent price: " + existingBookAd.getPrice() + " SEK");

        System.out.print("Enter new price: ");
        double oldPrice = existingBookAd.getPrice();
        double newPrice = sc.nextInt();
        existingBookAd.setPrice(newPrice);
        System.out.println("Price for ID#" + existingBookAd.getAdId() + " updated!");
    }

    public static void bookSold() {
        System.out.println("L");
        System.out.print("Enter book ID#: ");
        int searchBookId = sc.nextInt();
        BookAd existingBookAd = adBooks.queryBookAd(searchBookId);
        if (existingBookAd == null) {
            System.out.println("Unable to find book ad.");
            return;
        }

        String oldTitle = existingBookAd.getNameOfAd();
        existingBookAd.setNameOfAd("\t - SOLD - \n\t" + oldTitle);
    }
}