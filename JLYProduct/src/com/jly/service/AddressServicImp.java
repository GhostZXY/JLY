package com.jly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jly.bean.Address;
import com.jly.dao.AddressDao;
@Service(value="AddressService")
public class AddressServicImp implements AddressService {
	@Resource
	AddressDao addressDao;
	@Override
	public List<Address> findAllAddress(int id) {
		// TODO Auto-generated method stub
		return addressDao.querryAllAddress(id);
	}
	public AddressDao getAddressDao() {
		return addressDao;
	}
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	@Override
	public boolean updateDefaultAddress(int u_id, int a_id) {
		// TODO Auto-generated method stub
		Address address_old = addressDao.queryDefaultAddress(u_id);
		addressDao.uppDateAddress(address_old.getA_id(), "0");
		addressDao.uppDateAddress(a_id, "1");
		return false;
	}
	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		
		return  addressDao.addAddress(address)!=0;
	}
	@Override
	public boolean addDefaultAddress(Address address) {
		// TODO Auto-generated method stub
		Address address_old = addressDao.queryDefaultAddress(Integer.parseInt(address.getU_id()));
		if(address_old!=null)
		addressDao.uppDateAddress(address_old.getA_id(), "0");
		return addressDao.addAddress(address)!=0;
	}
	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		
		Address address = addressDao.queryAddressById(id);
		if(address.getA_isdefault().equals("1")){
			addressDao.delAddress(id);
			List<Address> addressList = addressDao.querryAllAddress(Integer.parseInt(address.getU_id()));
			if(addressList.size() !=0){
				
				addressDao.uppDateAddress(addressList.get(0).getA_id(), "1");
			}
		}else{
			addressDao.delAddress(id);
		}
		
		return false;
	}
	@Override
	public Address queryByidAddress(int id) {
		// TODO Auto-generated method stub
		return addressDao.queryAddressById(id);
	}

}
