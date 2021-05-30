/// @description scr_cleanup

//destoy those lists to prevent memory leaks

if ds_exists(trail_x, ds_type_list)
{
	ds_list_destroy(trail_x)
	ds_list_destroy(trail_y)
	ds_list_destroy(alpha)
}
