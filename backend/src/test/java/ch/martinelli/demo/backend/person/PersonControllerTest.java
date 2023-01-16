package ch.martinelli.demo.backend.person;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void findAll() {
        Person[] persons = testRestTemplate.getForObject("/api/persons", Person[].class);

        Assertions.assertThat(persons).hasSize(2);
    }

    @Test
    @Transactional
    void save() {
        Person person = new Person();
        person.setName("Hello");

        testRestTemplate.postForObject("/api/demos", person, Person.class);
    }

}