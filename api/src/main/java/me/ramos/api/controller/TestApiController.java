package me.ramos.api.controller;

import lombok.RequiredArgsConstructor;
import me.ramos.commons.service.impl.TestCommonServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestApiController {

    private final TestCommonServiceImpl testCommonServiceImpl;

    @GetMapping
    public String apiTest() {
        return testCommonServiceImpl.test();
    }
}
