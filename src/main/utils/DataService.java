package main.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.*;

import main.entity.Admin;
import main.entity.CheckinInfoStruct;
import main.entity.CreditCard;
import main.entity.ExtraService;
import main.entity.Flight;
import main.entity.Person;

public class DataService {
    private List<Person> allPerson;
    private List<Flight> allFlight;
    private List<ExtraService> allExtraService;
    private List<CreditCard> allCreditCard;
    private List<Admin> allAdmin;

    public DataService() {
        Resources.extractData();
        refreshData();
    }

    /**
     * @return the allPerson
     */
    public List<Person> getAllPerson() {
        return allPerson;
    }

    /**
     * @return the allFlight
     */
    public List<Flight> getAllFlight() {
        return allFlight;
    }

    /**
     * @return the allFlight
     */
    public List<CreditCard> getAllCreditCard() {
        return allCreditCard;
    }

    /**
     * @return the allExtraService
     */
    public List<ExtraService> getAllExtraService() {
        return allExtraService;
    }

    /**
     * @return the allExtraService
     */
    public List<Admin> getAllAdmin() {
        return allAdmin;
    }

    public Flight getFlightById(String id) {
        for (Flight flight : this.allFlight) {
            if (flight.getFlightNo().equals(id)) {
                return flight;
            }
        }
        return null;
    }

    public Person getPersonById(String id) {
        for (Person person : this.allPerson) {
            if (person.getBaseInfo().getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonByBookingNo(String no) {
        for (Person person : this.allPerson) {
            List<CheckinInfoStruct> checkinInfos = person.getCheckinInfo();
            for (CheckinInfoStruct checkin : checkinInfos) {
                if (checkin.getBookingNo().equals(no)) {
                    return person;
                }
            }
        }
        return null;
    }

    public ExtraService getServiceByLabel(String label) {
        for (ExtraService service : this.allExtraService) {
            if (service.getLabel().equals(label)) {
                return service;
            }
        }
        return null;
    }

    public List<ExtraService> getSeatServicesByFlightId(String id) {
        List<ExtraService> result = new ArrayList<>();
        HashSet<String> serviceLabels = new HashSet<String>();
        getFlightById(id).getAvailableExtraSeat().forEach(
                it -> {
                    serviceLabels.add(it.toString());
                });// .toArray(String[]::new)
        for (ExtraService service : this.allExtraService) {
            if (serviceLabels.contains(service.getLabel())) {
                result.add(service);
            }
        }
        return result;
    }

    public List<ExtraService> getMealServicesByFlightId(String id) {
        List<ExtraService> result = new ArrayList<>();
        HashSet<String> serviceLabels = new HashSet<String>();
        getFlightById(id).getAvailableMeal().forEach(
                it -> {
                    serviceLabels.add(it.toString());
                });// .toArray(String[]::new)
        for (ExtraService service : this.allExtraService) {
            if (serviceLabels.contains(service.getLabel())) {
                result.add(service);
            }
        }
        return result;
    }

    public CheckinInfoStruct getBookingByBookingNo(String no) {
        for (Person person : this.allPerson) {
            List<CheckinInfoStruct> checkinInfos = person.getCheckinInfo();
            for (CheckinInfoStruct checkin : checkinInfos) {
                if (checkin.getBookingNo().equals(no)) {
                    return checkin;
                }
            }
        }
        return null;
    }

    public boolean checkCreditCardPassword(String creditCardNo, String password) {
        for (CreditCard cc : this.allCreditCard) {
            if (cc.getCreditCardNo().equals(creditCardNo)) {
                if (cc.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean checkAdminPassword(String username, String password) {
        for (Admin admin : this.allAdmin) {
            if (admin.getUsername().equals(username)) {
                if (admin.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean saveData() {

        boolean f = Resources.writeStringData("flight.json", JSON.toJSONString(this.allFlight, true));
        boolean p = Resources.writeStringData("person.json", JSON.toJSONString(this.allPerson, true));
        boolean s = Resources.writeStringData("service.json", JSON.toJSONString(this.allExtraService, true));
        boolean c = Resources.writeStringData("creditCard.json", JSON.toJSONString(this.allCreditCard, true));
        return f && p && s && c;
    }

    public void refreshData() {
        this.allPerson = JSON.parseArray(Resources.readDataToString("person.json"), Person.class);
        this.allFlight = JSON.parseArray(Resources.readDataToString("flight.json"), Flight.class);
        this.allExtraService = JSON.parseArray(Resources.readDataToString("service.json"), ExtraService.class);
        this.allCreditCard = JSON.parseArray(Resources.readDataToString("creditCard.json"), CreditCard.class);
        this.allAdmin = JSON.parseArray(Resources.readDataToString("admin.json"), Admin.class);
    }
}