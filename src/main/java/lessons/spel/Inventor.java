package lessons.spel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;

public class Inventor {
	@Value("#{systemProperties['user.name']}")
	private String nameValued;
	private String name;
	private String nationality;
	private String[] inventions;
	private Date birthdate;
	private PlaceOfBirth placeOfBirth;

	public Inventor() {
	}
	
	public Inventor(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.birthdate = new GregorianCalendar().getTime();
	}
	
	public Inventor(String name, Date birthdate, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameValued() {
        return nameValued;
    }

    public void setNameValued(String nameValued) {
        this.nameValued = nameValued;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setInventions(String[] inventions) {
        this.inventions = inventions;
    }

    public String[] getInventions() {
        return inventions;
    }
}
