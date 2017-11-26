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
     * Validate ip address with regular expression
     * @param ipAddress IP address to validate
     * @return true, if ip address matches pattern, else - false
     */
    boolean validateIPAddress(String ipAddress){
        return this.ipAddress.matcher(ipAddress).matches();
    }

    /**
     * Validate ip binary address with regular expression
     * @param ipAddress IP address to validate
     * @return true, if ip binary address matches pattern, else - false
     */
    boolean validateIPAddressBinary(String ipAddress){
        return this.ipAddressBinary.matcher(ipAddress).matches();
    }

    /**
     * Validate netmask address with regular expression
     * @param netmaskAddress Netmask address to validate
     * @return true, if netmask address matches pattern, else - false
     */
    boolean validateNetmaskAddress(String netmaskAddress) {
        return this.netmaskAddress.matcher(netmaskAddress).matches();
    }

    /**
     * Validate netmask binary address with regular expression
     * @param netmaskAddress Netmask address to validate
     * @return true, if netmask binary address matches pattern, else - false
     */
    boolean validateNetmaskAddressBinary(String netmaskAddress) {
        return this.netmaskAddressBinary.matcher(netmaskAddress).matches();
    }

    /**
     * Validate netmask with regular expression
     * @param netmaskValue Netmask to validate
     * @return true, if netmask matches pattern, else - false
     */
    boolean validateNetmaskValue(String netmaskValue) {
        return this.netmaskValue.matcher(netmaskValue).matches();
    }
}