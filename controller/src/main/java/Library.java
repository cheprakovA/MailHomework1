import entities.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
final class Library {

    @Setter
    @Getter
    @NonNull
    List<Book> books = new ArrayList<>();
}
