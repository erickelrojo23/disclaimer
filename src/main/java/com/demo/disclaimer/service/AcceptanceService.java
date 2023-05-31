package com.demo.disclaimer.service;

import com.demo.disclaimer.model.api.Acceptance;

import java.util.List;

public interface AcceptanceService {

    Acceptance createAcceptance(Acceptance acceptance);

    List<Acceptance> listAcceptances(Long userId);
}
