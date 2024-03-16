package com.example.demo.utilities;

import lombok.Getter;


public enum StatusEnum {
    FAIL("0"),
    SUCCESS("1");
    @Getter
    private final String value;

    StatusEnum(String value){
        this.value=value;
    }

}
