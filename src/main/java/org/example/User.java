//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    public String GetUsername() {
        return this.username;
    }

    public String GetEmail() {
        return this.email;
    }

    public byte[] GetPasswordHash() {
        return this.passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String password) {
        HashCreator hc = new HashCreator();
        this.passwordHash = hc.createMD5Hash(password);
    }

    public int hashCode() {
        String str = this.username + this.email + this.passwordHash.toString();
        int h = 0;
        int k = 130;
        int mod = '耀';
        int kPowered = 1;

        for(int ch = 0; ch < str.length(); ++ch) {
            int tmpCh = str.charAt(ch) - 97 + 1;
            h = (h + kPowered * tmpCh) % mod;
            kPowered = k * kPowered % mod;
        }

        return h;
    }

    public boolean equals(User user) {
        return user.hashCode() == this.hashCode();
    }

    User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        HashCreator hc = new HashCreator();
        this.passwordHash = hc.createMD5Hash(password);
    }
}
