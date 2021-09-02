package com.jly.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jly.bean.Address;

public interface AddressService {

	public List<Address> findAllAddress(int id);

	public boolean updateDefaultAddress(int u_id, int a_id);

	public boolean addAddress(Address address);

	public boolean addDefaultAddress(Address address);
	public boolean deleteAddress( int id );
	public Address queryByidAddress(int id);

}
