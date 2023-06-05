package example.micronaut;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Serdeable
@Getter
@Setter
public class CommandBookSave {
    @NotBlank
    private String title;
    @Positive
    private int pages;
}
