package org.alf.study.service;

import org.alf.study.model.Greeting;

public interface HelloService extends Service {

    public Greeting index(String param);

    public Greeting path(String name);

    public String returning(String name);
    
}
