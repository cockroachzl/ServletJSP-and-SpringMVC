package app08a.model;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
//@WebListener
public class Product implements HttpSessionBindingListener {
    private String id;
    private String name;
    private double price;
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        System.out.println(attributeName + " valueBound");
    }
    
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        System.out.println(attributeName + " valueUnbound");
    }
}
