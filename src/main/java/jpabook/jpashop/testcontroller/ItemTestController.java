package jpabook.jpashop.testcontroller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.request.ItemCreateRequestDto;
import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemTestController {
    @Autowired
    ItemService itemService ;
    @GetMapping("/testitem")
    public void save(@RequestBody ItemCreateRequestDto requestItem){

        Book book = new Book("java" ,12000 , 100 ,"홍길동" ,"1234567");
        itemService.saveItem(book);

    }
}
