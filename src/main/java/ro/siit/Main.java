package ro.siit;

import ro.siit.model.Utilizator;
import ro.siit.service.ServiceUtilizator;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ServiceUtilizator serviceUtilizator = new ServiceUtilizator();
        List<Utilizator> utilizators = serviceUtilizator.getUsers("fd");
        System.out.println(utilizators);

        String[] spitDate = new String[3];
        spitDate = ("2020-05-22").split("-");
        System.out.println(Integer.parseInt(spitDate[1])==5);
    }
}
