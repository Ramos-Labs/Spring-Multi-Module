package me.ramos.commons.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestCommonService {

    public String test() {
        return "Hello Common Service";
    }

}
