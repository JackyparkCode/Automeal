package org.zerock.ex01.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto imcrement
    private Long planId;//AUTO_PK
    private int calories;//칼로리
    private int carbohydrates;//탄수화물
    private int fat;//지방
    private int protein;//단백질
    @ManyToOne(fetch = FetchType.LAZY)//지연 로딩 방식 추구 이유는 데이터를 한꺼번에 조회함으로 즉시로딩 상용시 성능문제가 발생 할 수 있음//일대일 단방향 매핑
    @JoinColumn(name = "user_email")
    private User user;
    @Builder.Default
    @OneToMany(mappedBy = "mealPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealPlanList> mealPlanListList = new ArrayList<>();
}
