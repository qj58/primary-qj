package com.test.demo.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.test.demo.domain.Card;
import com.test.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

/**
 * @RestController : @Controller + @ResponseBody
 */
@Controller
public class HelloController {

    @Autowired
    private CardService cardService;

    /*增*/
    @ResponseBody
    @RequestMapping("/add")
    public Card add(@RequestBody String param){
        Card card = JSONUtil.toBean(param,Card.class);
        Boolean b = cardService.save(card);
        return card;
    }

    /*删*/
    @ResponseBody
    @RequestMapping("/delete")
    public Boolean add(Integer id){
        Boolean b = cardService.removeById(id);
        return b;
    }

    /*改*/
    @ResponseBody
    @RequestMapping("/update")
    public Boolean update(Integer id){
        Card card = cardService.getById(id);
        card.setContent("胡梦雨");
        Boolean b = cardService.updateById(card);
        return b;
    }

    /*查*/
    @ResponseBody
    @RequestMapping("/query")
    public Card query(Integer id){
        Card card = cardService.getById(1);
        return card;
    }

}
