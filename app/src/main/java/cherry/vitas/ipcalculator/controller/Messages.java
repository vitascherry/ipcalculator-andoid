package cherry.vitas.ipcalculator.controller;

interface Messages {
    String EXCEPTION_IP4_ADDRESS =
            "IP address should match the pattern [0-255].[0-255].[0-255].[0-255]";
    String EXCEPTION_IP4_ADDRESS_BINARY =
            "IP address should match the pattern [0-11111111]";
    String EXCEPTION_NETMASK =
            "Netmask value should be integer number from 1 to 32";
    String EXCEPTION_NETMASK_ADDRESS =
            "Netmask octets should match the pattern [0|128|192|224|240|248|252|254]";
    String EXCEPTION_NETMASK_BINARY_ADDRESS =
            "Netmask octets should match the pattern [0|1000|1100|1110|1111|]";
}
