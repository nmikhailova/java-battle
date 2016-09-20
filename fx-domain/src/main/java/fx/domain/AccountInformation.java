package fx.domain;

/**
 * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountInformation">
 * Information about account
 * </a>
 */
public class AccountInformation {
    private int accountId;
    private String accountName;
    private float balance;
    private float unrealizedPl;
    /**
     * Paper profit (or loss) that does not become actual until the underlying asset is sold,
     * redeemed, or otherwise disposed of. Also called unrealized gain/loss.
     */
    private float realizedPl;
    /**
     * Actual gain or loss that occurs when an asset (whose price as changed since it was purchased)
     * is converted into cash at fair market value in an arms length transaction. Also called realized gain/loss.
     * See also paper profit (or loss).
     */
    private float marginUsed;
    /**
     * The Margin Used represents how much of your Net Asset Value is currently held as margin against your open positions.
     * The Margin Used is equal to the position size multiplied by the Margin Requirement, summed up over all open positions.
     * This amount is then converted into the currency of the account using the current midpoint rate. See the Margin
     * Used Calculation Example below for an example on how to calculate your margin used.
     * <a href="https://www.oanda.com/resources/legal/united-states/legal/margin-rules">Section Margin Used</a>
     */
    private float marginAvail;
    /**
     * The Margin Available value is the greater of 0 and your Net Asset Value minus your Margin Used.
     * <a href="https://www.oanda.com/resources/legal/united-states/legal/margin-rules">Section Margin Available</a>
     */
    private int openTrades;
    private int openOrders;
    private float marginRate;
    /**
     * <a href="https://ru.wikipedia.org/wiki/%D0%9C%D0%B0%D1%80%D0%B6%D0%B0">Margin (RU)</a>
     * <a href="https://www.oanda.com/resources/legal/united-states/legal/margin-rates">Current margin rates</a>
     */
    private Currency accountCurrency;

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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getUnrealizedPl() {
        return unrealizedPl;
    }

    public void setUnrealizedPl(float unrealizedPl) {
        this.unrealizedPl = unrealizedPl;
    }

    public float getRealizedPl() {
        return realizedPl;
    }

    public void setRealizedPl(float realizedPl) {
        this.realizedPl = realizedPl;
    }

    public float getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(float marginUsed) {
        this.marginUsed = marginUsed;
    }

    public float getMarginAvail() {
        return marginAvail;
    }

    public void setMarginAvail(float marginAvail) {
        this.marginAvail = marginAvail;
    }

    public int getOpenTrades() {
        return openTrades;
    }

    public void setOpenTrades(int openTrades) {
        this.openTrades = openTrades;
    }

    public int getOpenOrders() {
        return openOrders;
    }

    public void setOpenOrders(int openOrders) {
        this.openOrders = openOrders;
    }

    public float getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(float marginRate) {
        this.marginRate = marginRate;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Currency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}
