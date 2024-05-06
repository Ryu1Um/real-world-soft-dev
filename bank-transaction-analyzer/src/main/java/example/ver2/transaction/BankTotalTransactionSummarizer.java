package example.ver2.transaction;

public class BankTotalTransactionSummarizer implements BankTransactionSummarizer {
    @Override
    public double summarize(double accumulator, BankTransaction bankTransaction) {
        return accumulator + bankTransaction.getAmount();
    }
}
