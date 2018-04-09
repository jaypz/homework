package com.jaypease.homework;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void rootShouldReturnDefaultMessage() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "text/html");
        ResponseEntity<String> entity;
        entity = this.restTemplate.exchange("http://localhost:" + port + "/", HttpMethod.GET, new HttpEntity<Void>(headers), String.class);
        assertThat(entity.getBody()).contains("Hello, World");
    }

    @Test
    public void rootShouldReturnJson() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        ResponseEntity<String> entity;
        entity = this.restTemplate.exchange("http://localhost:" + port + "/", HttpMethod.GET, new HttpEntity<Void>(headers), String.class);
        assertThat(entity.getBody()).contains("{\"message\":\"Good morning\"}");
    }


}
