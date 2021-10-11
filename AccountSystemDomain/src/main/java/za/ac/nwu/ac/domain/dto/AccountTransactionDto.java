package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -3146543329179403650L;
    private Long transactionID;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;
    private AccountTransactionDetailsDto details;

    public AccountTransactionDto(){
    }

    public AccountTransactionDto(Long transactionID, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate)
    {
        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(Long transactionID, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate, AccountTransactionDetailsDto details)
    {
        this.transactionID = transactionID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction)
    {
        this.transactionID = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType){
        return new AccountTransaction(this.getTransactionID(), accountType, this.getMemberId(), this.getAmount(), this.getTransactionDate());

    }

    public Long getTransactionID() {return transactionID;}

    public void setTransactionID(Long transactionID) {this.transactionID = transactionID;}

    public String getAccountTypeMnemonic() {return accountTypeMnemonic;}

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {this.accountTypeMnemonic = accountTypeMnemonic;}

    public Long getMemberId() {return memberId;}

    public void setMemberId(Long memberId) {this.memberId = memberId;}

    public Long getAmount() {return amount;}

    public void setAmount(Long amount) {this.amount = amount;}

    public LocalDate getTransactionDate() {return transactionDate;}

    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}

    public AccountTransactionDetailsDto getDetails() { return details; }

    public void setDetails(AccountTransactionDetailsDto details) { this.details = details; }

}