package meet5.models;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    private String fullName;
    private int age;
    private Map<String, Object> additionalFields;

    public UserProfile(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        this.additionalFields = new HashMap<>();
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        if (isValidfullName(fullName)) {
            this.fullName = fullName;
        } else {
            throw new IllegalArgumentException("Invalid fullName");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (isValidAge(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public Map<String, Object> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalField(String key, Object value) {
        if (isValidAdditionalField(key, value)) {
            this.additionalFields.put(key, value);
        } else {
            throw new IllegalArgumentException("Invalid additional field: Key and value must be non-null.");
        }
    }

    //Validations
    private boolean isValidfullName(String fullName) {
        return fullName != null && !fullName.isEmpty() && fullName.length() <= 255;
    }

    private boolean isValidAge(int age) {
        return age > 0;
    }

    private boolean isValidAdditionalField(String key, Object value) {
        return key != null && !key.isEmpty() && value != null;
    }

}
