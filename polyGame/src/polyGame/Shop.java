package polyGame;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> items = new ArrayList<Item>();

	public Shop() {
		Item item = new Item();
		item.kind = Item.HELMET;
		item.name = "가죽투구";
		item.power = 5;
		item.price = 2500;

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "철투구";
		item.power = 10;
		item.price = 5000;

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "다이아 투구";
		item.power = 15;
		item.price = 8000;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "가죽갑옷";
		item.power = 5;
		item.price = 2500;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "철 갑옷";
		item.power = 10;
		item.price = 5000;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "다이아 갑옷";
		item.power = 15;
		item.price = 8000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "실반지";
		item.power = 7;
		item.price = 3000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "금반지";
		item.power = 17;
		item.price = 6000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "다이아반지";
		item.power = 35;
		item.price = 15000;

	}
}
