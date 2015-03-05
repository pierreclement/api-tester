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
        api.setUrl("http://example.com");
        apis.add(api);
        return apis;
    }
}
