package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Sign;

public interface SignService {
	List<Sign> getAllSigns();
	
	Sign saveSign(Sign Sign);
	
	Sign getSignById(Long id);
	
	Sign updateSign(Sign Sign);
	
	void deleteSignById(Long id);
}
