package edu.umich.api.tester.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

//public interface APIRepository extends CrudRepository<API, Long> {
@Component
public class APIRepository {

    public List<API> findAll() {
        List<API> apis = new ArrayList<>();
        API api = new API();
        List<Resource> resources = new ArrayList<Resource>();
        api.setResources(resources);
        apis.add(api);
        return apis;
    }
}
