package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) int에서만 사용!, 숫자 자동증가!
    private String menu; //기본키

    private String name;
    private int price;
    private int kcal;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "create_by")
    private String createBy;

    //수정
    //추가
    //변경사항확인
    //커밋
}
