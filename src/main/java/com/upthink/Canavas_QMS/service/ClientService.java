package com.upthink.Canavas_QMS.service;import com.upthink.Canavas_QMS.model.Client;import com.upthink.Canavas_QMS.repository.ClientRepository;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.sql.Timestamp;import java.util.List;import java.util.Optional;@Servicepublic class ClientService {    private final ClientRepository clientRepository;    public ClientService(ClientRepository clientRepository) {        this.clientRepository = clientRepository;    }    public List<Client> getAllClients() {        return clientRepository.findAllClients();    }    public Optional<Client> getClientById(int id) {        return clientRepository.findClientById(id);    }//    @Transactional//    public void saveClient(Client client) {//        clientRepository.insertClient(//                client.getName(),//                client.getCreatedAt(),//                client.getUpdatedAt(),//                client.getDeletedAt()//        );//    }//    @Transactional//    public void deleteClient(int id) {//        clientRepository.deleteClientById(id);//    }}