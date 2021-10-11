package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.impl.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.impl.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow)
    {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
            @RequestBody AccountTransactionDto AccountTransaction)
    {
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){

        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();

        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{amount}")
    @ApiOperation(value = "Fetches the Miles for the specified AccountTransaction", notes = "Fetches the amount of Miles corresponding to the given AccountTransaction")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Miles Amount Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAmount(
            @ApiParam(value = "The amount of Miles of the specific AccountTransaction.",
                    example = "250",
                    name = "Amount",
                    required = true)
            @PathVariable("amount") final Long amount){

        AccountTransactionDto AccountTransactions = fetchAccountTransactionFlow.getAccountTransactionById(amount);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactions);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction", notes = "Fetches the AccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The transactionID that uniquely identifies the AccountTransaction.",
                    example = "5002",
                    name = "transactionID",
                    required = true)
            @PathVariable("transactionID") final Long transactionID){

        AccountTransactionDto AccountTransactions = fetchAccountTransactionFlow.getAccountTransactionById(transactionID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactions);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
