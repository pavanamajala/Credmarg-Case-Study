package com.credmarg.vendor.service;

import java.util.List;

public interface EmailService {

	public List<String> sendEmailToVendor(List<String> emailIds);

}
