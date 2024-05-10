package jpabook.jpashop.testcontroller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.request.MemberCreateRequestDto;
import jpabook.jpashop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberTestController {
    
    @Autowired
    MemberService memberService ;

    @PostMapping("/testmember")
    public ResponseEntity save(@RequestBody MemberCreateRequestDto requestMember){
        Address address = new Address(requestMember.getCity(), requestMember.getStreet() , requestMember.getZipcode());
        Member member = new Member(requestMember.getName() , address);
        Long id = memberService.join(member);
        Member result = memberService.findOne(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/testmember")
    public List<Member> findAll(){
        return memberService.findMember();
    }




}
