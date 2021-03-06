package za.ac.nwu.ac.logic.flow.impl.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.impl.ModifyAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("modifyAccountTypeFlowName")
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {
    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {
        return null;
    }
}