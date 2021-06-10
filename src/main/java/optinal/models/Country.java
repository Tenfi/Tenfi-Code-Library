package optinal.models;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/10 18:02
 */
public class Country {
    private String code=null;

    public Country() {
    }

    public Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
