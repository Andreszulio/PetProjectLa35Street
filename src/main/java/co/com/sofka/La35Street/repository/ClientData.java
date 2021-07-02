package co.com.sofka.La35Street.repository;


import org.springframework.data.annotation.Id;

public class ClientData {

    @Id
    protected String id;
    private String clientName;
    private String clientAdress;
    private String clientEmailAdress;
    private String clientTelephone;

    public ClientData(String id, String clientName, String clientAdress, String clientEmailAdress, String clientTelephone) {
        this.id = id;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientEmailAdress = clientEmailAdress;
        this.clientTelephone = clientTelephone;
    }

    public String Id() {
        return id;
    }

    public void Id(String id) {
        this.id = id;
    }

    public String ClientName() {
        return clientName;
    }

    public void ClientName(String clientName) {
        this.clientName = clientName;
    }

    public String ClientAdress() {
        return clientAdress;
    }

    public void ClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public String ClientEmailAdress() {
        return clientEmailAdress;
    }

    public void ClientEmailAdress(String clientEmailAdress) {
        this.clientEmailAdress = clientEmailAdress;
    }

    public String ClientTelephone() {
        return clientTelephone;
    }

    public void ClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }
}
