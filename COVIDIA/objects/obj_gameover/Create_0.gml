
menu_x = x;
menu_y = y;
button_h = 32;

// buttons

button[0] = "GAME OVER You died by the virus ";
button[1] = "Main Menu ";
button[2] = "Start Game";
button[3] = "Exit";

buttons = array_length_1d(button);

menu_index = 0;
last_selected = 0;


if score>global.highscore//do this if bigger than current score
{
ini_open("scores.ini");//open ini
ini_write_real("scores","high",score);//write a value
ini_close();//close value
global.highscore=score;//update highscore
show_message("High Score Updated");//message

}
else//do this if not bigger than current score
{
show_message("Not the highest score");//message
}
