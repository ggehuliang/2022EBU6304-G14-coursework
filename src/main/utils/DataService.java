package main.utils;

import java.util.HashSet;

import com.alibaba.fastjson.*;

public class DataService {
    private JSONArray allPerson;
    private JSONArray allFlight;
    private JSONArray allExtraService;

    public DataService() {
        refreshData();
    }

    public JSONArray getAllPerson() {
        return allPerson;
    }

    public JSONArray getAllFlight() {
        return allFlight;
    }

    public JSONArray getAllExtraService() {
        return allExtraService;
    }

    public JSONObject getFlightById(String id) {
        for (int i = 0; i < this.allFlight.size(); i++) {
            JSONObject flight = this.allFlight.getJSONObject(i);
            if (flight.getString("flightNo").equals(id)) {
                return flight;
            }
        }
        return null;
    }

    public JSONObject getPersonById(String id) {
        for (int i = 0; i < this.allPerson.size(); i++) {
            JSONObject person = this.allPerson.getJSONObject(i);
            if (person.getJSONObject("baseInfo").getString("id").equals(id)) {
                return person;
            }
        }
        return null;
    }

    public JSONObject getPersonByBookingNo(String no) {
        for (int i = 0; i < this.allPerson.size(); i++) {
            JSONObject person = this.allPerson.getJSONObject(i);
            JSONArray checkinInfos = person.getJSONArray("checkinInfo");
            for (int j = 0; j < checkinInfos.size(); j++) {
                JSONObject checkin = checkinInfos.getJSONObject(j);
                if (checkin.getString("bookingNo").equals(no)) {
                    return person;
                }
            }
        }
        return null;
    }

    public JSONObject getServiceByLabel(String label) {
        for (int i = 0; i < this.allExtraService.size(); i++) {
            JSONObject service = this.allExtraService.getJSONObject(i);
            if (service.getString("label").equals(label)) {
                return service;
            }
        }
        return null;
    }

    public JSONArray getSeatServicesByFlightId(String id) {
        JSONArray result = new JSONArray();
        HashSet<String> serviceLabels = new HashSet<String>();
        getFlightById(id).getJSONArray("availableExtraSeat").forEach(
                it -> {
                    serviceLabels.add(it.toString());
                });// .toArray(String[]::new)
        for (int i = 0; i < this.allExtraService.size(); i++) {
            JSONObject service = this.allExtraService.getJSONObject(i);
            if (serviceLabels.contains(service.getString("label"))) {
                result.add(service);
            }
        }
        return result;
    }

    public JSONArray getMealServicesByFlightId(String id) {
        JSONArray result = new JSONArray();
        HashSet<String> serviceLabels = new HashSet<String>();
        getFlightById(id).getJSONArray("availableMeal").forEach(
                it -> {
                    serviceLabels.add(it.toString());
                });
        for (int i = 0; i < this.allExtraService.size(); i++) {
            JSONObject service = this.allExtraService.getJSONObject(i);
            if (serviceLabels.contains(service.getString("label"))) {
                result.add(service);
            }
        }
        return result;
    }

    public JSONObject getBookingByBookingNo(String no) {
        for (int i = 0; i < this.allPerson.size(); i++) {
            JSONObject person = this.allPerson.getJSONObject(i);
            JSONArray checkinInfos = person.getJSONArray("checkinInfo");
            for (int j = 0; j < checkinInfos.size(); j++) {
                JSONObject checkin = checkinInfos.getJSONObject(j);
                if (checkin.getString("bookingNo").equals(no)) {
                    return checkin;
                }
            }
        }
        return null;
    }

    public boolean saveData() {

        boolean f = Resources.writeStringData("flight.json", JSON.toJSONString(this.allFlight, true));
        boolean p = Resources.writeStringData("person.json", JSON.toJSONString(this.allPerson, true));
        return f && p;
    }

    public void refreshData() {
        this.allPerson = JSON.parseArray(Resources.readDataToString("person.json"));
        this.allFlight = JSON.parseArray(Resources.readDataToString("flight.json"));
        this.allExtraService = JSON.parseArray(Resources.readDataToString("service.json"));
    }
}