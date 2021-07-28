package wecancatchit.werehooked.models;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class Water {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    private String area;
    private String depth;
    private String coordinates;
    private String image;
    private String type;
    private String isPublic;

    @ManyToMany
    private Collection<Fish> fish;

    @OneToMany
    private Collection<TackleShop> tackleShop;

    public Water(){}

    public Water(String name, String description, String area, String depth, String coordinates, String image,
            String type, String isPublic) {
        this.name = name;
        this.description = description;
        this.area = area;
        this.depth = depth;
        this.coordinates = coordinates;
        this.image = image;
        this.type = type;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getArea() {
        return area;
    }
    public String getDepth() {
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
    public String isPublic() {
        return isPublic;
    }

    public Collection<Fish> getFish(){
        return fish;
    }

    public Collection<TackleShop> getTackleShop(){
        return tackleShop;
    }

}