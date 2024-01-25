package org.pwr.lotnisko.service;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.model.PersonalData;
import org.pwr.lotnisko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addPersonalData(final PersonalData personalData) {
        userRepository.addUser(personalData);
    }

    @Override
    public PersonalData getPersonalData(final long userId) {
        return userRepository.findById(userId);
    }
}
