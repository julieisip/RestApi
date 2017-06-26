package com.sample.api.sample_api.provider;

import java.util.ArrayList;
import java.util.List;

public class SQLBuilder {
	private final String WHERE_CLAUSE = "WHERE";
	private final String AND_CLAUSE = "AND";
	private final String SPACE = " ";
	private List<String> queryParams;
	private String sql = "Select * From Person ";

	private final String WHERE_FST_NAME_COND = "firstName LIKE ?";
	private final String WHERE_LST_NAME_COND = "lastName= ?";
	private final String WHERE_PHONE_COND = "phone = ?";
	private final String WHERE_EMAIL_COND = "email= ?";

	private void addQueryParam(String param) {

		if (queryParams == null) {
			queryParams = new ArrayList<String>();
		}

		if (param != null) {
			final String upCaseParam = param.toUpperCase();
			queryParams.add(upCaseParam);
		}
	}

	public String searchBuilder(String firstName, String lastName, String email, String phone) {

		final StringBuilder sb = new StringBuilder();
		boolean isConditionStarted = false;
		sb.append(sql);
		sb.append(SPACE);
		sb.append(WHERE_CLAUSE);
		sb.append(SPACE);

		if (email != null) {

			if (isConditionStarted) {
				sb.append(SPACE);
				sb.append(AND_CLAUSE);
				sb.append(SPACE);
			}
			sb.append(WHERE_EMAIL_COND);
			addQueryParam(email);

			isConditionStarted = true;
		}
		if (firstName != null) {

			if (isConditionStarted) {
				sb.append(SPACE);
				sb.append(AND_CLAUSE);
				sb.append(SPACE);
			}
			sb.append(WHERE_FST_NAME_COND);
			addQueryParam(firstName);
			isConditionStarted = true;
		}
		if (lastName != null) {

			if (isConditionStarted) {
				sb.append(SPACE);
				sb.append(AND_CLAUSE);
				sb.append(SPACE);
			}
			sb.append(WHERE_LST_NAME_COND);
			addQueryParam(lastName);
			isConditionStarted = true;
		}

		if (phone != null) {

			if (isConditionStarted) {
				sb.append(SPACE);
				sb.append(AND_CLAUSE);
				sb.append(SPACE);
			}
			sb.append(WHERE_PHONE_COND);
			addQueryParam(phone);
			isConditionStarted = true;
		}
		return sb.toString();

	}

	public Object[] getQueryParams() {

		if (queryParams == null) {
			return new Object[] {};
		}
		final Object[] qrParams = new Object[queryParams.size()];
		return queryParams.toArray(qrParams);
	}
}
