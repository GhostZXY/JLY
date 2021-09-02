package com.jly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jly.bean.Address;

public interface AddressDao {
	public List<Address> querryAllAddress(@Param("id") int id);
	public Address queryDefaultAddress(@Param("id") int id );
	public int uppDateAddress(
			@Param("id") int id,@Param("a_isdefault") String a_isdefault);
	public int addAddress(Address address);
	public int delAddress(@Param("id") int id );
	public Address queryAddressById(@Param("id") int id );
}
