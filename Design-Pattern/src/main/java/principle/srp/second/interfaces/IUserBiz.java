package principle.srp.second.interfaces;

/**
 * @author MayZhou
 */
public interface IUserBiz {
    boolean changePassword(String okPasswod);
    boolean deleteUser();
    void mapUser();
    boolean addOrg(int orgID);
    boolean addRole(int roleID);
}
