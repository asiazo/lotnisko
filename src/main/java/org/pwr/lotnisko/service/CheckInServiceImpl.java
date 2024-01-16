package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.repository.CheckinRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CheckInServiceImpl implements CheckInService{
    private final CheckinRepository chceckinRepository;

    @Override
    public CheckInTo processWithCheckin(CheckInTo checkInTo) {
        checkInTo = chceckinRepository.processWithCheckin(checkInTo);
        return checkInTo;
    }
}

