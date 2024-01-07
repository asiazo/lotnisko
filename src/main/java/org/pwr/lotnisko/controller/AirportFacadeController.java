package org.pwr.lotnisko.controller;

import lombok.RequiredArgsConstructor;
import org.pwr.lotnisko.api.AirportFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportFacadeController implements AirportFacade {
}
