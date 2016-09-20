package fx.domain;

/**
 * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountsForUser">
 * Get a list of accounts owned by the user
 * </a>
 */
public class Account {
    private int accountId;
    private String accountName;
    private Currency accountCurrency;
    private float marginRate;

    /**
     * <a href="https://ru.wikipedia.org/wiki/%D0%9C%D0%B0%D1%80%D0%B6%D0%B0">Margin (RU)</a>
     * <a href="https://www.oanda.com/resources/legal/united-states/legal/margin-rates">Current margin rates</a>
     */

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Currency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public float getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(float marginRate) {
        this.marginRate = marginRate;
    }
}
