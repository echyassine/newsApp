package com.newsApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsApp.entities.New;
import com.newsApp.repository.NewRepository;

@Service
@Transactional
public class NewServiceImpl implements NewService {

	@Autowired
	private NewRepository newRepository;
	
	@Override
	public New addNew(New n) {
		newRepository.save(n);
		return n;
	}


	/*@Override
	public void write() {
		//return "chabrik is here";
		System.out.println("chabrik is here");
	}*/
	
	

}
