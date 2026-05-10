package clinic.model;

public class Account {
    private int accountId;
    private String username;
    private String password;
    private String fullName;
    private String role;
    private String status;

    public Account() {}

    public Account(int accountId, String username, String password, String fullName, String role, String status) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
