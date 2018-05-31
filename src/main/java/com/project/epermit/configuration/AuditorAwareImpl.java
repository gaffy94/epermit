package com.project.epermit.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Kasumu Gaffar");
        //can use spring security to return logged in user, out of scope ??
    }
}
