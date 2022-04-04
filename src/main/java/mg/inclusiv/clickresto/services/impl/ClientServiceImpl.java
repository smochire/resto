package mg.inclusiv.clickresto.services.impl;

import mg.inclusiv.clickresto.entity.Client;
import mg.inclusiv.clickresto.repository.ClientRepository;
import mg.inclusiv.clickresto.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
