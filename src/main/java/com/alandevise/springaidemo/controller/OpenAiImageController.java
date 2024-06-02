package com.alandevise.springaidemo.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Filename: OpenAiImageController.java
 * @Package: com.alandevise.springaidemo.controller
 * @Version: V1.0.0
 * @Description: 1.
 * @Author: Alan Zhang [initiator@alandevise.com]
 * @Date: 2024年06月02日 19:25
 */

@RestController
@RequestMapping("/generateImage")
public class OpenAiImageController {

    @Resource
    OpenAiImageClient openAiImageClient;

    @RequestMapping(value = "/chat", produces = "text/html")
    public String generateImage(@RequestParam("prompt") String prompt) {
        ImageResponse response = openAiImageClient.call(new ImagePrompt(prompt));
        Image output = response.getResult().getOutput();
        String url = output.getUrl();
        String b64Json = output.getB64Json();
        return "<img src='" + url + "'/>";
    }
}
