import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.time.LocalDate;

public class Security {

    private int id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    private String cfi;
    @SerializedName("date_to")
    private String dateTo;
    @SerializedName("state_reg_date")
    private String stateRegDate;
    private State state;
    private Currency currency;

    public Security() {
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

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getCfi() {
        return cfi;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public LocalDate getDateTo() {
        return LocalDate.parse(this.dateTo);
    }

    public void setDateTo(String dateTo){ this.dateTo = dateTo;}

    public String getStateRegDate() {
        return stateRegDate;
    }

    public void setStateRegDate(String stateRegDate) {
        this.stateRegDate = stateRegDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).append("code", getCode()).append("nameFull", getNameFull()).append("cfi", getCfi()).append("dateTo", getDateTo()).append("stateRegDate", getStateRegDate()).append("state", getState()).append("currency", getCurrency()).toString();
    }
}
