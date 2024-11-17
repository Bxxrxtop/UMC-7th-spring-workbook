package com.example.workbook.domain.common;

import com.example.workbook.domain.mapping.UserMission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String content;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", deadline='" + deadline + '\'' +
                ", price=" + price +
                '}';
    }
}
