package wecancatchit.werehooked.models;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Fish {
    @Id
    @GeneratedValue
    @Lob
    private Long id;
    private String name;
    private String description;
    private String habitat;
    private String image;
    private String season;
    private String currentRecord;
    private String bestTimeOfDay;

    @ManyToMany
    private Collection<Water> Water;
    
    @ManyToMany
    private Collection<Bait> bait;

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

    protected Fish() {
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
        Fish other = (Fish) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}