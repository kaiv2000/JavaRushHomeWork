package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HtmlView implements View {

    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String filecontent = "";

        try {
            Document document = getDocument();
            Element template = document.select(".template").first();
            Element copyTemplate = template.clone();

            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            document.select("tr[class=vacancy]").remove();

            for (Vacancy oneVacancy : vacancies)
            {
                Element jobTemplate = copyTemplate.clone();

                Element cityElement = jobTemplate.select("td[class=city]").first();
                cityElement.text(oneVacancy.getCity());

                Element companyElement = jobTemplate.select("td[class=companyName]").first();
                companyElement.text(oneVacancy.getCompanyName());

                Element salaryElement = jobTemplate.select("td[class=salary]").first();
                salaryElement.text(oneVacancy.getSalary());

                Element titleElement = jobTemplate.getElementsByTag("a").first();
                titleElement.text(oneVacancy.getTitle());
                titleElement.attr("href", oneVacancy.getUrl());

                template.before(jobTemplate.outerHtml());
            }
            filecontent = document.html();
        } catch (IOException e) {
            e.printStackTrace();
            filecontent = "Some exception occurred";
        }
        return filecontent;
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String fileContent) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(fileContent);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Lviv");
    }

}
