package com.backend.library.dto;

public enum CategoryType {
    RESARCH_HISTORY("Araştırma-tarih"),
    SCIENCE("Bilim"),
    COMİC("Çizgi Roman"),
    HOBBY("Hobi");

    private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
