package com.jpa.optima.ipg.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.optima.ipg.model.DebitCard;
import com.jpa.optima.ipg.model.MerchantDetails;

@Component
public class IPGValidation {
	@Autowired
	private BaseRepository baseRepository;

	public String validateCards(String msisdn, Integer channelID) {
		return baseRepository.getIpgRepository().validateCards(msisdn, channelID);
	}

	public void createDebitCards(String msisdn, String token, Integer channelID, String maskedCardNumber, String expiredDate, String bankCode, String bankName) {
		baseRepository.getIpgRepository().createDebitCardsToken(msisdn, token, channelID, maskedCardNumber, expiredDate, bankCode, bankName);
	}
	
	public void removeDebitCards(String msisdn, Integer channelID) {
		baseRepository.getIpgRepository().removeDebitCard(msisdn, channelID);
	}
	
	public MerchantDetails merchantDetails(String mID) {
		return baseRepository.getIpgRepository().merchantDetails(mID);
	}
	
	public DebitCard debitCardDetails(String msisdn, Integer channelID) {
		return baseRepository.getIpgRepository().debitCardDetails(msisdn, channelID);
	}
}
