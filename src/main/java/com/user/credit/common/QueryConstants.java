package com.user.credit.common;


public final class QueryConstants {

	/**
	 * Query to activate/deactivate target rule by Object Id.
	 */
	public static final String IS_TYPE_EXISTS = "SELECT usrcredt FROM UserCreditEntity usrcredt where usrcredt.userId IN (:userId) and usrcredt.credtype IN (:type)";
	public static final String UPDATE_USERCREDIT = "update UserCreditEntity uce set uce.creditUsed = :creditUsed,uce.totalCredit = :totalCredit where uce.id = :id";
}
