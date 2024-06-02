package com.alandevise.springaidemo.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @Filename: OpenAIChatController.java
 * @Package: com.alandevise.springaidemo.controller
 * @Version: V1.0.0
 * @Description: 1. 利用OpenAi进行对话的Controller
 * @Author: Alan Zhang [initiator@alandevise.com]
 * @Date: 2024年06月02日 18:02
 */

@RestController
@RequestMapping("/chatgpt")
public class OpenAIChatController {

    /**
     * 注入一个OpenAi的聊天对象
     */
    @Resource
    OpenAiChatClient openAiChatClient;

    /**
     * 请求ChatGPT对话接口并获取完整回复
     *
     * @Author: Alan [initiator@alandevise.com]
     * @Date: 2024/6/2 19:06
     * @Param: message 用户输入的提示词
     **/
    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        return openAiChatClient.call(message);
    }

    /**
     * 以流的方式获取ChatGPT的结果
     *
     * @Author: Alan [initator@alandevise.com]
     * @Date: 2024/6/2 19:19
     * @param: message
     * @return: java.lang.String
     **/
    @GetMapping("/chatInStream")
    public Flux<String> chatInStream(@RequestParam("message") String message) {
         return openAiChatClient.stream(message);
    }
}
