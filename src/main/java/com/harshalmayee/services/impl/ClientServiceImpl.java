package com.harshalmayee.services.impl;

import com.harshalmayee.models.Client;
import com.harshalmayee.repositories.ClientRepository;
import com.harshalmayee.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(int id) {
        Optional<Client> optional = clientRepository.findById(id);
        Client client=null;
        if(optional.isPresent()){
            client=optional.get();
        }else{
            throw new RuntimeException("Client not Found :"+id);
        }
        return client;
    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}
