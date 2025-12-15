package br.com.higitech.ptAcopiara.dto;

public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

    public String getCurrentPassword() { return currentPassword; }
    public String getNewPassword() { return newPassword; }
    public String getConfirmNewPassword() { return confirmNewPassword; }

    public void setCurrentPassword(String currentPassword) { this.currentPassword = currentPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
    public void setConfirmNewPassword(String confirmNewPassword) { this.confirmNewPassword = confirmNewPassword; }
}
