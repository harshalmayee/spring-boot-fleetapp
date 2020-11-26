package com.harshalmayee.services;

import com.harshalmayee.models.Client;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClients();

    public void addNewClient(Client client);

    public Client getClientById(int id);

    void delete(int id);
}
