package com.test.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.test.demo.domain.Card;

public interface CardService extends IService<Card> {

    Boolean updateByIdTest(Card card);
}
