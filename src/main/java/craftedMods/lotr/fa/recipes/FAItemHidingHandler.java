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

import craftedMods.recipes.api.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import valiec.lotrfa.LOTRFA;

@RegisteredHandler
public class FAItemHidingHandler implements ItemHidingHandler {

	private static final Collection<ItemStack> hiddenStacks = new ArrayList<>();

	@Override
	public Collection<ItemStack> getHiddenStacks() {
		FAItemHidingHandler.hiddenStacks.clear();

		// Slabs
		this.hideItemMeta(LOTRFA.slabSingle);
		this.hideItemMeta(LOTRFA.gondSlabSingle);

		this.hideItemMeta(LOTRFA.slabDouble);
		this.hideItemMeta(LOTRFA.gondSlabDouble);

		return FAItemHidingHandler.hiddenStacks;
	}

	private void hideItemMeta(ItemStack stack) {
		for (int i = 8; i < 16; i++)
			FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, i));
	}

	private void hideItemMeta(Block block) {
		this.hideItemMeta(new ItemStack(block));
	}

	// private void hideItemMeta(Item item) {
	// this.hideItemMeta(new ItemStack(item));
	// }

	// private void hideItemAll(ItemStack stack) {
	// FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, 32767));
	// }

	// private void hideItemAll(Block block) {
	// this.hideItemAll(new ItemStack(block));
	// }

	// private void hideItemAll(Item item) {
	// this.hideItemAll(new ItemStack(item));
	// }

}
