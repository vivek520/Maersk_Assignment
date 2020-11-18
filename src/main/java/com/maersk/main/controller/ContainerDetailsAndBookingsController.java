package com.maersk.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.main.IContainerRepository;
import com.maersk.main.bean.BookingReferenceBean;
import com.maersk.main.bean.ContainerDetails;

@RestController
@RequestMapping("/api/bookings/")
public class ContainerDetailsAndBookingsController {
	
	@Autowired
	IContainerRepository containerRepository;
	
	@Autowired
	CassandraTemplate templateDao;
	
	
	@RequestMapping("containerAvailability")
	public boolean isContainerAvailable() {		
		return true;
	}

	@RequestMapping(value = "bookingRequest",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingReferenceBean addBookingRequest(@RequestBody ContainerDetails containerDetails) {
		
		BookingReferenceBean bookingReferenceBean = new BookingReferenceBean();
		Long bookingRefNumber = 1445222L;
		bookingReferenceBean.setBookingRef(bookingRefNumber);
		
		containerDetails.setId(bookingRefNumber);
		System.out.println(containerDetails.toString());
		templateDao.insert(containerDetails);
		
		return bookingReferenceBean;
	}
}
