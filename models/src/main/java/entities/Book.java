package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor
public final class Book {

    @Setter
    @Getter
    @Nullable
    private String title;

    @Setter
    @Getter
    @Nullable
    transient private Long id;

    @Setter
    @Getter
    @Nullable
    private Author author;
}
