package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.model.PersonalData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserRepositoryImpl implements UserRepository {

    List<PersonalData> personalDataList = new ArrayList<>(
            List.of(PersonalData.builder().id(0).firstName("Yara").secondName("Allan").passportNumber("ET345233").build())
    );

    @Override
    public void addUser(final PersonalData personalData) {
        personalData.setId(personalDataList.size());
        personalDataList.add(personalData);
    }

    @Override
    public PersonalData findById(final long id) {
        return personalDataList.stream().filter(user -> user.getId() == id).findFirst().get();
    }
}
