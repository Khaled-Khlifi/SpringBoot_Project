package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Sign;
import net.javaguides.sms.repository.SignRepository;
import net.javaguides.sms.service.SignService;

@Service
public class SignServiceImpl implements SignService{

	private SignRepository SignRepository;
	
	public SignServiceImpl(SignRepository SignRepository) {
		super();
		this.SignRepository = SignRepository;
	}

	@Override
	public List<Sign> getAllSigns() {
		return SignRepository.findAll();
	}

	@Override
	public Sign saveSign(Sign Sign) {
		return SignRepository.save(Sign);
	}

	@Override
	public Sign getSignById(Long id) {
		return SignRepository.findById(id).get();
	}

	@Override
	public Sign updateSign(Sign Sign) {
		return SignRepository.save(Sign);
	}

	@Override
	public void deleteSignById(Long id) {
		SignRepository.deleteById(id);	
	}

}
