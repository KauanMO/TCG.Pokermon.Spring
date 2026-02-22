package com.tcg.pokermon.shared.exception;

import com.tcg.pokermon.shared.enums.ResourceEnum;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(ResourceEnum resource, Number id) {
        super(resource.name() + " not found by id: " + id);
    }
}
