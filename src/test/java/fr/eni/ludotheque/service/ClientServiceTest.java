package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testCreateClientWithAdresse() {
        // given
        Adresse adresse = Adresse.builder()
                .rue("rue").codePostal("codePostal").ville("ville").build();

        Client client = Client.builder()
                .nom("nom").prenom("prenom").email("email").noTelephone("noTelephone").adresse(adresse)
                .build();

        // when
        when(clientRepository.save(any(Client.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // then
        Client savedClient = clientService.create(client, adresse);
        assertThat(savedClient).isNull();
        assertThat(savedClient.getAdresse()).isEqualTo(adresse);
        //2 tests si le client existe et si il existe pas mais pour le getByName
        log.info(savedClient.toString());
    }

    @Test
    void testFindClientsByName() {
        // given
        Client client1 = Client.builder().nom("testnom").build();
        Client client2 = Client.builder().nom("testnom22").build();
        Client client3 = Client.builder().nom("tes").build();
        Client client4 = Client.builder().nom("nom").build();
        Client client5 = Client.builder().nom("testnom24").build();
        Client client6 = Client.builder().nom("testnom2").build();
        List<Client> clients = List.of(client1, client2, client3, client4,client5,client6);

        // when
        when(clientRepository.findByNom("tes")).thenReturn(clients);

        // then
        List<Client> foundClients = clientService.getByNom("tes");

        assertThat(foundClients).isNotEmpty();
        assertThat(foundClients).hasSize(6);
        assertThat(foundClients.get(0).getNom()).isEqualTo("testnom");
        log.info("Clients trouvés : {}", foundClients);
    }
}
