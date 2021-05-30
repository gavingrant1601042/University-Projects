
switch(menu_index) {

	case 1:
			room_goto(r_menu);
		break;
		
	case 2:
	
			score = 0;
			room_goto(r_battle);
		break		
		
	case 3:
			game_end();
		break;

}
