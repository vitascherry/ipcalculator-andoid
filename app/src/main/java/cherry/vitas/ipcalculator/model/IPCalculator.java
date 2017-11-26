package cherry.vitas.ipcalculator.model;

import static cherry.vitas.ipcalculator.model.NumericConstants.OCTETS_COUNT;
import static cherry.vitas.ipcalculator.model.Octet.getDecimalRepresent;
import static cherry.vitas.ipcalculator.model.Octet.invert;
import static cherry.vitas.ipcalculator.model.Octet.parseBitSet;

class IPCalculator {

    static IPAddress calculateWildcard(IPAddress netmask) {
        IPAddress wildcard = netmask.clone();
        Octet[] wildcardOctets = wildcard.getAddress();
        Octet[] netmaskOctets = netmask.getAddress();
        for(int i = 0; i < OCTETS_COUNT; ++i)
            wildcardOctets[i] = invert(netmaskOctets[i]);
        return wildcard;
    }

    static IPAddress calculateNetwork(IPAddress address, IPAddress netmask) {
        IPAddress network = address.clone();
        Octet[] networkOctets = network.getAddress();
        Octet[] netmaskOctets = netmask.getAddress();
        for(int i = 0; i < OCTETS_COUNT; ++i)
            networkOctets[i].getBitSet().and( netmaskOctets[i].getBitSet() );
        return network;
    }

    static IPAddress calculateBroadcast(IPAddress address, IPAddress wildcard){
        IPAddress broadcast = address.clone();
        Octet[] broadcastOctets = broadcast.getAddress();
        Octet[] wildcardOctets = wildcard.getAddress();
        for(int i = 0; i < OCTETS_COUNT; ++i)
            broadcastOctets[i].getBitSet().or( wildcardOctets[i].getBitSet() );
        return broadcast;
    }

    static IPAddress calculateMinHost(IPAddress network) {
        IPAddress minHost = network.clone();
        Octet[] minHostOctets = minHost.getAddress();
        Octet lastOctet = minHostOctets[OCTETS_COUNT - 1];
        int decimalValue = 1;
        if(lastOctet.getBitSet().cardinality() != 0)
            decimalValue += getDecimalRepresent(lastOctet.getBitSet());
        lastOctet.setBitSet(parseBitSet(decimalValue));
        return minHost;
    }

    static IPAddress calculateMaxHost(IPAddress broadcast) {
        IPAddress maxHost = broadcast.clone();
        Octet lastOctet = maxHost.getAddress()[OCTETS_COUNT - 1];
        int decimalValue = getDecimalRepresent( lastOctet.getBitSet() );
        lastOctet.setBitSet(parseBitSet(decimalValue-1));
        return maxHost;
    }

    static int calculateMaxHostCount(IPAddress wildcard) {
        Octet[] wildcardOctets = wildcard.getAddress();
        int cardinality = 0;
        for(int i = 0; i < OCTETS_COUNT; ++i)
            cardinality += wildcardOctets[i].getBitSet().cardinality();
        return (1 << cardinality) - 2;
    }
}
