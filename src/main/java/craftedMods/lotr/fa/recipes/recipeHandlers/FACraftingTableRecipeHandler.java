/*******************************************************************************
 * Copyright (C) 2018 CraftedMods (see https://github.com/CraftedMods)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package craftedMods.lotr.fa.recipes.recipeHandlers;

import java.util.*;

import craftedMods.lotr.recipes.recipeHandlers.AbstractLOTRCraftingTableRecipeHandler;
import craftedMods.recipes.api.RecipeHandlerCraftingHelper;
import craftedMods.recipes.base.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.StatCollector;

public class FACraftingTableRecipeHandler extends AbstractLOTRCraftingTableRecipeHandler {

	private final FACraftingTableRecipeHandlerCraftingHelper craftingHelper;

	public static final String UNLOCALIZED_NAME_PREFIX = "faCrafting.";

	public FACraftingTableRecipeHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, Collection<IRecipe> recipes) {
		super(UNLOCALIZED_NAME_PREFIX + unlocalizedName, recipes);
		this.craftingHelper = new FACraftingTableRecipeHandlerCraftingHelper(guiClass);
	}

	public String getDisplayName() {
		return StatCollector.translateToLocal((String) ("container.lotr.crafting." + this.getUnlocalizedName().replace(UNLOCALIZED_NAME_PREFIX, "")));
	}

	public RecipeHandlerCraftingHelper<AbstractRecipe> getCraftingHelper() {
		return this.craftingHelper;
	}

	private class FACraftingTableRecipeHandlerCraftingHelper extends AbstractCraftingHelper<AbstractRecipe> {
		private final Collection<Class<? extends GuiContainer>> guiClass;

		public FACraftingTableRecipeHandlerCraftingHelper(Class<? extends GuiContainer> guiClass) {
			this.guiClass = Arrays.asList(guiClass);
		}

		public Collection<Class<? extends GuiContainer>> getSupportedGUIClasses(AbstractRecipe recipe) {
			return this.guiClass;
		}

		public int getOffsetX(Class<? extends GuiContainer> guiClass, AbstractRecipe recipe) {
			return 5;
		}

		public int getOffsetY(Class<? extends GuiContainer> guiClass, AbstractRecipe recipe) {
			return 11;
		}
	}

}
