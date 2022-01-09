package com.rhythm.service;

import java.math.BigDecimal;

public interface IAccountService {
    int updateMoney(Long userId, BigDecimal money);
}
