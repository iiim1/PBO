public interface IUserManagement {
    void displayUserInfo();
    void editProfile(String newEmail, String newPhone, String newPassword) throws IllegalArgumentException;
}