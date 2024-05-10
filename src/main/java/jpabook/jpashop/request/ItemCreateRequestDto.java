package jpabook.jpashop.request;

import lombok.Data;

@Data
public class ItemCreateRequestDto {
    private String name;
    private int price;
    private int stockQuantity;


}
