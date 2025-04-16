package fr.eni.ludotheque.Genre;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
public class GenreTest {


    @Test
    void testAddClient() {
        Client client = new Client().builder().nom("nom").prenom("prenom").email("email").noTelephone("noTelephone").build();

        Assert.notNull(client, "Client not null");
        log.info(client.toString());
    }

    @Test
    void testAddClientWithAdress() {

        Client client = new Client().builder()
                .noClient(1L)
                .nom("nom")
                .prenom("prenom")
                .email("email")
                .noTelephone("noTelephone")
                .adresse(new Adresse().builder().rue("rue").codePostal("codePostal").ville("ville").build())
                .build();

        log.info(client.toString());

    }
}
