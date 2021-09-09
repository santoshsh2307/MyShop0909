package com.myshop.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myshop.demo.entity.Users;
import com.myshop.demo.service.UsersService;

@RestController
@RequestMapping(value = "/userController")
public class UserController { 
	
	@Autowired
	UsersService uSer;
	
	@PostMapping(value = "/saveUsers")
	public HashMap<String, Object> saveUsers(@RequestBody Users u) {
		
		HashMap<String, Object> map = new HashMap<>();
		Users phonePresent = uSer.findByPhone(u.getPhone());
		  Users userPresent = uSer.findUsersByUserName(u.getUserName());
		  if (phonePresent!=null&& userPresent!=null) {
			map.put("code", "250");
			map.put("content", "phone or userName already exist");
		} else {
			Users data = uSer.saveUsers(u);
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {
				map.put("code", "201");
				map.put("content", "no data");
				
			}
		}
		
		
		return map;
	
	}
	@GetMapping(value = "/getUserById")
	public HashMap<String, Object> getUserById(Long id) {
		Users data = uSer.findById(id);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
		}
		return map;
		
	}


	@GetMapping(value = "/getUserByPhoneNo")
	public HashMap<String, Object> getUserByPhoneNo(String phone) {
		Users data = uSer.findByPhone(phone);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			String otp= getRandomNumberString();
			System.out.println(otp);
			data.setOtp(otp);
			
			uSer.saveUsers(data);
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
			
		}
		return map;
		
	}
	@GetMapping(value = "/getUserByUserName/{name}")
	public HashMap<String, Object> getUserByUserName(@PathVariable ("name") String userName) {
		 Users data = uSer.findUsersByUserName(userName);
		 HashMap<String, Object> map = new HashMap<>();
			if (data!=null) {
				map.put("code", "200");
				map.put("content", data);
			} else {	
				map.put("code", "201");
				map.put("content", "no data");
				
				
			}
			return map;
		
	}
	@PostMapping(value = "/getUserByPhoneNoAndPassword")
	public HashMap<String, Object> getUserByPhoneNoAndPassword(String phone, String password) {
		Users data = uSer.getUserByPhoneNoAndPassword(phone,password);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
			
		}
		return map;
	}
	
	@PostMapping(value = "/getUserByUserNameAndPassword")
	public HashMap<String, Object> getUserByUserNameAndPassword(String userName, String password) {
		Users data = uSer.getUserByUserNameAndPassword(userName,password);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
			
		}
		return map;
	}
	@GetMapping(value= "/getAllUsers")
    public HashMap<String, Object> getAllUsers(){
	List<Users>userdata=uSer.findAll();
	HashMap<String,Object>map=new HashMap<>();
	if (userdata!=null) {
		map.put("code", "200");
		map.put("content", userdata);
	} else {
		map.put("code", "201");
		map.put("content", "nodata");
	}
	
      return map;

	}
	
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	@PostMapping(value = "/getUserByPhoneAndOTP")
	public HashMap<String, Object> getUserByPhoneAndOTP( String phone, String otp,String psw) {
		 Users data = uSer.getUserByPhoneAndOTP(phone,otp);
		HashMap<String, Object> map = new HashMap<>();
		if (data!=null) {
			if(data.getOtp().equals(otp)) {
				data.setPassword(psw);
				uSer.saveUsers(data);
				map.put("code", "200");
				map.put("content", "passwrord set success");
			}else {
				map.put("code", "2001");
				map.put("content", "invalid otp");
			}
			
		} else {
			map.put("code", "201");
			map.put("content", "no data");
			
			
		}
		return map;
	}
	
	@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,Long id,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return "plz select a file";
        }

        try {
        	Users userData = uSer.findById(id);
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:\\upload\\" + file.getOriginalFilename());
            
            Files.write(path, bytes);
            userData.setPhoto(path.toString());
            uSer.saveUsers(userData);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "profile upload successfully";
    }
	
	@GetMapping(value = "/completeUserDetails")
	public HashMap<String, Object> getUserCompleteProfile(Long id,Long spId) {
		Object data = uSer.getUserCompleteProfile(id,spId);
		
		HashMap<String,Object>map=new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
	}
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/getAppointmentsBasedOnStatus",method = RequestMethod.GET)
	public HashMap<String, Object> getAppointmentsBasedOnStatus(Long ownerId, Long shopId,Long bookingStatus) {
		List<Object> appData = uSer.getAppointmentsBasedOnStatus(ownerId,shopId,bookingStatus);
		HashMap<String,Object>map=new HashMap<>();
		if (appData!=null) {
			map.put("code", "200");
			map.put("content", appData);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
		
		
		
	}
	@RequestMapping(value = "/getTotalCustomer",method = RequestMethod.GET)
	public HashMap<String, Object> getTotalCustomer(Long ownerId, Long shopId, Long bookingStatus) {
		Long totalCustomer = uSer.getTotalCustomer(ownerId,shopId,bookingStatus);
		HashMap<String,Object>map=new HashMap<>();
		if (totalCustomer!=null) {
			map.put("code", "200");
			map.put("content", totalCustomer);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
		
		
	}
	
	@GetMapping(value = "/getTotalCustomerOfDay")
	public HashMap<String, Object> getTotalCustomerOfDay(Long ownerId, Long shopId, String date) {
	 	Long totalCustomerOfDay = uSer.getTotalCustomerOfDay(ownerId,shopId,date);
	 	HashMap<String,Object>map=new HashMap<>();
		if (totalCustomerOfDay!=null) {
			map.put("code", "200");
			map.put("content", totalCustomerOfDay);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
		
		
	}
	
	@GetMapping(value = "/getTotalCustomerOfDayOnStatus")
	public HashMap<String, Object> getTotalCustomerOfDay(Long ownerId, Long shopId, String date, Long bookingStatusId) {
	 	Long totalCustomerOfDay = uSer.getTotalCustomerOfDay(ownerId,shopId,date,bookingStatusId);
	 	HashMap<String,Object>map=new HashMap<>();
		if (totalCustomerOfDay!=null) {
			map.put("code", "200");
			map.put("content", totalCustomerOfDay);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
		
		
	}
	@GetMapping(value = "/getTotalEarn")
	public HashMap<String, Object> getTotalEarn(Long ownerId, Long shopId) {
	 	Float totalAmount = uSer.getTotalEarn(ownerId,shopId);
	 	HashMap<String,Object>map=new HashMap<>();
		if (totalAmount!=null) {
			map.put("code", "200");
			map.put("content", totalAmount);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
		
	}
	@GetMapping(value = "/getOwnerDeatailByShopId")
	public HashMap<String, Object> getOwnerDeatailByShopId(Long shopId) {
		Object data = uSer.getOwnerDeatailByShopId(shopId);
		HashMap<String,Object>map=new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
	}
	
	@GetMapping(value = "/getShopDeatailByOwnerId")
	public HashMap<String, Object> getShopDeatailByOwnerId(Long ownerId) {
		Object data = uSer.getShopDeatailByOwnerId(ownerId);
		HashMap<String,Object>map=new HashMap<>();
		if (data!=null) {
			map.put("code", "200");
			map.put("content", data);
		} else {
			map.put("code", "201");
			map.put("content", "nodata");
		}
		
	      return map;
	
	}
	
	
}
