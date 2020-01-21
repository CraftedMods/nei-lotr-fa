/*******************************************************************************
 * Copyright (C) 2020 CraftedMods (see https://github.com/CraftedMods)
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

import craftedMods.lotr.recipes.api.recipeHandlers.AbstractTraderRecipeHandler;
import craftedMods.lotr.recipes.api.utils.LOTRRecipeHandlerUtils;
import craftedMods.recipes.api.RecipeHandlerRecipeViewer;
import lotr.client.gui.LOTRGuiTrade;
import lotr.common.entity.npc.LOTRTradeEntries;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.StatCollector;

public class FATraderRecipeHandler extends AbstractTraderRecipeHandler {

	private final FATraderRecipeHandlerRecipeViewer recipeViewer;

	public FATraderRecipeHandler(String unlocalizedName, String faction, LOTRTradeEntries itemsBought, LOTRTradeEntries itemsSold) {
		super("lotr-fa.trader.", unlocalizedName, faction, itemsBought, itemsSold);
		this.recipeViewer = new FATraderRecipeHandlerRecipeViewer(this);

	}

	// TODO fix the ugly this.getUnlocalizedName().split("\\." hack with the next NEI LOTR version
	@Override
	public String getDisplayName() {
		return StatCollector
				.translateToLocal("entity.lotrfa." + this.getUnlocalizedName().split("\\.")[this.getUnlocalizedName().split("\\.").length - 1] + ".name");
	}

	@Override
	public RecipeHandlerRecipeViewer<TraderRecipe> getRecipeViewer() {
		return recipeViewer;
	}

	public class FATraderRecipeHandlerRecipeViewer extends TraderRecipeHandlerRecipeViewer {

		public FATraderRecipeHandlerRecipeViewer(AbstractTraderRecipeHandler handler) {
			super(handler);
		}

		public boolean isGuiContainerSupported(GuiContainer container) {
			if (container instanceof LOTRGuiTrade) {
				LOTRGuiTrade tradeGui = (LOTRGuiTrade) container;
				if (!this.handler.getUnlocalizedName().split("\\.")[this.handler.getUnlocalizedName().split("\\.").length - 1]
						.equals(LOTRRecipeHandlerUtils.getUnlocalizedEntityName(tradeGui.theEntity.getClass()).replaceAll("lotrfa.", ""))) { return false; }
			}
			return true;
		}

	}

}
