package Client;

public class Client {
    private String name;
    private Lease[] leases;

    public Client(){
        this.name = "";
        this.leases = null;
    }

    public Client(String name, Lease[] leases){
        this.name = name;
        this.leases = leases;
    }
    public Client(Client copy){
        this.name = copy.name;
        this.leases = copy.leases;
    }
    //getters and setters
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Lease[] getLease(){
        return this.leases;
    }
    public void setLease(Lease[] lease){
        this.leases = lease;
    }
    @Override
    public String toString(){
        return "Client.Client: " + this.name + " " + this.leases;
    }

    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null || getClass() != other.getClass())
            return false;

        Client client = (Client)other;

        if(!this.name.equals(client.name))
            return false;

        if(this.leases == null || client.leases == null)
            return this.leases == client.leases;

        if(this.leases.length != client.leases.length)
            return false;

        for (int i = 0; i < this.leases.length; i++) {
            if(this.leases[i]==null && client.leases[i] == null)
                continue;
            if(this.leases[i]==null || client.leases[i] == null)
                return false;
            if(!this.leases[i].equals(client.leases[i]))
                return false;
        }
        return true;

    }
}
