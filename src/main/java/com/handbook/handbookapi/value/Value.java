package com.handbook.handbookapi.value;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "values")
@SequenceGenerator(name = "seq_values", sequenceName = "seq_values")
public class Value implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_values")
    @Column(name = "id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "currency_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    public Value() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Value convertValue(Value origin, CurrencyType targetCurrencyType) {
        Integer newAmount = origin.currencyType.convert(targetCurrencyType, origin.getAmount());

        Value newValue = new Value();

        newValue.setCurrencyType(targetCurrencyType);
        newValue.setAmount(newAmount);

        return newValue;
    }
}
