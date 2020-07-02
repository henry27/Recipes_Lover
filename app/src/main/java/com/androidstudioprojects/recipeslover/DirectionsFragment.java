package com.androidstudioprojects.recipeslover;

public class DirectionsFragment extends CheckBoxesFragment {
	@Override
	public String[] getContents(int index) {
		return Recipes.directions[index].split("`");
	}
}
