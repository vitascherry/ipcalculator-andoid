package cherry.vitas.ipcalculator.controller;

import cherry.vitas.ipcalculator.model.Model;
import cherry.vitas.ipcalculator.view.View;

import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_IP4_ADDRESS_BINARY;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK_BINARY;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_IP4_ADDRESS;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK_VALUE;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK;
import static cherry.vitas.ipcalculator.utils.NetmaskUtils.isNumber;

public class Controller {
    private Model model;
    private View view;
    private Input input;
    private Validator validator;

    /**
     * @param input Input with get methods declared
     * @param model Model with business logic
     * @param view View with print methods
     */
    public Controller(Model model, View view, Input input) {
        this.model = model;
        this.view = view;
        this.input = input;
        this.validator = new Validator();
    }

    /**
     * Program entrypoint
     */
    public void processClickCalculate() {
        String ip = input.getIPAddress();
        String netmask = input.getNetmask();
        if (input.isBinaryInputChecked()) {
            processBinaryChecked(ip, netmask);
        } else {
            processBinaryUnchecked(ip, netmask);
        }
    }

    /**
     * Clears data and prints error message
     * @param errorMessageId error message id to print
     */
    private void processErrorInput(int errorMessageId) {
        model.clearData();
        view.printError(errorMessageId);
    }

    /**
     * Validates decimal ip4 address and decimal netmask
     * @param ip string with ip4 address
     * @param netmask string with netmask
     */
    private void processBinaryUnchecked(String ip, String netmask) {
        if (!validator.validateIPAddress(ip)) {
            processErrorInput(EXCEPTION_IP4_ADDRESS);
            return;
        }
        if (isNumber(netmask)) {
            if (!validator.validateNetmaskValue(netmask)) {
                processErrorInput(EXCEPTION_NETMASK_VALUE);
                return;
            }
        } else {
            if (!validator.validateNetmaskAddress(netmask)) {
                processErrorInput(EXCEPTION_NETMASK);
                return;
            }
        }
        calculateResultData(ip, netmask, Notation.DECIMAL);
    }

    /**
     * Validates binary ip4 address and binary netmask
     * @param ip string with binary ip4 address
     * @param netmask string with binary netmask
     */
    private void processBinaryChecked(String ip, String netmask) {
        if (!validator.validateIPAddressBinary(ip)) {
            processErrorInput(EXCEPTION_IP4_ADDRESS_BINARY);
            return;
        }
        if (!validator.validateNetmaskAddressBinary(netmask)) {
            processErrorInput(EXCEPTION_NETMASK_BINARY);
            return;
        }
        calculateResultData(ip, netmask, Notation.BINARY);
    }

    /**
     * Calculates and prints result data
     * @param ip string with ip4 address
     * @param netmask string with netmask
     * @param type notation type: binary or decimal
     */
    private void calculateResultData(String ip, String netmask, Notation type) {
        model.initCalculator(ip, netmask, type);
        model.calculateData();
        view.printIPCalculatorData(model.getData());
    }

    /**
     * Prints binary representation of calculated data
     */
    public void processClickBinary() {
        if(model.getData() != null) {
            view.printIPCalculatorDataBinary(model.getData());
        }
    }
}
