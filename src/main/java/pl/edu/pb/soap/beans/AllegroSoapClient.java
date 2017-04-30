package pl.edu.pb.soap.beans;

import com.sun.xml.internal.ws.fault.ServerSOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import sandboxwebapi.*;

import javax.xml.soap.SOAPException;

/**
 * Created by Mateusz on 27.04.2017.
 */
@Component
public class AllegroSoapClient {
    private static final Logger log = LoggerFactory.getLogger(AllegroSoapClient.class);
    public static final int POLAND_COUNTRY_CODE = 1;
    public static final String ALLEGRO_SANDBOX_KEY = "allegro.sandbox.key";

    @Autowired
    Environment env;

    ServiceService serviceService;
    ServicePort allegro;

    public AllegroSoapClient(){
        serviceService = new ServiceService();
        allegro = serviceService.getServicePort();
    }

    public String login(String username, String password){
        DoLoginResponse response = null;
        String responseString = "";
        try {
            DoQuerySysStatusResponse statusRespnose = queryServerStatus();

            DoLoginRequest loginRequest = new DoLoginRequest();
            loginRequest.setUserLogin(username);
            loginRequest.setUserPassword(password);
            loginRequest.setCountryCode(POLAND_COUNTRY_CODE);
            loginRequest.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
            loginRequest.setLocalVersion(statusRespnose.getVerKey());
            response = allegro.doLogin(loginRequest);
            responseString = response.getSessionHandlePart();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }

    private DoQuerySysStatusResponse queryServerStatus() {
        DoQuerySysStatusRequest statusRequest = new DoQuerySysStatusRequest();
        statusRequest.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
        statusRequest.setCountryId(POLAND_COUNTRY_CODE);
        statusRequest.setSysvar(3);
        return allegro.doQuerySysStatus(statusRequest);
    }

}
