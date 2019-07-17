package com.wk.task2spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Khalaev
 */
@XmlRootElement(name = "clientList")
public class ClientList {

    private List<Client> clientList;

    public List<Client> getClientList() {
        return clientList;
    }

    @XmlElement(name = "client")
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void add(Client client) {
        if (this.clientList == null) {
            this.clientList = new ArrayList<>();
        }
        this.clientList.add(client);
    }
}
