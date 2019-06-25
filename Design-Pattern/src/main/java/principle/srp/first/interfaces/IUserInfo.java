package principle.srp.first.interfaces;

/**
 * @Auther: MayZhou
 * @Date: 19/6/25 16:40
 * @Description:
 * @copyright:
 * @version:
 */
public interface IUserInfo {
    void serUserID(String userID);

    String getUserID();

    void setPassword(String password);

    String getPassword();

    void setUserName(String userName);

    String getUserName();
    boolean changePassword(String okPasswod);
    boolean deleteUser();
    void mapUser();
    boolean addOrg(int orgID);
    boolean addRole(int roleID);
}
