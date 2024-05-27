package com.rest.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * Add a certificate to the cacerts keystore if it's not already included
 */
public class SslUtil {
    private static final String CACERTS_PATH = "/lib/security/cacerts";

    // NOTE: DO NOT STORE PASSWORDS IN PLAIN TEXT CODE, LOAD AT RUNTIME FROM A SECURE CONFIG
    // DEFAULT CACERTS PASSWORD IS PROVIDED HERE AS A QUICK, NOT-FOR-PRODUCTION WORKING EXAMPLE
    // ALSO, CHANGE THE DEFAULT CACERTS PASSWORD, AS IT IMPLORES YOU TO!
    private static final String CACERTS_PASSWORD = "changeit";

    /**
     * Add a certificate to the cacerts keystore if it's not already included
     *
     * @param alias The alias for the certificate, if added
     * @param certInputStream The certificate input stream
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     */
    public static void ensureSslCertIsInKeystore(String alias, InputStream certInputStream)
            throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
        //get default cacerts file
        final File cacertsFile = new File(System.getProperty("java.home") + CACERTS_PATH);
        if (!cacertsFile.exists()) {
            throw new FileNotFoundException(cacertsFile.getAbsolutePath());
        }

        //load cacerts keystore
        FileInputStream cacertsIs = new FileInputStream(cacertsFile);
        final KeyStore cacerts = KeyStore.getInstance(KeyStore.getDefaultType());
        cacerts.load(cacertsIs, CACERTS_PASSWORD.toCharArray());
        cacertsIs.close();

        //load certificate from input stream
        final CertificateFactory cf = CertificateFactory.getInstance("X.509");
        final Certificate cert = cf.generateCertificate(certInputStream);
        certInputStream.close();

        //check if cacerts contains the certificate
        if (cacerts.getCertificateAlias(cert) == null) {
            //cacerts doesn't contain the certificate, add it
            cacerts.setCertificateEntry(alias, cert);
            //write the updated cacerts keystore
            FileOutputStream cacertsOs = new FileOutputStream(cacertsFile);
            cacerts.store(cacertsOs, CACERTS_PASSWORD.toCharArray());
            cacertsOs.close();
        }
    }
}