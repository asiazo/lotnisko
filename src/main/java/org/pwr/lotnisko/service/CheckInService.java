package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.CheckInTo;

public interface CheckInService {
    CheckInTo processWithCheckin(CheckInTo checkInTo);
}
