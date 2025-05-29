package com.handbook.handbookapi.value;

import java.util.Objects;

public class ValueDTO {
    private Integer amount;
    private String currencyType;

    public ValueDTO() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Value toEntity() {
        Value value = new Value();
        value.setAmount(this.amount);
        value.setCurrencyType(CurrencyType.valueOf(this.currencyType));
        return value;
    }

    public static ValueDTO fromEntity(Value value) {
        if (Objects.isNull(value)) {
            return null;
        };

        ValueDTO valueDTO = new ValueDTO();
        valueDTO.setAmount(value.getAmount());
        valueDTO.setCurrencyType(value.getCurrencyType().toString());
        return valueDTO;
    }
}
