package com.example.demo.repository;


import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class MenuRepositoryTest extends DemoApplicationTests {
    @Autowired
    private Menurepository menurepository;

    @Test
    public void create(){
        Menu m = new Menu();
        m.setMenu("캔디");
        m.setName("츄파츕스");
        m.setPrice(800);
        m.setKcal(45);
        m.setCreateAt(LocalDateTime.now());
        m.setCreateBy("Admin");

        System.out.println(m.toString());
        menurepository.save(m);
    }
    
    //단위테스트 디버깅차이
    //디버깅: 어디에 문제 발생했을까? 찾는것
    //단위테스트: 내 코드에 대한 확신이 있어! 증명하기 위해서 진행하는 것
    @Test
    public void read(){
        Optional<Menu> menu = menurepository.findById("카라멜");

        Assertions.assertFalse(menu.isPresent());
        //해당하는 데이터가 없으면 assertTrue에서 error!
        //해당하는 데이터가 있으면 assertTrue, 없으면 assertFalse

        //menu m;
        //ifPresent()는 Optional 객체가 값을 가지고 있으면 실행, 값이 없으면 넘어감
        menu.ifPresent(m ->{
            System.out.println(m);
            /* System.out.println(m.getMenu());
            System.out.println(m.getName());
            System.out.println(m.getPrice());
            System.out.println(m.getKcal()); */
        });

        System.out.println("종료");  //값이 없으면 출력됨
    }
    
    @Test
    @Transactional //트랜잭션
    public void update(){
        Optional<Menu> menu = menurepository.findById("아이스크림");
        menu.ifPresent(m ->{
            m.setName("ddd");
            menurepository.save(m);
        });
    }

    @Test
    //@Transactional
    public void delete(){
        //생성자를 가져다주는 역할
        Optional<Menu> menu = menurepository.findById("아이스크림");
        menu.ifPresent(m ->{
            menurepository.delete(m);
        });
    }
}
