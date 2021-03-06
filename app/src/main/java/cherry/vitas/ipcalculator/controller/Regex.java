package cherry.vitas.ipcalculator.controller;

public interface Regex {
    String IP_ADDRESS_BINARY_SEPARATOR = " ";
    String IP_ADDRESS_SEPARATOR = "\\.";
    String NETMASK_VALUE =
            "^([1-9]|[1-2][0-9]|3[0-2])$";
    String NETMASK_ADDRESS =
            "^((128|192|224|240|248|252|254)\\.0\\.0\\.0)" +
            "|(255\\.(0|128|192|224|240|248|252|254)\\.0\\.0)" +
            "|(255\\.255\\.(0|128|192|224|240|248|252|254)\\.0)" +
            "|(255\\.255\\.255\\.(0|128|192|224|240|248|252|254))$";
    String NETMASK_ADDRESS_BINARY =
            "^((10000000|11000000|11100000|11110000|11111000|11111100|11111100|11111110)\\u0020(0|0{8})\\u0020(0|0{8})\\u0020(0|0{8}))" +
            "|(11111111\\u0020((0|0{8})|10000000|11000000|11100000|11110000|11111000|11111100|11111100|11111110)\\u0020(0|0{8})\\u0020(0|0{8}))" +
            "|(11111111\\u002011111111\\u0020((0|0{8})|10000000|11000000|11100000|11110000|11111000|11111100|11111100|11111110)\\u0020(0|0{8}))" +
            "|(11111111\\u002011111111\\u002011111111\\u0020((0|0{8})|10000000|11000000|11100000|11110000|11111000|11111100|11111100|11111110))" +
            "|(11111111\\u002011111111\\u002011111111\\u002011111111)$";
    String IP4_ADDRESS =
            "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
            "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    String IP4_ADDRESS_BINARY =
            "^(0|[01]{8})\\u0020(0|[01]{8})\\u0020(0|[01]{8})\\u0020(0|[01]{8})$";
}
