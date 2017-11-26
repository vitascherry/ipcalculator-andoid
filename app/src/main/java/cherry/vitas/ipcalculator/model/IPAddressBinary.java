package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.controller.Regex.IP_ADDRESS_BINARY_SEPARATOR;
import static cherry.vitas.ipcalculator.model.NumericConstants.OCTETS_COUNT;

class IPAddressBinary extends IPAddress {

    IPAddressBinary(String address) {
        super(parseOctets(address));
    }

    private static Octet[] parseOctets(String address) {
        Octet[] parsed = new OctetBinary[OCTETS_COUNT];
        String[] values = address.split(IP_ADDRESS_BINARY_SEPARATOR);
        for (int i = 0; i < OCTETS_COUNT; ++i)
            parsed[i] = new OctetBinary(values[i]);
        return parsed;
    }
}
