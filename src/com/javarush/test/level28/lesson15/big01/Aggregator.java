package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

public class Aggregator {

    public static void main(String[] args) {

        HtmlView view = new HtmlView();

        Provider providerMoikrug = new Provider(new MoikrugStrategy());
        Provider providerHH = new Provider(new HHStrategy());


       Provider[] providers = {providerHH};

        Model model = new Model(view, providers);

        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulationMethod();

    }
}
