package wecancatchit.werehooked.models;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

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

    @OneToMany
    private TackleShop tackleShop;

    public Water(){}

    public Water(String name, String description, Double area, Double depth, String coordinates, String image,
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
        return isPublic;
    }

    public Collection<Fish> getFish(){
        return fish;
    }

    public TackleShop getTackleShop(){
        return tackleShop;
    }

}