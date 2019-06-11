package ru.alexandrov.transaction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexandrov.transaction.model.Transfer;
import ru.alexandrov.transaction.model.Wallet;
import ru.alexandrov.transaction.repository.OperationRepository;
import ru.alexandrov.transaction.repository.WalletRepository;
import ru.alexandrov.transaction.json.request.TransactionRequest;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final OperationRepository or;
    private final WalletRepository wr;

    public void doTransaction(TransactionRequest request) throws TransactionException {
        Wallet accountFrom = wr.findByAccIdAndCurrency(request.getFromAccId(), request.getCurrencyFrom());
        Wallet accountTo = wr.findByAccIdAndCurrency(request.getFromAccId(), request.getCurrencyTo());
        if (accountFrom == null || accountTo == null) {
            throw new TransactionException("Не найден кошелек");
        }
        Transfer transfer = makeOperationEntityFromRequest(request);
        if (accountFrom.getAmount() >= request.getAmount()) {
            accountFrom.setAmount(accountFrom.getAmount() - request.getAmount());
            accountTo.setAmount(accountTo.getAmount() + request.getAmount());
        } else throw new TransactionException("Недостаточно средств");

        wr.save(accountFrom);
        wr.save(accountTo);
        or.save(transfer);
    }
    private Transfer makeOperationEntityFromRequest(TransactionRequest transactionRequest) {
        return new Transfer()
                .setAmount(transactionRequest.getAmount())
                .setCurrency(transactionRequest.getCurrencyFrom())
                .setFromAccId(transactionRequest.getFromAccId())
                .setToAccId(transactionRequest.getToAccId());
    }
}
