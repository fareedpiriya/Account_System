package za.ac.nwu.ac.logic.flow.impl;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAccountType(String anyString);
    AccountTypeDto updateAccountType(String anyString, String anyString1, LocalDate any);
}