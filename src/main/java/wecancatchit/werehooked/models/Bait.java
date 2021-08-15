package wecancatchit.werehooked.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bait {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String image;
    private String shopLink;
    private String howToUse;

    @ManyToMany
    private Collection<Fish> fish;

    protected Bait(){}

    public Bait(String name, String image, String shopLink, String howToUse){
        this.name = name;
        this.image = image;
        this.shopLink = shopLink;
        this.howToUse = howToUse;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getImage(){
        return image;
    }

    public String getShopLink(){
        return shopLink;
    }

    public String getHowToUse(){
        return howToUse;
    }

    public Collection<Fish> getFish(){
        return fish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bait bait = (Bait) o;
        return Objects.equals(id, bait.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}