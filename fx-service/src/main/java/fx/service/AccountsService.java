package fx.service;

import fx.domain.Accounts;
import fx.domain.AccountInformation;

/**
 * <a href="http://developer.oanda.com/rest-live/accounts/">
 *     Information about user account
 * </a>
 */
public class AccountsService {
    /**
     * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountsForUser">
     *     Get a list of accounts owned by the user
     * </a>
     * @return Accounts
     * @throws ServiceHttpException
     */
    public Accounts getAll() throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts");
        Response resp = hb.authorization().get().execute();
        if (resp.getCode() == 200) {
            JsonSerializationService<Accounts> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), Accounts.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }

    /**
     * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountInformation">
     *     Get account information
     * </a>
     * @param accountID id of user account (can be obtained with getAll() method)
     * @return AccountInformation
     * @throws ServiceHttpException
     */
    public AccountInformation getAccountInformation(int accountID) throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts/" + accountID);
        Response resp = hb.authorization().get().execute();
        if (resp.getCode() == 200) {
            JsonSerializationService<AccountInformation> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), AccountInformation.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }

}
