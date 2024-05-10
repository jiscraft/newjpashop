package jpabook.jpashop.service;



import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final만 컨서트럭터 생성해줌
public class ItemService {
    private final ItemRepository itemRepository;

    //상품등록
    @Transactional
    public Long saveItem(Item item){
        validateDuplicateItem(item);
        itemRepository.save(item);
        return item.getId();
    }
    //기존에 이미 같은 이름으로 가입이 되었는지 valid check한다

    private void validateDuplicateItem(Item item) {
        List<Item> findItem = itemRepository.findByname(item.getName());
        if (!findItem.isEmpty()){
            throw new IllegalStateException("이미 존재하는 상품이름 입니다");
        }
    }
    //회원 전체 조회
    public List<Item> findItem(){
        return itemRepository.findAll();
    }


    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }
}
