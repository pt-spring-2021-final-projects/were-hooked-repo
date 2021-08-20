package wecancatchit.werehooked.models;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Water {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    private Double area;
    private Double depth;
    private String latitude;
    private String longitude;
    private String image;
    private String type;
    private Boolean isPublic;
    
    @OneToOne
    private TackleShop tackleShop;

    @ManyToMany
    private Collection<Fish> fish;

    public Water(String name, String description, double area, double depth, String latitude, String longitude, String image,
            String type, boolean isPublic, TackleShop tackleShop, Fish... fish) {

        this.name = name;
        this.description = description;
        this.area = area;
        this.depth = depth;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.type = type;
        this.isPublic = isPublic;
        this.tackleShop = tackleShop;
        this.fish = Arrays.asList(fish);
    }

    protected Water() {
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getArea() {
        return area;
    }
    public Double getDepth() {
        return depth;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public String getImage() {
        return image;
    }
    public String getType() {
        return type;
    }
    public boolean isPublic() {
        return true;
    }

    public TackleShop getTackleShop() {
        return tackleShop;
    }

    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Water other = (Water) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}