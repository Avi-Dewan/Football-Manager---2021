package Collections;

public class CnCount {
    private String country;
    private int count;

    public CnCount() {

    }

    public CnCount(String country, int count) {
        this.country = country;
        this.count = count;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}