import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

        private Gson gson = new Gson();
        private List<Company> companies;

    {
        try {
            companies = gson.fromJson(new FileReader(new File("src/main/resources/test.json")), new TypeToken<List<Company>>() {}.getType());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }

    private List<Company> companyList = companies;

    private App(){ }

    private void compNames(){

        System.out.println("Названия компаний и дата основания: \n");
        companyList.stream()
                .map(company -> String.format("%s - %s;", company.getNameShort(), company.getEgrulDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))))
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private void getСancelledSecuritiess(){

        long total = companyList.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(x -> x.getDateTo().isBefore(LocalDate.now()))
                .count();

        System.out.println("Просроченные ценные бумаги компаний: \n");
        System.out.println("Общее количество просроченных бумаг: " + total + "\n");

        companyList.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(x -> x.getDateTo().isBefore(LocalDate.now()))
                .map(security -> String.format("code = {%s}, date_to = {%s}, full_name = {%s};", security.getCode(),security.getDateTo(), security.getNameFull()))
                .forEach(System.out::println);

        System.out.println("\n");
    }

    private void compAfterDate(String date){

        System.out.println("Компании основанные после: " + date + "\n");
        companyList.stream()
                .filter(company -> company.getEgrulDate().isAfter(Company.parseDate(date)))
                .map(company -> String.format("short_name = {%s}, creation_date = {%s};",company.getNameShort(), company.getEgrulDate()))
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private void currencyCode(String code){

        System.out.println("Ценные бумаги в: " + code + "\n");
        companyList.stream()
                .map(Company::getSecurities)
                .flatMap(Collection::stream)
                .filter(security -> security.getCurrency().getCode().equals(code))
                .map(security -> String.format("id = {%s}, code = {%s};", security.getId(),security.getCode()))
                .forEach(System.out::println);

        System.out.println("\n");
    }

    public static void main(String[] args) {

        App app = new App();

        app.compNames();

        app.getСancelledSecuritiess();

        app.compAfterDate("15.12.2000");
        app.compAfterDate("02.09.14");
        app.compAfterDate("02/09/2005");
        app.compAfterDate("02/09/03");

        app.currencyCode("USD");
        app.currencyCode("RUB");
        app.currencyCode("EUR");
    }
}
