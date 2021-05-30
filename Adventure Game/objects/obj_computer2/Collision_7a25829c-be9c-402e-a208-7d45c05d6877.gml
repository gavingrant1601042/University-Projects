/// @DnDAction : YoYo Games.Common.Execute_Code
/// @DnDVersion : 1
/// @DnDHash : 6AF53142
/// @DnDArgument : "code" "$(13_10)  if show_question("Do you want to use this to shop if so enter your personal information"){$(13_10)$(13_10)	  if show_question(" You been hacked"){$(13_10)	  instance_destroy(obj_computer2)$(13_10)	  global.points = global.points - 500$(13_10)	  }else{$(13_10)		   // room_goto() //JAILLL$(13_10)	  }$(13_10)	  $(13_10)  }else{$(13_10)	  $(13_10)		  global.points = global.points + 100 $(13_10)		  instance_destroy(obj_computer2)$(13_10)  }$(13_10)"

  if show_question("Do you want to use this to shop if so enter your personal information"){

	  if show_question(" You been hacked"){
	  instance_destroy(obj_computer2)
	  global.points = global.points - 500
	  }else{
		   // room_goto() //JAILLL
	  }
	  
  }else{
	  
		  global.points = global.points + 100 
		  instance_destroy(obj_computer2)
  }