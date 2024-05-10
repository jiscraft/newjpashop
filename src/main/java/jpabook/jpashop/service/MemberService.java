package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final만 컨서트럭터 생성해줌
public class MemberService {
    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    //기존에 이미 같은 이름으로 가입이 되었는지 valid check한다

    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepository.findByname(member.getName());
        if (!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
    //회원 전체 조회
    public List<Member> findMember(){
        return memberRepository.findAll();
    }


    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}
