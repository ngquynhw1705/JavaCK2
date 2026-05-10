package clinic.service;

import clinic.dao.AccountDAO;
import clinic.model.Account;
import clinic.util.Session;

public class AuthService {
    private AccountDAO dao = new AccountDAO();

    public boolean login(String username, String password) {
        Account a = dao.login(username, password);
        if (a == null) return false;

        Session.accountId = a.getAccountId();
        Session.username = a.getUsername();
        Session.fullName = a.getFullName();
        Session.role = a.getRole();
        return true;
    }
}
