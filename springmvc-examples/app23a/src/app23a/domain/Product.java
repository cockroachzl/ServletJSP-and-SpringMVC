package app23a.domain;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 74458L;

    @NotNull
    @Size(min=1, max=10)
    private String name;

	private String description;
    private Float price;
    private List<MultipartFile> images;

}