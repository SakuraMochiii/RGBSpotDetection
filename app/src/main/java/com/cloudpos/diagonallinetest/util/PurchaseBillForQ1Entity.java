package com.cloudpos.diagonallinetest.util;


import com.cloudpos.sdk.util.StringUtility;

import java.io.Serializable;

public class PurchaseBillForQ1Entity implements Serializable {
    private static final long serialVersionUID = 1L;

//	private String merchantCopy;			//merchant stubs

    private String merchantName;        //merchant name

    private String merchantNo;                //merchant no

    private String terminalNoAndOperator;                //terminalNo and OperatorNo

//	private String operator;				//operator no

    private String cardNo;                        //cardNo

    private String issuerAndAcquirer;                            //issuer or Acquirer

//	private String acquirer;						//acquirer

    private String transType;                    //transType

    public String getIssuerAndAcquirer() {
        return issuerAndAcquirer;
    }

    public void setIssuerAndAcquirer(String issuerAndAcquirer) {
        this.issuerAndAcquirer = issuerAndAcquirer;
    }

    public String getDataTimeAndExpDate() {
        return dataTimeAndExpDate;
    }

    public void setDataTimeAndExpDate(String dataTimeAndExpDate) {
        this.dataTimeAndExpDate = dataTimeAndExpDate;
    }

    public String getRefNoAndBatchNo() {
        return refNoAndBatchNo;
    }

    public void setRefNoAndBatchNo(String refNoAndBatchNo) {
        this.refNoAndBatchNo = refNoAndBatchNo;
    }

    public String getVoucherAndAuthNo() {
        return voucherAndAuthNo;
    }

    public void setVoucherAndAuthNo(String voucherAndAuthNo) {
        this.voucherAndAuthNo = voucherAndAuthNo;
    }

    private String dataTimeAndExpDate;

//	private String expDate;						//expire date

    private String refNoAndBatchNo;

//	private String batchNo;						//batchNo

    private String voucherAndAuthNo;                    //voucherNo and authNo

//	private String authNo;						//authNo

    private String amount;                            //amount

    private String reference;                    //reference

    public boolean checkValidity() {

        if (StringUtility.isEmpty(merchantName)
                || StringUtility.isEmpty(merchantNo)
                || StringUtility.isEmpty(terminalNoAndOperator)
                || StringUtility.isEmpty(cardNo)
                || StringUtility.isEmpty(transType)
                || StringUtility.isEmpty(dataTimeAndExpDate)
                || StringUtility.isEmpty(refNoAndBatchNo)
                || StringUtility.isEmpty(voucherAndAuthNo)
                || StringUtility.isEmpty(amount)) {
            return false;
        } else
            return true;
    }

//	public String getMerchantCopy() {
//		return merchantCopy;
//	}
//
//	public void setMerchantCopy(String merchantCopy) {
//		this.merchantCopy = merchantCopy;
//	}

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTerminalNoAndOperator() {
        return terminalNoAndOperator;
    }

    public void setTerminalNoAndOperator(String terminalNoAndOperator) {
        this.terminalNoAndOperator = terminalNoAndOperator;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
