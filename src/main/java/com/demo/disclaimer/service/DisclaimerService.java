package com.demo.disclaimer.service;

import com.demo.disclaimer.model.api.Disclaimer;

import java.util.List;

public interface DisclaimerService {

    List<Disclaimer> getAllDisclaimers(String text);

    Disclaimer getDisclaimerById(Long id);

    Disclaimer createDisclaimer(Disclaimer disclaimer);

    Disclaimer updateDisclaimer(Long id, Disclaimer disclaimer);

    void deleteDisclaimer(Long id);


}
