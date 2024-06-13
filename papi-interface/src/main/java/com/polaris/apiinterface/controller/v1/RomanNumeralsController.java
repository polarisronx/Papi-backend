package com.polaris.apiinterface.controller.v1;

import com.polaris.apiinterface.service.RomanNumeralsService;
import com.polaris.papiclientsdk.basicapi.model.response.IntToRomanResponse;
import com.polaris.papiclientsdk.basicapi.model.response.RomanToIntResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author polaris
 * @version 1.0
 * ClassName RomanNumeralsController
 * Package com.polaris.apiinterface.controller
 * Description
 * @create 2024-05-28 17:16
 */
@RestController
@RequestMapping("/v1/roman")
public class RomanNumeralsController {
    @Resource
    RomanNumeralsService romanNumeralsService;
    @GetMapping("/intToRoman")
    public IntToRomanResponse intToRoman(@RequestParam String num){
        return new IntToRomanResponse(romanNumeralsService.intToRoman(num));
    }
    @GetMapping("/romanToInt")
    public RomanToIntResponse romanToInt(@RequestParam String roman){
        return new RomanToIntResponse(romanNumeralsService.romanToInt(roman));
    }
}
