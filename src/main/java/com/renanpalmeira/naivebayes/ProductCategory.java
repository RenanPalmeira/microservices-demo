package com.renanpalmeira.naivebayes;

import lombok.Getter;

public enum ProductCategory {
    PANTS("4"), TONER("1");

    @Getter
    private final String classify;

    ProductCategory(String classifyOption) {
        classify = classifyOption;
    }
}
