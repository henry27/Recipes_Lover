package com.androidstudioprojects.recipeslover;

public class IngredientsFragment extends CheckBoxesFragment {
	@Override
	public String[] getContents(int index) {
		return Recipes.ingredients[index].split("`");
	}
}