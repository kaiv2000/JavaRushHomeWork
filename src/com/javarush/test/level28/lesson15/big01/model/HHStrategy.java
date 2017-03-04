package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Ётот класс будет реализовывать конкретную стратегию работы с сайтом ’эд’антер

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "https://hh.ua/search/vacancy?text=java+%s&page=%d";

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
                Elements elements = document.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break;

                for (Element oneVacancy : elements) {
                    Element titleElement = oneVacancy.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();


                    Element titleSalary = oneVacancy.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (titleSalary != null) {
                        salary = titleSalary.text();
                    }

                    Element cityElement = oneVacancy.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    String city = cityElement.text();

                    Element companyElement = oneVacancy.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    String company = companyElement.text();

                    if (title.contains("Junior") || title.contains("Trainee"))
                    System.out.print(title + "     " + company + "\n");

                    String site = "https://hh.ua";

                    String url = titleElement.attr("href");

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
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = null;
        try {
            document = Jsoup.connect(url).userAgent(jsoupUserAgent).referrer(jsoupReferrer).get();
        } catch (Exception e) {
        }
        return document;
    }
}
