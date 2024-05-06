package example.ver2.transaction;

import java.time.Month;

public class BankTransactionlsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;

    }
}
