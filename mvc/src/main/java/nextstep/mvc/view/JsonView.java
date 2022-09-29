package nextstep.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import nextstep.web.support.MediaType;

public class JsonView implements View {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void render(final Map<String, ?> model, final HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        final Object data = getData(model);
        response.getWriter().write(objectMapper.writeValueAsString(data));
    }

    private Object getData(final Map<String, ?> model) {
        if (model.size() == 1) {
            return model.values().toArray()[0];
        }
        return model;
    }
}
