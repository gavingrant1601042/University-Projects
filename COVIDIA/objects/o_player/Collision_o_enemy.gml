/// @description Insert description here
// You can write your code in this editor
if invincible_ == false {
	global.health_ -= 0.5;
	audio_play_sound(a_hurt, 5, false);
	invincible_ = true;
	alarm[1] = game_get_speed(gamespeed_fps);
}