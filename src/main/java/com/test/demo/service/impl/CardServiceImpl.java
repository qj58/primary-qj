package com.test.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.demo.domain.Card;
import com.test.demo.mapper.CardMapper;
import com.test.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cardService")
public class CardServiceImpl extends ServiceImpl<CardMapper,Card> implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public Boolean updateByIdTest(Card card) {
        return cardMapper.updateByIdTest(card);
    }
}
