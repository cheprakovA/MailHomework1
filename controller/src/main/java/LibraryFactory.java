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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ignored) {
        }
    }

    @Nullable
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/books",
                "root", "password");
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
                Book.setTitle(resultSet.getString("title"));
                Author.setName(resultSet.getString("name"));
                author.setBookId(resultSet.getLong("book_id"));
                library.books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
}