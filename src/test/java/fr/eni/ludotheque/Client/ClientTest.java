package fr.eni.ludotheque.Client;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
public class ClientTest {

    @Test
    void testAddClient() {
        Client client = new Client().builder()
                .nom("nom")
                .prenom("prenom")
                .email("email")
                .noTelephone("noTelephone")
                .build();

        Assert.notNull(client, "Client not null");

        log.info(client.toString());
    }

    @Test
    void testAddClientWithAdress() {

        Adresse adresse = new Adresse().builder()
                .rue("rue")
                .codePostal("codePostal")
                .ville("ville")
                .build();

        Client client = new Client().builder()
                .clientId(1L)
                .nom("nom")
                .prenom("prenom")
                .email("email")
                .noTelephone("noTelephone")
                .adresse(adresse)
                .build();

        log.info(client.toString());

    }
}
