package com.polaris.apiinterface.controller.v2;

import com.polaris.papiclientsdk.basicapi.model.response.RandomBoyAvatarResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author polaris
 * @version 1.0
 * ClassName AvatarController
 * Package com.polaris.apiinterface.controller.v2
 * Description
 * @create 2024-07-09 20:47
 */
@RestController
@RequestMapping("/v2/avatar")
public class AvatarController {
    @GetMapping("/boy")
    public RandomBoyAvatarResponse getBoyAvatar() {
         return new RandomBoyAvatarResponse("https://api.vvhan.com/api/avatar/boy");
    }
    @GetMapping("/girl")
    public RandomBoyAvatarResponse getGirlAvatar() {
        return new RandomBoyAvatarResponse("https://api.vvhan.com/api/avatar/girl");
    }

}
