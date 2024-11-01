/*
*
*N Sunil 
*
*/

package com.sunil.employee.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunil.employee.utils.BaseResponseDTO;

//@FeignClient(name = "Address-Client", url = "http://localhost:8081", path = "/address-app")
//@FeignClient(name = "address-Client", url = "http://localhost:8081/address-app")
@FeignClient(name = "address-app", path = "/address-app")
public interface AddressClient
{
	
	@GetMapping(value = "/address/getAddressByEmpNo", produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponseDTO getAddressByEmpNo(@RequestParam(name = "empNo") String empNo);
	
}