package com.vsvet.example.videorentalstore.view.converter;

import com.google.common.base.Converter;
import com.vsvet.example.videorentalstore.domain.Client;
import com.vsvet.example.videorentalstore.view.ClientView;

public class ClientConverter extends Converter<Client, ClientView> {

    @Override
    protected ClientView doForward(Client client) {
        ClientView view = new ClientView();
        view.setId(client.getId());
        view.setEmail(client.getEmail());
        view.setFirstName(client.getFirstName());
        view.setLastName(client.getLastName());
        view.setPhoneNumber(client.getPhoneNumber());
        view.setBalance(client.getBalance());
        view.setBonusPoints(client.getBonusPoints());
        view.setCreatedDate(client.getCreatedDate());
        view.setModifiedDate(client.getModifiedDate());
        return view;
    }

    @Override
    protected Client doBackward(ClientView view) {
        Client client = new Client();
        client.setEmail(view.getEmail());
        client.setFirstName(view.getFirstName());
        client.setLastName(view.getLastName());
        client.setPhoneNumber(view.getPhoneNumber());
        client.setBalance(view.getBalance());
        client.setBonusPoints(view.getBonusPoints());
        return client;
    }
}
