package com.demo.disclaimer.service.impl;


import com.demo.disclaimer.model.api.Disclaimer;
import com.demo.disclaimer.model.entity.DisclaimerEntity;
import com.demo.disclaimer.repository.DisclaimerRepository;
import com.demo.disclaimer.service.DisclaimerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DisclaimerServiceImpl implements DisclaimerService {

    @Autowired
    DisclaimerRepository disclaimerRepository;

    @Override
    public List<Disclaimer> getAllDisclaimers(String text) {

    List<Disclaimer> disclaimers = new ArrayList<>();
    List<DisclaimerEntity> listEntity = (text == null) ? disclaimerRepository.findAll() : disclaimerRepository.findByText(text);

        for (DisclaimerEntity dis : listEntity) {
            disclaimers.add(Disclaimer.builder()
                    .id(dis.getId())
                    .name(dis.getName())
                    .text(dis.getText())
                    .version(dis.getVersion())
                    .create_at(dis.getCreate_at())
                    .update_at(dis.getUpdate_at())
                    .build());
        }

    return disclaimers;

    }

    @Override
    public Disclaimer getDisclaimerById(Long id) {
        Optional<DisclaimerEntity> disclaimerOptional = disclaimerRepository.findById(id);
        if (disclaimerOptional.isPresent()) {
            DisclaimerEntity disclaimer = disclaimerOptional.get();
            return Disclaimer.builder()
                    .id(disclaimer.getId())
                    .name(disclaimer.getName())
                    .text(disclaimer.getText())
                    .version(disclaimer.getVersion())
                    .create_at(disclaimer.getCreate_at())
                    .update_at(disclaimer.getUpdate_at())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public Disclaimer createDisclaimer(Disclaimer disclaimer) {
        DisclaimerEntity newDisclaimer = new DisclaimerEntity();
        newDisclaimer.setName(disclaimer.getName());
        newDisclaimer.setText(disclaimer.getText());
        newDisclaimer.setVersion(disclaimer.getVersion());
        newDisclaimer.setCreate_at(disclaimer.getCreate_at());
        newDisclaimer.setUpdate_at(disclaimer.getUpdate_at());
        disclaimerRepository.save(newDisclaimer);

        return disclaimer;

    }

    @Override
    public Disclaimer updateDisclaimer(Long id, Disclaimer disclaimer) {
        Optional<DisclaimerEntity> disclaimerOptional = disclaimerRepository.findById(id);
        if (disclaimerOptional.isPresent()) {
            DisclaimerEntity updateDisclaimer = disclaimerOptional.get();
            updateDisclaimer.setName(disclaimer.getName());
            updateDisclaimer.setText(disclaimer.getText());
            updateDisclaimer.setVersion(disclaimer.getVersion());
            updateDisclaimer.setCreate_at(disclaimer.getCreate_at());
            updateDisclaimer.setUpdate_at(disclaimer.getUpdate_at());
            disclaimerRepository.save(updateDisclaimer);
            return disclaimer;
        } else {
            return null;
        }
    }

    @Override
    public void deleteDisclaimer(Long id) {
        disclaimerRepository.deleteById(id);
    }

}
