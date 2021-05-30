ini_open("scores.ini");//open file
global.highscore=ini_read_real("scores","high",0);//load scores high if present, otherwise set as 0
ini_close();//close ini
