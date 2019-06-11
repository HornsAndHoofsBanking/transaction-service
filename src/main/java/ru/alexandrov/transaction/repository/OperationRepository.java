package ru.alexandrov.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexandrov.transaction.model.Transfer;

@Repository
public interface OperationRepository extends JpaRepository<Transfer, Long> {
}
