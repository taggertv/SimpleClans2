/*
 * This file is part of SimpleClans2 (2012).
 *
 *     SimpleClans2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SimpleClans2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SimpleClans2.  If not, see <http://www.gnu.org/licenses/>.
 *
 *     Last modified: 09.01.13 19:20
 */

package com.p000ison.dev.simpleclans2.api.clanplayer;

import com.p000ison.dev.simpleclans2.api.Flags;

import java.io.Serializable;
import java.util.Set;

/**
 *
 */
public interface PlayerFlags extends Serializable, Flags {
    /**
     * Adds a past clan to this clan.
     *
     * @param clan The clan to add.
     */
    void addPastClan(String clan);

    /**
     * Removes a past clan to this clan.
     *
     * @param clan The id of the clan to remove.
     */
    void removePastClan(String clan);

    Set<String> getPastClans();

    void setFriendlyFire(boolean bool);

    boolean isFriendlyFireEnabled();

    boolean isCapeEnabled();

    void setCapeEnabled(boolean enabled);

    boolean isBBEnabled();

    void setBBEnabled(boolean enabled);
}
