package com.jpa.optima.ipg.process;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.optima.ipg.model.DebitCard;
import com.jpa.optima.ipg.model.MerchantDetails;

@Component
@Repository
public class IPGRepository {
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void createDebitCardsToken(String msisdn, String token, Integer channelID, String maskedCardNumber,
			String expiredDate, String bankCode, String bankName) {
		this.jdbcTemplate.update(
				"insert into debit_cards (msisdn, token, channel_id, masked_card_number, expired_date, bank_code, bank_name) values(?, ?, ?, ?, ?, ?, ?)",
				msisdn, token, channelID, maskedCardNumber, expiredDate, bankCode, bankName);
	}

	public String validateCards(String msisdn, Integer channelID) {
		try {
			String token = this.jdbcTemplate.queryForObject(
					"select token from debit_cards where msisdn = ? and channel_id = ?",
					new Object[] { msisdn, channelID }, String.class);
			return token;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void removeDebitCard(String msisdn, Integer channelID) {
		jdbcTemplate.update("delete from debit_cards where msisdn = ? and channel_id = ?", msisdn, channelID);
	}

	public MerchantDetails merchantDetails(String mID) {
		try {
			MerchantDetails m = this.jdbcTemplate.queryForObject("select * from merchants where mid = ?",
					new Object[] { mID }, new RowMapper<MerchantDetails>() {
						public MerchantDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
							MerchantDetails m = new MerchantDetails();
							m.setId(rs.getInt("id"));
							m.setMerchantID(rs.getString("merchant_id"));
							m.setMid(rs.getString("mid"));
							m.setPassword(rs.getString("password"));
							m.setPublicKey(rs.getString("public_key"));
							m.setSecretKey(rs.getString("secret_key"));
							m.setTerminalID(rs.getString("terminal_id"));
							m.setTokenRequestorID(rs.getString("token_requestor_id"));
							m.setTransferTypeID(rs.getInt("transfer_type_id"));
							m.setUsername(rs.getString("username"));
							return m;
						}
					});
			return m;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public DebitCard debitCardDetails(String msisdn, Integer channelID) {
		try {
			DebitCard dc = this.jdbcTemplate.queryForObject(
					"select * from debit_cards where msisdn = ? and channel_id = ?",
					new Object[] { msisdn, channelID }, new RowMapper<DebitCard>() {
						public DebitCard mapRow(ResultSet rs, int rowNum) throws SQLException {
							DebitCard dc = new DebitCard();
							dc.setBankCode(rs.getString("bank_code"));
							dc.setBankName(rs.getString("bank_name"));
							dc.setChannelID(rs.getInt("channel_id"));
							dc.setExpiredDate(rs.getString("expired_date"));
							dc.setMaskedCardNumber(rs.getString("masked_card_number"));
							dc.setMsisdn(rs.getString("msisdn"));
							dc.setToken(rs.getString("token"));
							return dc;
						}
					});
			return dc;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
