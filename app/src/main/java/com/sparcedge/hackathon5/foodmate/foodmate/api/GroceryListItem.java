package com.sparcedge.hackathon5.foodmate.foodmate.api;

/**
 * Created by derickbeckwith on 8/29/15.
 */
public class GroceryListItem {
    public static String DELIMITER = ",";
    private String id;
    private int type;
    private String description;
    private Boolean checked;

    public GroceryListItem() {
    }

    public GroceryListItem(String id, int type, String description, Boolean checked) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.checked = checked;
    }

    public static GroceryListItem parse(String groceryListItem) {
        String[] parts = groceryListItem.split(DELIMITER);
        String id = parts[0];
        int type = Integer.parseInt(parts[1]);
        String description = parts[2];
        Boolean checked = false;

        if (parts[3].equals("True")) {
            checked = true;
        }

        return new GroceryListItem(id, type, description, checked);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
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
        sb.append(Integer.toString(this.type));
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
