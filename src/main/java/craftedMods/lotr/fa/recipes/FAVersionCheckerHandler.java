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

import craftedMods.recipes.api.*;
import craftedMods.utils.*;

@RegisteredHandler
public class FAVersionCheckerHandler implements VersionCheckerHandler {

	public static final SemanticVersion NEI_LOTR_FA_VERSION = new SemanticVersion(EnumVersionState.BETA, 1, 2, 0);

	@Override
	public SemanticVersion getCurrentVersion() {
		return NEI_LOTR_FA_VERSION;
	}

	@Override
	public String getLocalizedHandlerName() {
		return "NEI LOTR FA";
	}

	@Override
	public String getVersionFileURL() {
		return "https://raw.githubusercontent.com/CraftedMods/nei-lotr-fa/master/version.txt";
	}

}
