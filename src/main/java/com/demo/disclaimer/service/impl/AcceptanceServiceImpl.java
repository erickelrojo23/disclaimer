package com.demo.disclaimer.service.impl;

import com.demo.disclaimer.model.api.Acceptance;
import com.demo.disclaimer.model.api.Disclaimer;
import com.demo.disclaimer.model.entity.AcceptanceEntity;
import com.demo.disclaimer.model.entity.DisclaimerEntity;
import com.demo.disclaimer.repository.AcceptanceRepository;
import com.demo.disclaimer.service.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcceptanceServiceImpl implements AcceptanceService {

    @Autowired
    AcceptanceRepository acceptanceRepository;

    @Override
    public Acceptance createAcceptance(Acceptance acceptance) {
        AcceptanceEntity acceptanceEntity = new AcceptanceEntity();
        acceptanceEntity.setUserId(acceptance.getUser_id());
        DisclaimerEntity newDisclaimer = new DisclaimerEntity();
        newDisclaimer.setName(acceptance.getDisclaimer_id().getName());
        newDisclaimer.setText(acceptance.getDisclaimer_id().getText());
        newDisclaimer.setVersion(acceptance.getDisclaimer_id().getVersion());
        newDisclaimer.setCreate_at(acceptance.getDisclaimer_id().getCreate_at());
        newDisclaimer.setUpdate_at(acceptance.getDisclaimer_id().getUpdate_at());
        acceptanceEntity.setDisclaimerId(newDisclaimer);
        acceptanceEntity.setCreateAt(acceptance.getCreate_at());
        acceptanceRepository.save(acceptanceEntity);
        return acceptance;
    }

    @Override
    public List<Acceptance> listAcceptances(Long userId) {
        List<Acceptance> list = new ArrayList<>();
        List<AcceptanceEntity> acceptanceEntity = (userId == null) ? acceptanceRepository.findAll() : acceptanceRepository.findByUserId(userId);
            for (AcceptanceEntity ac: acceptanceEntity) {
                list.add(Acceptance.builder()
                        .id(ac.getId())
                        .user_id(ac.getUserId())
                        .disclaimer_id(Disclaimer.builder()
                                .id(ac.getDisclaimerId().getId())
                                .name(ac.getDisclaimerId().getName())
                                .text(ac.getDisclaimerId().getText())
                                .version(ac.getDisclaimerId().getVersion())
                                .create_at(ac.getDisclaimerId().getCreate_at())
                                .update_at(ac.getDisclaimerId().getUpdate_at())
                                .build())
                        .create_at(ac.getCreateAt())
                        .build());

            }
        return list;
    }
}
