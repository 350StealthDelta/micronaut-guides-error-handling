package example.micronaut;

import io.micronaut.context.MessageSource;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller("/books")
@RequiredArgsConstructor
public class BookController {

    private final MessageSource messageSource;

    @View("bookscreate")
    @Get("/create")
    public Map<String, Object> create() {
        return createModelWithBlankValues();
    }

    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Post("/save")
    public HttpResponse save(@Valid @Body CommandBookSave cmd) {
        return HttpResponse.ok();
    }

    private Map<String, Object> createModelWithBlankValues() {
        final Map<String, Object> model = new HashMap<>();
                model.put("title", "");
                model.put("pages", "");
                return model;
    }
}
