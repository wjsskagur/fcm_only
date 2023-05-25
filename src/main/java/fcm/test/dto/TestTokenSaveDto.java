package fcm.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestTokenSaveDto {
    private Long memberId;
    private String token;
    private String device;
}
