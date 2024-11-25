package com.example.workbook.service.MissionService;

import com.example.workbook.apiPayload.code.status.ErrorStatus;
import com.example.workbook.apiPayload.exception.handler.RestaurantHandler;
import com.example.workbook.converter.MissionConverter;
import com.example.workbook.converter.UserMissionConverter;
import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.domain.common.User;
import com.example.workbook.domain.enums.MissionStatus;
import com.example.workbook.domain.mapping.UserMission;
import com.example.workbook.repository.MissionRepository;
import com.example.workbook.repository.RestaurantRepository;
import com.example.workbook.repository.UserMissionRepository;
import com.example.workbook.repository.UserRepository;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    @Override
    public MissionResponseDto.AddMissionResponseDto addMission(MissionRequestDto.AddMissionRequestDto dto) {
        Mission mission = MissionConverter.toMission(dto);
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        mission.setRestaurant(restaurant);

        missionRepository.save(mission);
        return MissionConverter.toMissionResponseDto(mission);
    }
    @Override
    public MissionResponseDto.AddMissionToListResultDto addMissionToList(MissionRequestDto.AddMissionToListDto dto){
        Mission mission = missionRepository.findById(dto.getMissionId()).orElseThrow(() -> new RestaurantHandler(ErrorStatus.MISSION_NOT_FOUND));
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RestaurantHandler(ErrorStatus.USER_NOT_FOUND));

        //userMission 저장
        UserMission userMission = UserMissionConverter.toUserMission();
        userMission.setMission(mission);
        userMission.setUser(user);
        userMissionRepository.save(userMission);

        // List 추가
        user.addUserMission(userMission);
        mission.addUserMission(userMission);

        return UserMissionConverter.toAddUserMissionDto(userMission);
    }

    @Override
    public Page<Mission> restaurantMissionList(Long restaurantId, Integer page) {
        return missionRepository.findAllByRestaurantId(restaurantId, PageRequest.of(page-1, 10));
    }

    @Override
    public Page<UserMission> getUserMissionList(Long userId, Integer page) {
        return userMissionRepository.findByUserIdAndStatus(userId, MissionStatus.CHALLENGING, PageRequest.of(page-1, 10));
    }
}
