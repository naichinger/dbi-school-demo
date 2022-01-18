package at.htl.control;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class InitBean {
    public void init(@Observes StartupEvent event) {
        //TODO: add algorithm to add sample data with existing data from import.sql
    }
}
