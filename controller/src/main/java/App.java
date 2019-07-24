import lombok.NonNull;

import java.util.Scanner;

public final class App {

    private static LibraryFactory libraryFactory = new LibraryFactory();

    public static void main(@NonNull String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter search param: ");

        String authorName = in.nextLine();

        libraryFactory.searchByAuthor(authorName);

    }
}
