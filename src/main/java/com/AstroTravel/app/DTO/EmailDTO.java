package com.AstroTravel.app.DTO;

public class EmailDTO {

	private String emailId;
	private String OTP;
	private boolean genrateOtp;

	public EmailDTO(String emailId, String OTP, boolean genrateOtp) {
		this.emailId = emailId;
		this.OTP = OTP;
		this.genrateOtp = genrateOtp;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String OTP) {
		this.OTP = OTP;
	}

	public boolean isGenrateOtp() {
		return genrateOtp;
	}

	public void setGenrateOtp(boolean genrateOtp) {
		this.genrateOtp = genrateOtp;
	}
}
