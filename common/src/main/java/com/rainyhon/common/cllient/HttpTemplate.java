package com.rainyhon.common.cllient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpTemplate {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T get(String ip, String port, String url, Class<T> t) {
        return restTemplate
                .getForEntity("http://" + ip + ":" + port + url, t)
                .getBody();
    }

    public <T> T post(String ip, String port, String url, Object param, Class<T> t) {
        return restTemplate
                .postForEntity("http://" + ip + ":" + port + url, param, t)
                .getBody();
    }

    public <T> T get(String serviceURL, Class<T> t, String ip, String port) {
        return get(serviceURL, t, restTemplate, ip, port);
    }

    public <T, V> T post(String serviceURL, V v, Class<T> t, String ip, String port) {
        return post(serviceURL, v, t, restTemplate, ip, port);
    }

    /**
     * 通用GET请求
     *
     * @param serviceURL
     * @param t
     * @return
     */
    private <T> T get(String serviceURL, Class<T> t, RestTemplate restTemplate, String ip, String port) {
        HttpHeaders headers = new HttpHeaders();
        // headers.add("access-kit-token", KIT_TOKEN);
        HttpEntity requestEntity = new HttpEntity(headers);
        String url = "http://" + ip + ":" + port + serviceURL;
        // log.info("request url[{}]", url);
        ResponseEntity<T> re = restTemplate.exchange(url, HttpMethod.GET, requestEntity, t);
        return re.getBody();
    }

    /**
     * 通用POST请求
     **/
    private <T, V> T post(String serviceURL, V v, Class<T> t, RestTemplate restTemplate, String ip, String port) {
        HttpHeaders headers = new HttpHeaders();
        // headers.add("access-kit-token", KIT_TOKEN);
        HttpEntity<V> requestEntity = new HttpEntity<>(v, headers);
        String url = "http://" + ip + ":" + port + serviceURL;
        // log.info("request url[{}],postObject[{}]", url, GSON.toJson(v));
        ResponseEntity<T> re = restTemplate.exchange(url, HttpMethod.POST,
                requestEntity, t);
        return re.getBody();
    }

}
