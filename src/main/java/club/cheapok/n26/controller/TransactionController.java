package club.cheapok.n26.controller;

import club.cheapok.n26.model.Transaction;
import club.cheapok.n26.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<Void> addTransaction(@RequestBody @Valid final Transaction transaction,
                                               final BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        transactionService.save(transaction);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
