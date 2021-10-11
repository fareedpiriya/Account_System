package za.ac.nwu.ac.logic.flow.impl.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.impl.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator) {this.translator = translator;}

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions()
    {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for(AccountTransaction accountTransaction : translator.getAllAccountTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }

//    @Override
//    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
//        return null;
//    }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionID)
    {
        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionID);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
    }




}