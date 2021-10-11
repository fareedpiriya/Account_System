package za.ac.nwu.ac.logic.flow.impl.impl;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

public class TestMiles {

    public Long addNewMiles;
    public Long subtractNewMiles;
    public Long resultAdd;
    public Long resultSub;

    public Long addMiles(AccountTransactionDto accountTransactionDto, int newMiles)
    {
        resultAdd = accountTransactionDto.getAmount() + newMiles;
        return resultAdd;
    }

    public Long subtractMiles(AccountTransactionDto accountTransactionDto, Long subtractNewMiles)
    {
        if(accountTransactionDto.getAmount() == null)
        {
            resultSub = null;
        }
        else
        {
            resultSub = accountTransactionDto.getAmount() + subtractNewMiles;
        }
        return resultSub;
    }
}