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
package craftedMods.lotr.fa.recipes;

import java.util.*;

import craftedMods.lotr.fa.recipes.recipeHandlers.*;
import craftedMods.lotr.recipes.recipeHandlers.AlloyForgeRecipeHandler;
import craftedMods.recipes.api.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;
import valiec.lotrfa.FARecipes;

@RegisteredHandler
public class IntegratedRecipeHandlerFactory implements RecipeHandlerFactory {

	private static final Set<RecipeHandler<?>> recipeHandlers = new HashSet<>();

	static {
		// FA crafting tables
		IntegratedRecipeHandlerFactory.registerFACTHandler("ladros", FARecipes.LadrosGui.class, FARecipes.ladrosRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("dor_lomin", FARecipes.DorLominGui.class, FARecipes.dorLominRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("brethil", FARecipes.BrethilGui.class, FARecipes.brethilRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("falas", FARecipes.FalasGui.class, FARecipes.falasRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("nargothrond", FARecipes.NargothrondGui.class, FARecipes.nargothrondRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("feanorean", FARecipes.FeanoreanGui.class, FARecipes.feanoreanRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("valinor", FARecipes.ValinorGui.class, FARecipes.valinorRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("red_dwarf", FARecipes.RedDwarvenGui.class, FARecipes.redDwarvenRecipes);

		// FA alloy forges
		IntegratedRecipeHandlerFactory.recipeHandlers.add(new AlloyForgeRecipeHandler("redDwarven", new RedDwarvenAlloyForgeAccess()));
	}

	private static void registerFACTHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, Collection<IRecipe> recipes) {
		IntegratedRecipeHandlerFactory.recipeHandlers.add(new FACraftingTableRecipeHandler(unlocalizedName, guiClass, recipes));
	}

	// private static void registerTraderHandler(Class<? extends LOTRTradeable> entityClass, String faction, LOTRTradeEntries itemsBought,
	// LOTRTradeEntries itemsSold) {
	// IntegratedRecipeHandlerFactory.recipeHandlers.add(
	// new TraderRecipeHandler(EntityList.classToStringMapping.get(entityClass).toString().replace("lotr.", ""), faction, itemsBought, itemsSold));
	// }

	@Override
	public Set<RecipeHandler<?>> getRecipeHandlers() {
		return IntegratedRecipeHandlerFactory.recipeHandlers;
	}

}
