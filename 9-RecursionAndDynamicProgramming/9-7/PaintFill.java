enum Color {
	Black, Red, Green, Blue, Yellow;
}

boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
	if(x < 0 || x >= screen[0].length || y < 0 || y > screen.length) return false;
	if(screen[y][x] == ocolor) {
		screen[y][x] == ncolor;
		paintFill(screen, x - 1, y, ocolor, ncolor);
		paintFill(screen, x + 1, y, ocolor, ncolor);
		paintFill(screen, x, y - 1, ocolor, ncolor);
		paintFill(screen, x, y + 1, ocolor, ncolor);
	}
	return true;
}

boolean paintFill(Color[][] screen, int x, int y, Color ncolor) {
	return paintFill(screen, x, y, screen[y][x], ncolor);
}
