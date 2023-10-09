package me.ramos.commons.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestCommonServiceImpl {

    public String test() {
        return "Hello Common Service";
    }

}
