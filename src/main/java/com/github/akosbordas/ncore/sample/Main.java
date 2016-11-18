package com.github.akosbordas.ncore.sample;

import com.github.akosbordas.ncore.*;
import com.github.akosbordas.ncore.authentication.CredentialsProvider;
import com.github.akosbordas.ncore.search.TorrentTypeCriterion;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static com.google.common.base.Throwables.propagate;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties credentialProperties = readCredentialProperties();

        CredentialsProvider.setPassword(credentialProperties.getProperty("password"));
        CredentialsProvider.setUsername(credentialProperties.getProperty("username"));

        NcoreClient client = new DefaultNcoreClient();

        List<TorrentListElement> searchResult = client.search("inception", new TorrentTypeCriterion(TorrentType.MOVIE_SD));
        TorrentListElement torrentListElement = searchResult.get(0);

        TorrentDetails torrentDetails = client.getTorrentDetails(torrentListElement.getId());
        torrentDetails.getDescription();
        System.out.println(torrentDetails);

        client.download(torrentListElement.getId(), "c:\\tmp\\");
        System.out.println(torrentListElement.getName() + " is successfully downloaded.");
    }


    public static Properties readCredentialProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = Main.class.getClassLoader().getResourceAsStream("credential.properties");
            properties.load(input);
        } catch (IOException ex) {
            propagate(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }

}
