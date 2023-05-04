package org.example;

import java.util.List;
import java.util.ListIterator;

public class App
{
    public static void main(String[] args)
    {
        Users user = new Users("Taras", "Audi", "Q7");

        CRUDMethods.create(user);

        List<Users> users_list = CRUDMethods.read("SELECT * FROM car_owners");
        for (Users value : users_list) {
            System.out.println(value.toString());
        }

        CRUDMethods.updateCar(users_list.get(users_list.size() - 1).getDBid(), "Porsche", "Macan");

        users_list = CRUDMethods.read("SELECT * FROM car_owners");
        for (Users users : users_list) {
            System.out.println(users.toString());
        }

        CRUDMethods.delete(users_list.get(users_list.size() - 1));
    }
}
