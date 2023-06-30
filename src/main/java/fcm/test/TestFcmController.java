package fcm.test;

import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;
import fcm.common.JSONResponse;
import fcm.firebase.Fcm;
import fcm.test.dto.TestMultiDto;
import fcm.test.dto.TestSingleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    @Author : 전남혁 ( all_step@naver.com )
    @Description : FCM 푸시 알림
    @Created : 2023.05.24
    @Version : 1.0.0
*/
@Slf4j
@Controller
@RequiredArgsConstructor
public class TestFcmController {
    private final Fcm fcm;


    // 초기 FireBase initialize 테스트
    @PostMapping("/test")
    @ResponseBody
    public JSONResponse<?> reqTest() {

        try {
            fcm.init();
        } catch (Exception e) {
            return new JSONResponse<>(500, "fail", e.getMessage());
        }

        return new JSONResponse<>(200, "success", null);
    }

    // 단일 메세지 테스트
    @PostMapping("/test/single/send")
    @ResponseBody
    public JSONResponse<?> testSend(@RequestBody TestSingleDto dto) {

        String response;

        try {
            fcm.init();
        } catch (Exception e) {
            return new JSONResponse<>(500, "fail", e.getMessage());
        }

        Message message = fcm.setSingleMessage(dto.getTitle(), dto.getBody(), dto.getImageUrl(), dto.getToken(), dto.getLinkUrl());
        try {
            response = fcm.sendSingleMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResponse<>(500, "fail", e.getMessage());
        }

        return new JSONResponse<>(200, "success", response);
    }

    // 여러명에게 동일한 메세지를 보낼경우 테스트
    @PostMapping("/test/multi/send")
    @ResponseBody
    public JSONResponse<?> testMultiSend(@RequestBody TestMultiDto dto) {

        try {
            fcm.init();
        } catch (Exception e) {
            return new JSONResponse<>(500, "fail", e.getMessage());
        }

        MulticastMessage message = fcm.setMulticastMessage(dto.getTitle(), dto.getBody(), dto.getImageUrl(), dto.getTokens(), dto.getLinkUrl());
        BatchResponse response;
        try {
            response = fcm.sendMultiMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResponse<>(500, "fail", e.getMessage());
        }

        return new JSONResponse<>(200, "success", response);
    }
}
