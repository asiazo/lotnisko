package org.pwr.lotnisko.checkInHandler;

import org.pwr.lotnisko.model.CheckIn;

public interface CheckInHandler {
    void apply(CheckIn checkIn);
    void process(CheckIn checkIn);
}