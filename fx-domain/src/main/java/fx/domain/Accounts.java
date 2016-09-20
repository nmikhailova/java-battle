package fx.domain;

import java.util.List;

/**
 * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountsForUser">
 * Get a list of accounts owned by the user
 * </a>
 */
public class Accounts {
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
