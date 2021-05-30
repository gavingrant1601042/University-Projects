if myTime >0{

myTime=myTime-delta_time/1000000
}else{
	myTime=0
	room_goto(rm_gameover)
}
showTime=ceil(myTime)
//delta time is a built in function to get real time