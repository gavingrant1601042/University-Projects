/// @description scr_after_image()
/// @param length: max sprites in after image
/// @param spacing: steps between update
/// @param fade length: how quicly the after image fades out
/// @param colour: c_white for default
//check to see if trail_x exists VARIABLE INSTANCE EXISTS ONLY WORKS WITH GMS2
if !variable_instance_exists(id, "trail_x")
{
	//trail_x keeps track of the x position for each position of the ds_list
	//each position of a ds list is a after image
	trail_x = ds_list_create()
	//trail_y keeps track of the y position
	trail_y = ds_list_create()
	//alpha keeps track of t he alpha for each image
	//this will update independitly but will match the ds_list length
	//this means that even if a after image is generated every 4 steps the alpha of each after image is updated every step
	alpha = ds_list_create()
	//because we ignore teh 0 position if you enter the number 5 you will have 4 after images
	//whatever number you enter minus 1 from it and that will be the amount you will have as a draw sprite
	number_of_after_images = argument0
	spacing = argument1
	//take care with fade length if your length is slow and you have only 4 images the image that is 4th will not fade out before it is deleted
	//fade_length of 0.05 and number_of_after_images of 5 is a good setting
	fade_length = argument2
	colour = argument3
}
if argument2 == noone
{
	argument2 = c_white
}

//limit the size of the after image trail
//we only need to check one as they are both updated so if one ds_list size is 4 then the other will be a size of 4
if ds_list_size(trail_x) > number_of_after_images
{
	//ds_list starts at 0 so when we enter the first number it is at position 0
	//when we add a second number it is added to position 1
	//this process continues until the ds_list is as big as the supplied argument for after_image_length
	//lets say the max size is 4 when we add the 5th number the oldest entry is deleted
	//entry 0 is deleted and now the new entry is position 4
	//every entry shifts down a number
	//position 5 is now position 4 position 4 is now position 3 and so on
    ds_list_delete(trail_x,0);
    ds_list_delete(trail_y,0);
	ds_list_delete(alpha, 0)
	//if you need image index for animation
	//ds_list_delete(trail_image_index, 0)
}

//draw the after image trail with for loop
//Star i at 1 as the math for the after image length would equal 0 if we start i at 0
//that means we are not drawing the first entry of the ds_list as its alpha would be 0
//1 through whatever the argument number is is all that is drawn
for(var i=1; i<ds_list_size(trail_x); i++)
{
	//fade out lower in list the more fade out the sprite has example 
	//draw_set_alpha(i/trail_limit); if using simple draw sprite
	//dont draw directly beneacth us if we are not moving
	if trail_x[|i] != x || trail_y[|i] != y
	{
		//draw sprite for each psoition in the list
		draw_sprite_ext(sprite_index, image_index, trail_x[|i], trail_y[|i], 1, 1, image_angle, colour, alpha[|i])
	}
}
//Update alpha values every step for each list entry
for (var i = 1; i<ds_list_size(trail_x); i++)
{
	ds_list_replace(alpha, i, ds_list_find_value(alpha, i) - fade_length)
}
	
//This is our spacing
//If spacing is == 0 then we update a new x and y position to the ds list and set spacing back to the value provided in the argument
if spacing <= 0
{
	//add x and y to ds list
	ds_list_add(trail_x, x);
	ds_list_add(trail_y, y);
	ds_list_add(alpha, 1)
	//set spacing to argument
	spacing = argument1
}
//minus one from spacing
else
{
	spacing --
}