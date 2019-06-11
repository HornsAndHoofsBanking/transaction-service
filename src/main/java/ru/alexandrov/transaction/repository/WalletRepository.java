package ru.alexandrov.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexandrov.transaction.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    public Wallet findByAccIdAndCurrency(Long accId, String currency);
}
