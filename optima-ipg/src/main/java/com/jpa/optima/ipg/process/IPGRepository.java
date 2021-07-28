package com.jpa.optima.ipg.process;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository
public class IPGRepository {
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void createDebitCardsToken(String msisdn, String token, Integer channelID) {
		this.jdbcTemplate.update("insert into debit_cards (msisdn, token, channel_id) values(?, ?, ?)", msisdn, token,
				channelID);
	}

	public String validateCards(String msisdn, Integer channelID) {
		try {
			String token = this.jdbcTemplate.queryForObject("select token from debit_cards where msisdn = ? and channel_id = ?",
					new Object[] { msisdn, channelID }, String.class);
			return token;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
