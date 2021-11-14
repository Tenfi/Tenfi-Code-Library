package optinal.models;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/10 18:02
 */
public class Address {
    private Country country =new Country();

    public Address() {
    }

    public Address(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
