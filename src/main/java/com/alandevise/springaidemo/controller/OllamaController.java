package com.alandevise.springaidemo.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Filename: OllamaController.java
 * @Package: com.alandevise.springaidemo.controller
 * @Version: V1.0.0
 * @Description: 1.
 * @Author: Alan Zhang [initiator@alandevise.com]
 * @Date: 2024年06月02日 20:43
 */

@RestController
@RequestMapping("/ollama")
public class OllamaController {

    @Resource
    OllamaChatClient ollamaChatClient;

    /**
     * Ollama聊天接口
     *
     * @Author: Alan [initator@alandevise.com]
     * @Date: 2024/6/2 20:47
     * @param: prompt 提示词
     * @return: java.lang.String
     **/
    @GetMapping("/api")
    public String ollamaChat(@RequestParam("prompt") String prompt) {
        return ollamaChatClient.call(prompt);
    }
}
