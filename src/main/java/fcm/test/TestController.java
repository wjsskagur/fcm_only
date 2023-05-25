package fcm.test;

import fcm.common.JSONResponse;
import fcm.test.dto.TestTokenSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

//    private final MemberService memberService;

    @PostMapping("/token/save")
    @ResponseBody
    public JSONResponse<?> saveToken(@RequestBody TestTokenSaveDto dto) {

        if (!hasText(dto.getToken())) {
            return new JSONResponse<>(400, "fail", "token is empty");
        }

        try {
            // TODO : save token
//            memberService.saveToken(dto);
        } catch (Exception e) {
            return new JSONResponse<>(500, "fail", e.getMessage());
        }


        return new JSONResponse<>(200, "success", null);
    }
}
