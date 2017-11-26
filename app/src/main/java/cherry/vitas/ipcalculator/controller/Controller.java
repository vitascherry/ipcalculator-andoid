package cherry.vitas.ipcalculator.controller;

import cherry.vitas.ipcalculator.model.Model;
import cherry.vitas.ipcalculator.view.View;

import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_IP4_ADDRESS_BINARY;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK_BINARY_ADDRESS;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_IP4_ADDRESS;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK;
import static cherry.vitas.ipcalculator.controller.Messages.EXCEPTION_NETMASK_ADDRESS;
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
     * Validates ip and netmask and calculates result data
     */
    public void processClickCalculate() {
        String ip = input.getIP();
        String netmask = input.getNetmask();

        if (input.getIPBinaryChecked()) {
            processBinaryChecked(ip, netmask);
        } else {
            if (!validator.validateIPAddress(ip)) {
                view.printError(EXCEPTION_IP4_ADDRESS);
                model.clearData();
                return;
            }
            if (isNumber(netmask)) {
                if (!validator.validateNetmaskValue(netmask)) {
                    view.printError(EXCEPTION_NETMASK);
                    model.clearData();
                    return;
                }
            } else {
                if (!validator.validateNetmaskAddress(netmask)) {
                    view.printError(EXCEPTION_NETMASK_ADDRESS);
                    model.clearData();
                    return;
                }
            }
            model.initCalculator(ip, netmask, Notation.DECIMAL);
            model.calculateData();
            view.printIPCalculatorData(model.getData());
        }
    }

    /**
     * Validates binary ip and binary netmask and calculates result data
     */
    private void processBinaryChecked(String ip, String netmask) {
        if (!validator.validateIPAddressBinary(ip)) {
            view.printError(EXCEPTION_IP4_ADDRESS_BINARY);
            model.clearData();
            return;
        }
        if (!validator.validateNetmaskAddressBinary(netmask)) {
            view.printError(EXCEPTION_NETMASK_BINARY_ADDRESS);
            model.clearData();
            return;
        }
        model.initCalculator(ip, netmask, Notation.BINARY);
        model.calculateData();
        view.printIPCalculatorData(model.getData());
    }

    /**
     * Prints binary representation of data
     */
    public void processClickBinary() {
        if(model.getData() != null) {
            view.printIPCalculatorDataBinary(model.getData());
        }
    }
}
