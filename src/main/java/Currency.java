import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Currency {

    private int id;
    private String code;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public Currency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("code", code).append("nameShort", nameShort).append("nameFull", nameFull).toString();
    }
}