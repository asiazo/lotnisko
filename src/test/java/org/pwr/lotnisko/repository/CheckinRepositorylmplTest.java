package org.pwr.lotnisko.repository;

import org.junit.jupiter.api.Test;
import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckInStatus;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class CheckinRepositorylmplTest {

    @Test
    void processWithCheckIn_ShoudProcessCheckInIntoStatusCHECK_IN_IN_PROGRESS() {
        // given
        CheckInTo checkInTo = CheckInTo.builder()
                .checkInStatus(CheckInStatus.CHECK_IN_PENDING)
                .build();

        // when

        // then

    }

}