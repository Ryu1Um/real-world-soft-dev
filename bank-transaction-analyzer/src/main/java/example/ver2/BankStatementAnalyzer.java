package example.ver2;

import example.ver2.transaction.BankTotalTransactionSummarizer;
import example.ver2.transaction.BankTransaction;
import example.ver2.transaction.BankTransactionProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);
        collectSummary(bankTransactionProcessor);
    }

    private static void collectSummary(final BankTransactionProcessor bankTransactionProcessor) {
        System.out.println("The total for all transactions is "
                + bankTransactionProcessor.summarizeTransactions(new BankTotalTransactionSummarizer()));
        System.out.println("The total for transactions in January is "
                + bankTransactionProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "
                + bankTransactionProcessor.calculateTotalInMonth(Month.FEBRUARY));
    }
}
