package example.ver2;

import example.ver2.transaction.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
