
  if show_question("Your Password often consist of names,favourite movies and date of birth is it a secure password ?"){

	  if show_question(" This cannot be a secure password since it can be identified and sensitive data will be hacked"){
	  instance_destroy(obj_cmp)
	  global.points = global.points - 500;
	  }else{
		   // room_goto() //JAILLL
	  }
	  
  }else{
	  
	  global.points = global.points + 100 
	  instance_destroy(obj_cmp)
  }
