package main.java.desktop;

import main.java.Server.ConSocket;

public class DesktopLauncher {

	public static void main(String[] arg) {

		ConSocket con = new ConSocket();
		con.start();
	}
}
