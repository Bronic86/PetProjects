package com.abd.pet.atm.shared.model;

public enum Role {
    ADMIN,
    ACCOUNT_MGMT,
    USER_MGMT;

    /**
     * Convert String to Role.
     *
     * @param name the role name
     * @return Role entity or null
     */
    public static Role fromStr(String name) {
        if (!name.isEmpty()) {
            for (Role role : values()) {
                if (role.name().equals(name)) {
                    return role;
                }
            }
        }
        return null;
    }
}
