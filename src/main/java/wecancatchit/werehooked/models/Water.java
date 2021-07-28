package wecancatchit.werehooked.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Water {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    private double area;
    private double depth;
    private String coordinates;
    private String image;
    private String type;
    private boolean isPublic;
    public Water(String name, String description, double area, double depth, String coordinates, String image,
            String type, boolean isPublic) {
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
}