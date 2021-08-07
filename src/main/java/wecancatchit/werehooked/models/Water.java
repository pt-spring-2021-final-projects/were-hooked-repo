package wecancatchit.werehooked.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.*;

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
    private String coordinates;
    private String image;
    private String type;
    private boolean isPublic;

    @ManyToMany
    private Collection<Fish> fish;

    @OneToOne
    private TackleShop tackleShop;


    public Water(String name, String description, double area, double depth, String coordinates, String image,
            String type, boolean isPublic, TackleShop tackleShop, Fish... fish) {

        this.name = name;
        this.description = description;
        this.area = area;
        this.depth = depth;
        this.coordinates = coordinates;
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
    public String getCoordinates() {
        return coordinates;
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