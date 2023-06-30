package fcm.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestMultiDto {
    private String title;
    private String body;
    private String imageUrl;
    private String linkUrl;
    private List<String> tokens;
}
