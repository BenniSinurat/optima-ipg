package com.jpa.optima.ipg.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IPGValidation {
	@Autowired
	private BaseRepository baseRepository;

	public String validateCards(String msisdn, Integer channelID) {
		return baseRepository.getIpgRepository().validateCards(msisdn, channelID);
	}

	public void createDebitCards(String msisdn, String token, Integer channelID) {
		baseRepository.getIpgRepository().createDebitCardsToken(msisdn, token, channelID);
	}

}
