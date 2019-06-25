package principle.srp.second.interfaces;

/**
 * @Auther: MayZhou
 * @Date: 19/6/25 16:50
 * @Description:
 * @copyright:
 * @version:
 */
public interface IUserBO {
    void serUserID(String userID);

    String getUserID();

    void setPassword(String password);

    String getPassword();

    void setUserName(String userName);

    String getUserName();
}
