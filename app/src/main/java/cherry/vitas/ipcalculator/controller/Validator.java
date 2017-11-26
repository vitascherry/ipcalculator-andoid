package cherry.vitas.ipcalculator.controller;

import java.util.regex.Pattern;

class Validator {

    private Pattern ipAddress;
    private Pattern ipAddressBinary;
    private Pattern netmaskAddress;
    private Pattern netmaskAddressBinary;
    private Pattern netmaskValue;

    Validator() {
        ipAddress = Pattern.compile(Regex.IP4_ADDRESS);
        ipAddressBinary = Pattern.compile(Regex.IP4_ADDRESS_BINARY);
        netmaskAddress = Pattern.compile(Regex.NETMASK_ADDRESS);
        netmaskAddressBinary = Pattern.compile(Regex.NETMASK_ADDRESS_BINARY);
        netmaskValue = Pattern.compile(Regex.NETMASK_VALUE);
    }

    /**
     * Validates IP4 address with regular expression
     * @param ipAddress IP4 address
     * @return true, if ip address matches pattern, else - false
     */
    boolean validateIPAddress(String ipAddress){
        return this.ipAddress.matcher(ipAddress).matches();
    }

    /**
     * Validates binary IP4 address with regular expression
     * @param ipBinaryAddress IP4 address
     * @return true, if ip binary address matches pattern, else - false
     */
    boolean validateIPAddressBinary(String ipBinaryAddress){
        return this.ipAddressBinary.matcher(ipBinaryAddress).matches();
    }

    /**
     * Validates netmask address with regular expression
     * @param netmaskAddress Netmask address
     * @return true, if netmask address matches pattern, else - false
     */
    boolean validateNetmaskAddress(String netmaskAddress) {
        return this.netmaskAddress.matcher(netmaskAddress).matches();
    }

    /**
     * Validates binary netmask address with regular expression
     * @param netmaskBinaryAddress Netmask binary address
     * @return true, if netmask binary address matches pattern, else - false
     */
    boolean validateNetmaskAddressBinary(String netmaskBinaryAddress) {
        return this.netmaskAddressBinary.matcher(netmaskBinaryAddress).matches();
    }

    /**
     * Validates netmask value with regular expression
     * @param netmaskValue Netmask value
     * @return true, if netmask matches pattern, else - false
     */
    boolean validateNetmaskValue(String netmaskValue) {
        return this.netmaskValue.matcher(netmaskValue).matches();
    }
}
