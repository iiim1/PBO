public abstract class User implements IUserManagement {
    protected final String role;
    protected final String username;
    protected String password;
    protected String nama;
    protected String email;
    protected String telepon;

    private static int totalUsers = 0;

    public User(final String role, final String username) {
        this.role = role;
        this.username = username;
        totalUsers++;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public final String getRole() {
        return role;
    }

    public final String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    protected void login() {
        System.out.println("User " + username + " logged in");
    }

    public static boolean validateInput(String input, String type) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(type + " tidak boleh kosong");
            return false;
        }

        switch (type.toLowerCase()) {
            case "email":
                if (!input.contains("@") || !input.contains(".")) {
                    System.out.println("Format email tidak valid");
                    return false;
                }
                break;
            case "phone":
                if (!input.matches("[0-9]+")) {
                    System.out.println("Nomor telepon hanya boleh berisi angka");
                    return false;
                }
                break;
            case "password":
                if (input.length() < 6) {
                    System.out.println("Password harus minimal 6 karakter");
                    return false;
                }
                break;
        }
        return true;
    }

    @Override
    public abstract void displayUserInfo();

    @Override
    public void editProfile(String newEmail, String newPhone, String newPassword) {
        try {
            if (newEmail != null && !newEmail.isEmpty()) {
                if (!validateInput(newEmail, "email")) {
                    throw new IllegalArgumentException("Email tidak valid");
                }
                this.email = newEmail;
            }

            if (newPhone != null && !newPhone.isEmpty()) {
                if (!validateInput(newPhone, "phone")) {
                    throw new IllegalArgumentException("Nomor telepon tidak valid");
                }
                this.telepon = newPhone;
            }

            if (newPassword != null && !newPassword.isEmpty()) {
                if (!validateInput(newPassword, "password")) {
                    throw new IllegalArgumentException("Password tidak valid");
                }
                this.password = newPassword;
            }

            System.out.println(role + " profile updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to update profile: " + e.getMessage());
            throw e;
        }
    }

}