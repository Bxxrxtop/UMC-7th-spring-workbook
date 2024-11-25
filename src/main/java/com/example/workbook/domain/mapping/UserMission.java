package com.example.workbook.domain.mapping;

import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.common.User;
import com.example.workbook.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("DEFAULT")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setUser(User user){
        this.user = user;
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }

    public void setStatus(MissionStatus missionStatus){
        status = missionStatus;
    }
}

