package wecancatchit.werehooked.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Objects;

@Entity
public class TackleShop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String tackleShopAddress;
    private String tackleShopHours;

    // @ManyToOne
    @OneToOne
    private Water water;

    protected TackleShop(){}

    public TackleShop(String name, String tackleShopAddress, String tackleShopHours){
        this.name = name;
        this.tackleShopAddress = tackleShopAddress;
        this.tackleShopHours = tackleShopHours;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getTackleShopAddress(){
        return tackleShopAddress;
    }

    public String getTackleShopHours(){
        return tackleShopHours;
    }

    public Water getWater(){
        return water;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TackleShop that = (TackleShop) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
