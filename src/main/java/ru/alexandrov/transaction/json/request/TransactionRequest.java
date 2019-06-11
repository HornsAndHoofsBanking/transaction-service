package ru.alexandrov.transaction.json.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TransactionRequest {
    @JsonProperty("from_acc_id")
    private long fromAccId;
    @JsonProperty("to_acc_id")
    private long toAccId;
    @JsonProperty("currency_from")
    private String currencyFrom;
    @JsonProperty("currency_to")
    private String currencyTo;
    private int amount;
}
