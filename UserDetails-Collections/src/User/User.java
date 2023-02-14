package User;

public class User {
    private String userName;
    private int userId;
    public User(int u_id,String u_name ){
        this.userName =u_name;
        this.userId =u_id;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + userId + '\'' +
                ", username=" + userName +
                '}';
    }
}
