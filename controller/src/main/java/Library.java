import entities.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
final class Library {

    @Setter
    @Getter
    @NotNull
    List<Book> books = new ArrayList<>();
}
