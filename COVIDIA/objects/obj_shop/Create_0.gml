/// @description 
//Shop variables
shopOpen = false; //Is this shop open?
global.shop = false; //Is any shop open?

selected = 0;
selectedAnim = 0;

//Items
items = ds_list_create();

ds_list_add(items, ["water", 2, "Replenish fluid within the body gain 2 points"]);
ds_list_add(items, ["bed", 4, "Replenish health (sleeping maintains the body and defends agaisnt the virus)"]);
ds_list_add(items, ["pill", 6, "Replenish health by 5 points"]);
ds_list_add(items, ["mask", 6, "Replenish health and acts as a barrier to COVID-19"])
    

itemCount = ds_list_size(items);

//GUI
guiWidth = display_get_gui_width();
guiHeight = display_get_gui_height();

menuWidth = guiWidth * 0.3;
menuMargin = guiWidth * 0.1;

previewWidth = (guiWidth - (menuWidth+menuMargin));
