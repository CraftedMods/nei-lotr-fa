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

import craftedMods.lotr.recipes.api.recipeHandlers.AbstractAlloyForgeRecipeHandler;
import net.minecraft.item.ItemStack;
import valiec.lotrfa.LOTRTileEntityRedDwarvenForge;

public class FAAlloyForgeRecipeHandler extends AbstractAlloyForgeRecipeHandler {

	public FAAlloyForgeRecipeHandler(String unlocalizedName, AlloyForgeAccess alloyForgeDummy) {
		super("lotr.fa.alloyForge" + unlocalizedName, alloyForgeDummy);
	}

	public static class RedDwarvenAlloyForgeAccess extends LOTRTileEntityRedDwarvenForge implements AlloyForgeAccess {

		@Override
		public String getName() {
			return super.getForgeName();
		}

		@Override
		public ItemStack getAlloyResult(ItemStack ingredient, ItemStack alloy) {
			return super.getAlloySmeltingResult(ingredient, alloy);
		}

		@Override
		public ItemStack getSmeltingResult(ItemStack itemstack) {
			return super.getSmeltingResult(itemstack);
		}

	}

}
