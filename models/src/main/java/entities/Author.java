package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
public final class Author {

    @Setter
    @Getter
    @NonNull
    private static String name;
    @Setter
    @Getter
    @NonNull
    private Long id;
    @Setter
    @Getter
    @NonNull
    private Long bookId;
}
