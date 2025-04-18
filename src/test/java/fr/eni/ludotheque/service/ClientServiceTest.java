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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ClientServiceTest {

    @MockitoBean
    private ClientRepository clientRepository;

    @Autowired
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
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        // then
        Client savedClient = clientService.create(client, adresse);

        log.info(savedClient.toString());
    }


}
