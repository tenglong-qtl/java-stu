package org.zicheng.stu.basis.object;

/**
 * Author: T.L. QIU
 * Date: 2020-11-27 15:51.
 */
public class UserDTO {
    private Long id;
    private String userName;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
