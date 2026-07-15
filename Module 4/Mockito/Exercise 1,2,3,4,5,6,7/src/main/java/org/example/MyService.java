package org.example;

public class MyService {

    private ExternalApi api;
    private String id;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData(String id) {
        return api.getData(id);
    }
}
