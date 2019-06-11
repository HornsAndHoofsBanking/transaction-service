package ru.alexandrov.transaction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexandrov.transaction.json.request.TransactionRequest;
import ru.alexandrov.transaction.service.TransactionException;
import ru.alexandrov.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionService service;

    @PostMapping
    ResponseEntity moveMoney(@RequestBody TransactionRequest request) {
        try {
            service.doTransaction(request);
        } catch (TransactionException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
