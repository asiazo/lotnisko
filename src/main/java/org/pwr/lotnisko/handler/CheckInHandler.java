package org.pwr.lotnisko.handler;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.CheckIn;

public interface CheckInHandler {
    void apply(CheckInTo checkInTo);
    void process(CheckInTo checkInTo);
}