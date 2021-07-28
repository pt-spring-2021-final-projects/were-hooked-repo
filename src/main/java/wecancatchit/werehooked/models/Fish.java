package wecancatchit.werehooked.models;
import javax.persistence.*;


@Entity
public class Fish {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    private String habitat;
    private String image;
    private String season;
    private String currentRecord;
    private String bestTimeOfDay;

    @ManyToMany
    private Water water;

    @ManyToMany
    private Bait bait;

    public Fish(){}

    public Fish(String name, String description, String habitat, String image, String season, String currentRecord, String bestTimeOfDay) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.image = image;
        this.season = season;
        this.currentRecord = currentRecord;
        this.bestTimeOfDay = bestTimeOfDay;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getImage() {
        return image;
    }

    public String getSeason() {
        return season;
    }

    public String getCurrentRecord() {
        return currentRecord;
    }

    public String getBestTimeOfDay() {
        return bestTimeOfDay;
    }
}