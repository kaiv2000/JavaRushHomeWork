package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        try {
            int pageNumber = 0;
            Document document;
            while (true)
            {
                document = getDocument(searchString, pageNumber++);
                if (document == null) break;

                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;

                for (Element oneVacancy : elements) {
                    Element titleElement = oneVacancy.getElementsByClass("title").first();
                    String title = titleElement.text();

                    Element titleSalary = oneVacancy.getElementsByClass("salary").first();
                    String salary = "";
                    if (titleSalary != null) {
                        salary = titleSalary.text();
                    }

                    Element cityElement =  oneVacancy.getElementsByClass("location").first();
                    String city = "";
                    if (cityElement != null) {
                        city = cityElement.text();
                    }

                    Element companyElement = oneVacancy.getElementsByClass("company_name").first();
                    String company = companyElement.text();

                    String site = "http://moikrug.ru/";

                    String url = "https://moikrug.ru" + titleElement.getElementsByTag("a").attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setCity(city);
                    vacancy.setCompanyName(company);
                    vacancy.setSalary(salary);
                    vacancy.setSiteName(site);
                    vacancy.setTitle(title);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String jsoupUserAgent = "Mozilla/5.0 jsoup";
        String jsoupReferrer = "www.google.com.ua";
        String url = String.format(URL_FORMAT, page, searchString);
        Document document = null;
        try {
            document = Jsoup.connect(url).userAgent(jsoupUserAgent).referrer(jsoupReferrer).get();
        } catch (Exception e) {
        }
        return document;
    }

}
