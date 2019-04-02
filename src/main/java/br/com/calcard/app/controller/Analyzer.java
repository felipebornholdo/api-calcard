package br.com.calcard.app.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.calcard.app.model.Client;
import br.com.calcard.app.model.Result;

@Component
public class Analyzer {

	public Result analyze(Client client) {

		BigDecimal money = client.getMoney();
		Integer age = client.getAge();
		Integer dependent = client.getDependent();

		Result result = null;

		if (money.compareTo(new BigDecimal(500)) <= 0) {
			result = Result.decline("renda baixa");

		} else if (money.compareTo(new BigDecimal(5000)) < 0) {

			if (age >= 45) {
				result = Result.decline("reprovado pela política de crédito");

			} else if (dependent <= 1 && age >= 25) {
				result = Result.approve("entre 500 - 1000");

			} else {
				result = Result.approve("entre 100 - 500");
			}

		} else if (money.compareTo(new BigDecimal(5000)) >= 0) {

			if (age <= 65) {

				if (dependent < 3) {
					result = Result.approve("superior 2000");

				} else {
					result = Result.approve("entre 1000 - 1500");
				}

			} else {
				result = Result.approve("entre 1500 - 2000");
			}
		}

		return result;
	}
}
