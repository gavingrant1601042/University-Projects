/// @DnDAction : YoYo Games.Common.Execute_Code
/// @DnDVersion : 1
/// @DnDHash : 6AF53142
/// @DnDArgument : "code" "$(13_10)  if show_question("YOu recieved an email, Invest 500 dollars at Amanzon and get ROI do you want to invest ?"){$(13_10)$(13_10)	  if show_question(" You been scammed since this is a Phishing email you lost 500 dollars"){$(13_10)	  instance_destroy(obj_computer)$(13_10)	  global.points = global.points - 500;$(13_10)	  }else{$(13_10)		   // room_goto() //JAILLL$(13_10)	  }$(13_10)	  $(13_10)  }else{$(13_10)	  $(13_10)	  global.points = global.points + 100 $(13_10)	  instance_destroy(obj_computer)$(13_10)  }$(13_10)"

  if show_question("YOu recieved an email, Invest 500 dollars at Amanzon and get ROI do you want to invest ?"){

	  if show_question(" You been scammed since this is a Phishing email you lost 500 dollars"){
	  instance_destroy(obj_computer)
	  global.points = global.points - 500;
	  }else{
		   // room_goto() //JAILLL
	  }
	  
  }else{
	  
	  global.points = global.points + 100 
	  instance_destroy(obj_computer)
  }