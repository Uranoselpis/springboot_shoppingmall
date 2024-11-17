package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
// 클라이언트의 요청에 대해서 어떤 컨트롤러가 처리할지 매핑하는 어노테이션.
// url에 "/thymeleaf" 경로로 오는 요청을 ThymeleafExController가 처리하도록 한다.

public class ThymeleafExController {

    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data", "타임리프 예제 입니다.");
        // model 객체를이용해 뷰에 전달한 데이터를 key, value 구조로 넣어준다.
        return "thymeleafEx/thymeleafEx01";
        // templates 폴더를 기준으로 뷰의 위치와 이름(thymeleafEx01.html)을 반환
    }

    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품 1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            // 반복문을 통해 화면에 출력할 10개의 itemDto 객체를 만들어서 itemDtoList에 넣어준다.
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명 " + i);
            itemDto.setItemNm("테스트 상품 " + i);
            itemDto.setPrice(10000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        // 화면에 출력할 itemDtoList를 model에 담아서 view에 전달한다.

        return "thymeleafEx/thymeleafEx03";
    }

    @GetMapping(value = "/ex04")
    public String thymeleafExample04(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i <= 20; i++) {
            ItemDto itemDto = new ItemDto();

            itemDto.setItemNm("데스트 상품 " + i);
            itemDto.setItemDetail("상품 상세 설명 " + i);
            itemDto.setPrice(10000 + i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);

        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping(value = "/ex04_1")
    public String thymeleafExample04_1(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i <= 20; i++) {
            ItemDto itemDto = new ItemDto();

            itemDto.setItemNm("상품명 " + i);
            itemDto.setItemDetail("상품 상세 설명 " + i);
            itemDto.setPrice(10000 + i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);

        return "thymeleafEx/thymeleafEx04_1";
    }

    @GetMapping(value = "/ex05")
    public String thymeleafExample05() {

        return "thymeleafEx/thymeleafEx05";
    }

    @GetMapping(value = "ex06")
    public String thymeleafExample06(String param1, String param2, Model model) {
        // 전달했던 매개 변수와 같은 이름의 String 변수 param1, param2를 파라미터로 설정하면 자동으로 데이터가 바인딩 된다.
        // 매개 변수를 model에 담에서 view에 전달한다.
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);

        return "thymeleafEx/thymeleafEx06";
    }


}

