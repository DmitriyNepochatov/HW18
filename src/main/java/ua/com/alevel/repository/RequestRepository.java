package ua.com.alevel.repository;

import ua.com.alevel.model.Request;
import java.util.ArrayList;
import java.util.List;

public final class RequestRepository {
    private static RequestRepository instance;
    private final List<Request> requests;

    private RequestRepository() {
        requests = new ArrayList<>();
    }

    public static RequestRepository getInstance() {
        if (instance == null) {
            instance = new RequestRepository();
        }

        return instance;
    }

    public void save(Request request) {
        requests.add(request);
    }

    public List<Request> findAll() {
        return requests;
    }
}
