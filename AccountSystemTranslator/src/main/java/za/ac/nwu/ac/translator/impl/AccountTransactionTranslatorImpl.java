package za.ac.nwu.ac.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction){
        try{
            return repo.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions(){
        List<AccountTransaction> accountTransactions;
        try{
            accountTransactions = new ArrayList<>(repo.findAll());
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionID){
        try{
            return repo.findById(transactionID).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}