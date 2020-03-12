package com.mywebsite.common;

public class Constants {

	public static final int

	ACCESS_TOKEN_LIFE = 10 * 24 * 60 * 60 * 1000, ACCESS_TOKEN_LIFE_IN_DAYS = 10;

	public class Secret {

	}

	public class TableNames {
		public final static String T_MOVIE = "t_movie";
	}

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd 00:00:00", DATE_FORMAT = "yyyy-MM-dd",
			PLAIN_DATE_FORMAT = "dd-MM-yyyy", TIME_FORMAT = "hh:mm:ss", FULL_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss a";

	public class Roles {

	}

	public class JsonResponse {
		public final static int OK = 0, INVALID_PARAMETER = 1, CANNOT_PERFORM_THIS_ACTION = 13,
				UNAVAILABLE_PARAMETER = 15, SERVER_ERROR = 500,
				RESEND_OTP = 18, INVALID_REQUEST = 20;

		public final static String MIME_TYPE = "application/json",
				SERVER_ERROR_MSG = "Something went wrong at Server. Please try later.";

	}

}
