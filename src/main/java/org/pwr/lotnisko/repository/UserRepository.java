package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.PersonalData;
import org.springframework.stereotype.Service;


public interface UserRepository {
    void addUser(PersonalData personalData);

    PersonalData findById(long id);
}
