import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CompanyType {

    private int id;
    @SerializedName("name_short")
    private String nameShort;
    @SerializedName("name_full")
    private String nameFull;

    public CompanyType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return new ToStringBuilder(this).append("id", id).append("nameShort", nameShort).append("nameFull", nameFull).toString();
    }
}
