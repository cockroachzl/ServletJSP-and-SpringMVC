package app20a.domain;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 748392348L;
	private String name;
    private String description;
    private Float price;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}