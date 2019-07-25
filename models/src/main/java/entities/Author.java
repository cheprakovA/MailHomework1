package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor
public final class Author {

    @Setter
    @Getter
    @Nullable
    transient Long bookId;
    @Setter
    @Getter
    @Nullable
    private String name;
    @Setter
    @Getter
    @Nullable
    transient private Long id;
}
