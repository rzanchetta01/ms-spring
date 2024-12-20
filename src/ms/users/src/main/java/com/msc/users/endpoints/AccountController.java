package com.msc.users.endpoints;

import com.msc.users.dto.AccountDto;
import com.msc.users.features.CheckAccountScore.CheckAccountScoreHandler;
import com.msc.users.features.CheckAccountScore.CheckAccountScoreQuery;
import com.msc.users.features.CreateAccount.CreateAccountCommand;
import com.msc.users.features.CreateAccount.CreateAccountHandler;
import com.msc.users.features.DeleteAccount.DeleteAccountCommand;
import com.msc.users.features.DeleteAccount.DeleteAccountHandler;
import com.msc.users.features.GetAccountDetails.GetAccountDetailsHandler;
import com.msc.users.features.GetAccountDetails.GetAccountDetailsQuery;
import com.msc.users.features.UpdateAccount.UpdateAccountCommand;
import com.msc.users.features.UpdateAccount.UpdateAccountHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private final CheckAccountScoreHandler checkAccountScoreHandler;
    private final CreateAccountHandler createAccountHandler;
    private final DeleteAccountHandler deleteAccountHandler;
    private final GetAccountDetailsHandler getAccountDetailsHandler;
    private final UpdateAccountHandler updateAccountHandler;

    public AccountController(CheckAccountScoreHandler checkAccountScoreHandler, CreateAccountHandler createAccountHandler, DeleteAccountHandler deleteAccountHandler, GetAccountDetailsHandler getAccountDetailsHandler, UpdateAccountHandler updateAccountHandler) {
        this.checkAccountScoreHandler = checkAccountScoreHandler;
        this.createAccountHandler = createAccountHandler;
        this.deleteAccountHandler = deleteAccountHandler;
        this.getAccountDetailsHandler = getAccountDetailsHandler;
        this.updateAccountHandler = updateAccountHandler;
    }

    @PostMapping("check-score")
    public ResponseEntity<Double> checkAccountScore(@RequestBody CheckAccountScoreQuery request) {
        try {
            var result = checkAccountScoreHandler.handle(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountDetails(@PathVariable Long id) {
        try {
            var result = getAccountDetailsHandler.handle(new GetAccountDetailsQuery(id));
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountCommand request) {
        try {
            createAccountHandler.handle(request);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateAccount(@RequestBody UpdateAccountCommand request) {
        try {
            updateAccountHandler.handle(request);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        try {
            deleteAccountHandler.handle(new DeleteAccountCommand(id));
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
