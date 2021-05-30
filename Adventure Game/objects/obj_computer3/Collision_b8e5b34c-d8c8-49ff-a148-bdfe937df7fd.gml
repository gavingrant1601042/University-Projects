/// @DnDAction : YoYo Games.Common.Execute_Code
/// @DnDVersion : 1
/// @DnDHash : 6AF53142
/// @DnDArgument : "code" "$(13_10)  if show_question("Secure Password: Using Personal information for your password is not risky and you should use it such as DOB?"){$(13_10)$(13_10)	  if show_question(" You cant use personal info u must use alpha  numeric upper and lowercase character"){$(13_10)	  instance_destroy(obj_computer3)$(13_10)	  global.points = global.points - 1300$(13_10)	  }else{$(13_10)		   // room_goto() //JAILLL$(13_10)	  }$(13_10)	  $(13_10)  }else{$(13_10)	  $(13_10)	    instance_destroy(obj_computer3)$(13_10)		  global.points = global.points + 100 $(13_10)		$(13_10)  }$(13_10)"

  if show_question("Secure Password: Using Personal information for your password is not risky and you should use it such as DOB?"){

	  if show_question(" You cant use personal info u must use alpha  numeric upper and lowercase character"){
	  instance_destroy(obj_computer3)
	  global.points = global.points - 1300
	  }else{
		   // room_goto() //JAILLL
	  }
	  
  }else{
	  
	    instance_destroy(obj_computer3)
		  global.points = global.points + 100 
		
  }