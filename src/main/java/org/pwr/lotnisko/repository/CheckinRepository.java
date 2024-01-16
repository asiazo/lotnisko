package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.CheckInTo;

public interface CheckinRepository {
    CheckInTo processWithCheckin(CheckInTo checkInTo);
}
