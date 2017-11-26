package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.model.NumericConstants.OCTETS_COUNT;
import static cherry.vitas.ipcalculator.model.StringConstants.DOT;
import static cherry.vitas.ipcalculator.controller.Regex.IP_ADDRESS_SEPARATOR;
import static cherry.vitas.ipcalculator.model.StringConstants.WHITESPACE;

public class IPAddress {
    private Octet[] address;

    IPAddress(String address) { this.address = parseOctets(address); }

    IPAddress(Octet[] address) { this.address = address; }

    Octet[] getAddress() { return address; }

    public void setOctets(Octet[] address) { this.address = address; }

    private static Octet[] parseOctets(String address) {
        Octet[] parsed = new Octet[OCTETS_COUNT];
        String[] values = address.split(IP_ADDRESS_SEPARATOR);
        for(int i = 0; i < OCTETS_COUNT; ++i)
            parsed[i] = new Octet(values[i]);
        return parsed;
    }

    public String toBitString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < OCTETS_COUNT; ++i) {
            s.append(address[i].toBitString());
            if(i != OCTETS_COUNT - 1)
                s.append(WHITESPACE);
        }
        return s.toString();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < OCTETS_COUNT; ++i) {
            s.append(address[i]);
            if(i != OCTETS_COUNT - 1)
                s.append(DOT);
        }
        return s.toString();
    }

    @Override
    public IPAddress clone() {
        Octet[] clonedOctets = new Octet[OCTETS_COUNT];
        for(int i = 0; i < OCTETS_COUNT; ++i)
            clonedOctets[i] = address[i].clone();
        return new IPAddress(clonedOctets);
    }
}
