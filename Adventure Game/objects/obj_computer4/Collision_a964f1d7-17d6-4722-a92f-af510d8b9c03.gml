/// @DnDAction : YoYo Games.Common.Execute_Code
/// @DnDVersion : 1
/// @DnDHash : 6AF53142
/// @DnDArgument : "code" "$(13_10)  if show_question("Would a Low level employer have access to certain files(CIA)  "){$(13_10)$(13_10)	  if show_question(" Confidential Integrity Association in Data Classification restrict access to certain files"){$(13_10)	  instance_destroy(obj_computer4)$(13_10)	  global.points = global.points - 1300$(13_10)	  }else{$(13_10)		   // room_goto() //JAILLL$(13_10)	  }$(13_10)	  $(13_10)  }else{$(13_10)	  $(13_10)	    instance_destroy(obj_computer4)$(13_10)		  global.points = global.points + 100 $(13_10)		$(13_10)  }$(13_10)"

  if show_question("Would a Low level employer have access to certain files(CIA)  "){

	  if show_question(" Confidential Integrity Association in Data Classification restrict access to certain files"){
	  instance_destroy(obj_computer4)
	  global.points = global.points - 1300
	  }else{
		   // room_goto() //JAILLL
	  }
	  
  }else{
	  
	    instance_destroy(obj_computer4)
		  global.points = global.points + 100 
		
  }