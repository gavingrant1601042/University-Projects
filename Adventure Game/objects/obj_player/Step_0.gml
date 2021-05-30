//Get Player Input
key_left = keyboard_check(vk_left);
key_right = keyboard_check(vk_right);
key_jump = keyboard_check_pressed(vk_up);

//Calculate Movement
var move = key_right - key_left;

hsp = move * walksp;

vsp = vsp + grv;

if (place_meeting(x,y+1,obj_platform)) && (key_jump)
{
	
    vsp = -7;
}


//Horizontal collision
if (place_meeting(x+hsp,y,obj_platform))
{
    while (!place_meeting(x+sign(hsp),y,obj_platform))
 {
     x = x + sign(hsp);
 }
 hsp = 0;
}
x = x + hsp;

//Vertical Collision
if (place_meeting(x,y+vsp,obj_platform))
{
    while (!place_meeting(x,y+sign(vsp),obj_platform))
 {
     y = y + sign(vsp);
 }
 vsp = 0;
}
y = y + vsp;


//Gravity
if place_free(x,y+1) && !place_meeting(x,y,obj_ladder)
{
	grv =0.5
}else{
	grv=0
}
 
//Ladder
if(place_meeting(x,y,obj_ladder)){
	vsp=0
	grv=0
	if(keyboard_check(vk_up)){
	vsp = -2;
}
	if (keyboard_check(vk_down)){
		vsp =2
	}

}
if(mouse_check_button_pressed(mb_left))
{
	mx = mouse_x;
	my= mouse_y;
	
	if(!place_meeting(mx,my,obj_platform)){
	global.active = true;		
		
	}
}

if (global.active){
	grv = 0.1;
	x+=(mx-x) * 0.1;
	y+=(my-y)*0.1;
}



if (mouse_check_button_released(mb_left)){
	global.active = false;	
}

