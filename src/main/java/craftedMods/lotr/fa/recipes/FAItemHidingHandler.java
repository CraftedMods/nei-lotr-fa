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
package craftedMods.lotr.fa.recipes;

import java.util.*;

import craftedMods.recipes.api.*;
import eoa.lotrfa.common.block.LOTRFABlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

@RegisteredHandler
public class FAItemHidingHandler implements ItemHidingHandler {

	private static final Collection<ItemStack> hiddenStacks = new ArrayList<>();

	@Override
	public Collection<ItemStack> getHiddenStacks() {
		FAItemHidingHandler.hiddenStacks.clear();

		// Slabs
		this.hideItemMeta(LOTRFABlocks.slabSingle);
		this.hideItemMeta(LOTRFABlocks.slabSingle2);
		this.hideItemMeta(LOTRFABlocks.slabSingle3);
		this.hideItemMeta(LOTRFABlocks.slabSingle4);
		this.hideItemMeta(LOTRFABlocks.slabSingleSarnlum);
		this.hideItemMeta(LOTRFABlocks.slabSingleWood);
		this.hideItemMeta(LOTRFABlocks.slabSingleWool);
		this.hideItemMeta(LOTRFABlocks.slabSingleWool2);

		// Double slabs
		this.hideItemAll(LOTRFABlocks.slabDouble);
		this.hideItemAll(LOTRFABlocks.slabDouble2);
		this.hideItemAll(LOTRFABlocks.slabDouble3);
		this.hideItemAll(LOTRFABlocks.slabDouble4);
		this.hideItemAll(LOTRFABlocks.slabDoubleSarnlum);
		this.hideItemAll(LOTRFABlocks.slabDoubleWood);
		this.hideItemMeta(LOTRFABlocks.slabDoubleWool);
		this.hideItemMeta(LOTRFABlocks.slabDoubleWool2);

		return FAItemHidingHandler.hiddenStacks;
	}

	private void hideItemMeta(ItemStack stack) {
		for (int i = 8; i < 16; i++) {
			FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, i));
		}
	}

	private void hideItemMeta(Block block) {
		this.hideItemMeta(new ItemStack(block));
	}

	// private void hideItemMeta(Item item) {
	// this.hideItemMeta(new ItemStack(item));
	// }

	private void hideItemAll(ItemStack stack) {
		FAItemHidingHandler.hiddenStacks.add(new ItemStack(stack.getItem(), 1, 32767));
	}

	private void hideItemAll(Block block) {
		this.hideItemAll(new ItemStack(block));
	}

	// private void hideItemAll(Item item) {
	// this.hideItemAll(new ItemStack(item));
	// }

}
