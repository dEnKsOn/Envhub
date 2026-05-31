package models;

public class ActiviteDTO {
    private String description;
    private String dateFormatee;

    public ActiviteDTO(String description, String dateFormatee) {
        this.description = description;
        this.dateFormatee = dateFormatee;
    }

    public String getDescription() {
        return description;
    }

    public String getDateFormatee() {
        return dateFormatee;
    }
}