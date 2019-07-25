import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class App {

    @NotNull
    private static LibraryFactory libraryFactory = new LibraryFactory();

    public static void main(@NotNull String[] args) {

        String authorName = String.valueOf(JOptionPane
                .showInputDialog("Enter search parameter: "));

        libraryFactory.searchByAuthor(authorName);
        libraryFactory.showLib(authorName);

    }
}
