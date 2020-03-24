import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

class Company {

    private int id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    @SerializedName("name_short")
    private String nameShort;
    private String inn;
    @SerializedName("company_type")
    private CompanyType companyType;
    private String ogrn;
    @SerializedName("egrul_date")
    private String egrulDate;
    private Country country;
    private String fioHead;
    private String address;
    private String phone;
    @SerializedName("e_mail")
    private String eMail;
    private String www;
    @SerializedName("is_resident")
    private boolean isResident;
    private List<Security> securities = new ArrayList<Security>();

    public Company() {
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

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public LocalDate getEgrulDate() {
        return LocalDate.parse(this.egrulDate);
    }

    public void setEgrulDate(String egrulDate) {
        this.egrulDate = egrulDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFioHead() {
        return fioHead;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public boolean isIsResident() {
        return isResident;
    }

    public void setIsResident(boolean isResident) {
        this.isResident = isResident;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    @Nullable
    public static LocalDate parseDate(String strDate){

        try{
            if((strDate != null) && !("").equals(strDate)){

                DateTimeFormatter parser = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd/MM/yy][dd.MM.yyyy][dd.MM.yy]");
                LocalDate date = LocalDate.parse(strDate, parser);
                return date;
            }
        } catch (NullPointerException | DateTimeParseException e) {
            System.out.println("Неправильный формат даты, попробуйте еше раз!");
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("code", code).append("nameFull", nameFull).append("nameShort", nameShort).append("inn", inn).append("companyType", companyType).append("ogrn", ogrn).append("egrulDate", egrulDate).append("country", country).append("fioHead", fioHead).append("address", address).append("phone", phone).append("eMail", eMail).append("www", www).append("isResident", isResident).append("securities", securities).toString();
    }
}
