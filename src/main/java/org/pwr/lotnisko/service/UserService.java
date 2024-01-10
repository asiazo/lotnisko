package org.pwr.lotnisko.service;

import org.pwr.lotnisko.model.PersonalData;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    void addPersonalData(PersonalData personalData);

    PersonalData getPersonalData(long userId);
}
