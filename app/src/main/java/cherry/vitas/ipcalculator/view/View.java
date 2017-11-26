package cherry.vitas.ipcalculator.view;

import android.widget.TextView;

import cherry.vitas.ipcalculator.model.IPCalculatorData;

public class View {
    private TextView mErrorMassage;
    private TextView mIPAddressValue;
    private TextView mIPAddressBitString;
    private TextView mNetmaskValue;
    private TextView mNetmaskBitString;
    private TextView mWildcardValue;
    private TextView mWildcardBitString;
    private TextView mNetworkValue;
    private TextView mNetworkBitString;
    private TextView mBroadcastValue;
    private TextView mBroadcastBitString;
    private TextView mMinHostValue;
    private TextView mMinHostBitString;
    private TextView mMaxHostValue;
    private TextView mMaxHostBitString;
    private TextView mMaxHostCountValue;

    public void setErrorMassage(TextView mErrorMassage) {
        this.mErrorMassage = mErrorMassage;
    }

    public void setIPAddressValue(TextView mIPAddressValue) {
        this.mIPAddressValue = mIPAddressValue;
    }

    public void setIPAddressBitString(TextView mIPAddressBitString) {
        this.mIPAddressBitString = mIPAddressBitString;
    }

    public void setNetmaskValue(TextView mNetmaskValue) {
        this.mNetmaskValue = mNetmaskValue;
    }

    public void setNetmaskBitString(TextView mNetmaskBitString) {
        this.mNetmaskBitString = mNetmaskBitString;
    }

    public void setWildcardValue(TextView mWildcardValue) {
        this.mWildcardValue = mWildcardValue;
    }

    public void setWildcardBitString(TextView mWildcardBitString) {
        this.mWildcardBitString = mWildcardBitString;
    }

    public void setNetworkValue(TextView mNetworkValue) {
        this.mNetworkValue = mNetworkValue;
    }

    public void setNetworkBitString(TextView mNetworkBitString) {
        this.mNetworkBitString = mNetworkBitString;
    }

    public void setBroadcastValue(TextView mBroadcastValue) {
        this.mBroadcastValue = mBroadcastValue;
    }

    public void setBroadcastBitString(TextView mBroadcastBitString) {
        this.mBroadcastBitString = mBroadcastBitString;
    }

    public void setMinHostValue(TextView mMinHostValue) {
        this.mMinHostValue = mMinHostValue;
    }

    public void setMinHostBitString(TextView mMinHostBitString) {
        this.mMinHostBitString = mMinHostBitString;
    }

    public void setMaxHostValue(TextView mMaxHostValue) {
        this.mMaxHostValue = mMaxHostValue;
    }

    public void setMaxHostBitString(TextView mMaxHostBitString) {
        this.mMaxHostBitString = mMaxHostBitString;
    }

    public void setMaxHostCountValue(TextView mMaxHostCountValue) {
        this.mMaxHostCountValue = mMaxHostCountValue;
    }

    public void clearTextView() {
        mErrorMassage.setText("");
        mIPAddressValue.setText("");
        mNetmaskValue.setText("");
        mWildcardValue.setText("");
        mNetworkValue.setText("");
        mBroadcastValue.setText("");
        mMinHostValue.setText("");
        mMaxHostValue.setText("");
        mMaxHostCountValue.setText("");
        mIPAddressBitString.setText("");
        mNetmaskBitString.setText("");
        mWildcardBitString.setText("");
        mNetworkBitString.setText("");
        mBroadcastBitString.setText("");
        mMinHostBitString.setText("");
        mMaxHostBitString.setText("");
    }

    public void printError(String message) {
        mErrorMassage.setText(message);
    }

    public void printIPCalculatorData(IPCalculatorData data) {
        mIPAddressValue.setText(data.getAddress().toString());
        mNetmaskValue.setText(data.getNetmask().toString());
        mWildcardValue.setText(data.getWildcard().toString());
        mNetworkValue.setText(data.getNetwork().toString());
        mBroadcastValue.setText(data.getBroadcast().toString());
        mMinHostValue.setText(data.getMinHost().toString());
        mMaxHostValue.setText(data.getMaxHost().toString());
        mMaxHostCountValue.setText(String.valueOf(data.getMaxHostCount()));
    }

    public void printIPCalculatorDataBinary(IPCalculatorData data) {
        mIPAddressBitString.setText(data.getAddress().toBitString());
        mNetmaskBitString.setText(data.getNetmask().toBitString());
        mWildcardBitString.setText(data.getWildcard().toBitString());
        mNetworkBitString.setText(data.getNetwork().toBitString());
        mBroadcastBitString.setText(data.getBroadcast().toBitString());
        mMinHostBitString.setText(data.getMinHost().toBitString());
        mMaxHostBitString.setText(data.getMaxHost().toBitString());
    }
}
