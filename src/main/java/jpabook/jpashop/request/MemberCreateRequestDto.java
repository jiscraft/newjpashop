package jpabook.jpashop.request;

import lombok.Data;

@Data
public class MemberCreateRequestDto {
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
