package cherry.vitas.ipcalculator.model;

public class IPCalculatorData {

    private IPAddress address;
    private IPAddress netmask;
    private IPAddress wildcard;
    private IPAddress network;
    private IPAddress broadcast;
    private IPAddress minHost;
    private IPAddress maxHost;
    private int maxHostCount;
    private int netmaskValue;

    public IPAddress getAddress() {
        return address;
    }

    void setAddress(IPAddress address) {
        this.address = address;
    }

    public IPAddress getNetmask() {
        return netmask;
    }

    void setNetmask(IPAddress netmask) {
        this.netmask = netmask;
    }

    public IPAddress getWildcard() {
        return wildcard;
    }

    void setWildcard(IPAddress wildcard) {
        this.wildcard = wildcard;
    }

    public IPAddress getNetwork() {
        return network;
    }

    void setNetwork(IPAddress network) {
        this.network = network;
    }

    public IPAddress getBroadcast() {
        return broadcast;
    }

    void setBroadcast(IPAddress broadcast) {
        this.broadcast = broadcast;
    }

    public IPAddress getMinHost() {
        return minHost;
    }

    void setMinHost(IPAddress minHost) {
        this.minHost = minHost;
    }

    public IPAddress getMaxHost() {
        return maxHost;
    }

    void setMaxHost(IPAddress maxHost) {
        this.maxHost = maxHost;
    }

    public int getMaxHostCount() {
        return maxHostCount;
    }

    void setMaxHostCount(int maxHostCount) {
        this.maxHostCount = maxHostCount;
    }

    int getNetmaskValue() {
        return netmaskValue;
    }

    void setNetmaskValue(int netmaskValue) {
        this.netmaskValue = netmaskValue;
    }
}
