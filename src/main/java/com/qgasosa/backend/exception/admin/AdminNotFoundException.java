package com.qgasosa.backend.exception.admin;

import com.qgasosa.backend.exception.common.NotFoundException;

public class AdminNotFoundException extends NotFoundException {

    private static final String ADMIN_NOT_FOUND = "Admin with username '%s' does not exist";

    public AdminNotFoundException(String username) {
        super(String.format(ADMIN_NOT_FOUND, username));
    }
}
