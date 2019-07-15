package com.wk.task2spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Khalaev
 */
@XmlRootElement(name = "clients")
public class Clients {

    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    @XmlElement(name = "client")
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void add(Client client) {
        if (this.clients == null) {
            this.clients = new ArrayList<>();
        }
        this.clients.add(client);
    }
}
