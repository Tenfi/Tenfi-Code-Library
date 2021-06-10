package optinal;

import optinal.models.Address;
import optinal.models.Country;
import optinal.models.User;

import java.util.Optional;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/10 18:04
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        String code = user.getAddress().getCountry().getCode();
        System.out.println(code);

        String s = Optional.ofNullable(user.getAddress().getCountry().getCode()).orElse("0");
        System.out.println(s);

        boolean present = Optional.ofNullable(user.getAddress().getCountry().getCode()).isPresent();
        System.out.println(present);


        User user1 = new User(new Address(new Country("123")));
        Optional<Integer> integer = Optional.ofNullable(user.getAddress().getCountry().getCode()).map(Integer::parseInt);
        Optional<String> code1 = Optional.ofNullable(user.getAddress().getCountry().getCode());

    }
}
