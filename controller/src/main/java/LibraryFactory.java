import com.google.gson.Gson;
import entities.Author;
import entities.Book;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;

final class LibraryFactory {

    @NotNull
    private static Library library = new Library();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Nullable
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "pass");
    }

    private void closeConnection(@Nullable Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException ignored) {
        }
    }

    void searchByAuthor(@NotNull String searchParam) {
        String sql = "select * from book inner join author on book.id = author.book_id"
                + " where author.name like '%"
                + searchParam.trim() + "%'";
        Connection connection = null;
        try {
            connection = getConnection();
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                author.setId(resultSet.getLong("id"));
                author.setName(resultSet.getString("name"));
                author.setBookId(resultSet.getLong("book_id"));
                book.setAuthor(author);
                library.books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    void showLib(@NotNull String authorName) {
        Gson json = new Gson();
        String shownResult;
        if (!library.books.isEmpty()) {
            shownResult = json.toJson(library);
            System.out.println(shownResult);
        } else {
            System.out.print("There is no books written by " + authorName);
        }
    }
}