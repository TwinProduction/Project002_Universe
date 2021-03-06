package org.twinnation.service;
import org.twinnation.landscape.building.Building;
import org.twinnation.constant.GlobalConstants;
import org.twinnation.twinutilities.RandomUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * this is just a test Service for now
 */
public class BuildingService implements GlobalConstants {
	private static List<Building> listBuildings = generateBuildings(100);



	public static void init(Graphics g) {
		System.out.println("init is called");
		for (Building b : listBuildings) {
			g.drawRect(b.getPosX(), b.getPosY(), b.getWidth(), b.getHeight());
		}
	}


	private static List<Building> generateBuildings(int amount) {
		List<Building> temp = new ArrayList<Building>();
		while (amount --> 0) {
			temp.add(generateRandom());
		}
		return temp;
	}


	public static Building generateRandom() {
		int width = RandomUtils.randomInteger(10, 50),
				height = RandomUtils.randomInteger(10, 50),
				length = RandomUtils.randomInteger(10, 50),
				posX = RandomUtils.randomInteger(0, FRAME_WIDTH),
				posY = RandomUtils.randomInteger(0, FRAME_HEIGHT);

		while (height+posY>FRAME_HEIGHT || height+posY<0) {
			posY = RandomUtils.randomInteger(0, FRAME_HEIGHT);
		}

		while (width+posX>FRAME_WIDTH || width+posX<0) {
			posX = RandomUtils.randomInteger(0, FRAME_WIDTH);
		}

		// TODO: check if there's already a building in the way
		return new Building(posX, posY, width, height, length);
	}

	public static void drawTest(Graphics g) {
		Building b = generateRandom();
		g.drawRect(b.getPosX(), b.getPosY(), b.getWidth(), b.getHeight());
	}
}
