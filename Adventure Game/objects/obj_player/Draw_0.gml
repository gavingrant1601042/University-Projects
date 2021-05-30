/// @description draw self and after image
//draw after image first so it is underneath the object
//draw the object second
//c_white is default colour but you can use another colour or use make_colour_rgb
//scr_after_image(after image lenghth is the max amount of sprites drawn, spacing is steps between each image generated, fade length is how long it takes for a after image to fade out, colour)
scr_after_image(5, 4, 0.05, c_white)


draw_self();

if(global.active){
	draw_line(x,y,mx,my);
}