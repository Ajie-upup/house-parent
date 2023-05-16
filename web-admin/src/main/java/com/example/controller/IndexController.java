package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ajie
 * @date 2023/5/12
 * @description:
 */
@Controller
public class IndexController {
    private final static String PAGE_INDEX_FRAME = "frame/index";
    private final static String PAGE_MAIN = "frame/main";

    /**
     * 框架首页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return PAGE_INDEX_FRAME;
    }

    /**
     * 框架主页
     *
     * @return
     */
    @GetMapping("/main")
    public String main() {

        return PAGE_MAIN;
    }
}
