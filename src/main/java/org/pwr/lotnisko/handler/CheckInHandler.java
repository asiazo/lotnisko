package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;

public interface CheckInHandler {
    CheckInTo apply(CheckInTo checkInTo);
    CheckInTo process(CheckInTo checkInTo);
}