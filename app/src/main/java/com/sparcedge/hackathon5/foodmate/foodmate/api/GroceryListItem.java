package com.sparcedge.hackathon5.foodmate.foodmate.api;

/**
 * Created by derickbeckwith on 8/29/15.
 */
public class GroceryListItem {
    public static String DELIMITER = ",";
    private String id;
    private String description;
    private Boolean checked;

    public GroceryListItem(String id, String description, Boolean checked) {
        this.id = id;
        this.description = description;
        this.checked = checked;
    }

    public static GroceryListItem parse(String groceryListItem) {
        String[] parts = groceryListItem.split(DELIMITER);
        String id = parts[0];
        String description = parts[1];
        Boolean checked = false;

        if (parts[2].equals("True")) {
            checked = true;
        }

        return new GroceryListItem(id, description, checked);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChecked() {
        return this.checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String ToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.id);
        sb.append(DELIMITER);
        sb.append(this.description);
        sb.append(DELIMITER);

        if (this.checked) {
            sb.append("True");
        } else {
            sb.append("False");
        }

        return sb.toString();
    }
}
