package edu.umich.api.tester.domain;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface APIRepository extends Repository<API, Long> {

    public List<API> findAll();
}
