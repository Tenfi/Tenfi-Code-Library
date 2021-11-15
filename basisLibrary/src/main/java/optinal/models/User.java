package optinal.models;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/10 18:01
 */
public class User {
    private Address address = new Address();

    public User() {
    }

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
