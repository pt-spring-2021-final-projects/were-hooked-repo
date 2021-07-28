package wecancatchit.werehooked.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

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
}
public Water(String name, String description, double area, double depth, String coordinates, String image, String type, boolean isPublic){
    this.name = name;
    this.description = description;
    this.area =area;
    this.depth = depth;
    this.coordinates = coordinates;
    this.image = image;
    this.type =type;
    this.isPublic = isPublic;
}
public string getName() return name;
public string getDescription() return description;
public string getArea() return area;
public string getDepth() return depth;
public string getCoordinates() return coordinates;
public string getImage() return image;
public string getType() return type;
public boolean getisPublic

