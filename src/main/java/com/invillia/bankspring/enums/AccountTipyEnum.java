package com.invillia.bankspring.enums;


import java.util.HashMap;
import java.util.Map;

public enum AccountTipyEnum {

    SANVINGS_ACCOUNT("SANVINGS", 0.0),
    CHECKING_ACCOUNT("CHECKING", 500.0);

    private static final Map<String, AccountTipyEnum> BY_TYPE = new HashMap<String, AccountTipyEnum>();
    private static final Map<Double, AccountTipyEnum> BY_LIMIT = new HashMap<Double, AccountTipyEnum>();


    static {
        for (AccountTipyEnum a : values()) {
            BY_TYPE.put(a.type, a);
            BY_LIMIT.put(a.accountLimit, a);
        }
    }

    public final String type;
    public final Double accountLimit;

    private AccountTipyEnum(String type, Double accountLimit) {
        this.type = type;
        this.accountLimit = accountLimit;
    }
}