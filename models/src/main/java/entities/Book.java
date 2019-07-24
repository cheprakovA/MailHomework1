package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public final class Book {

    @Setter
    @Getter
    @NotNull
    private static String title;
    @Setter
    @Getter
    @NotNull
    private Long id;
}
