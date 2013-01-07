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
 *     Last modified: 16.10.12 20:02
 */

package com.p000ison.dev.simpleclans2.clanplayer;

import com.p000ison.dev.simpleclans2.SimpleClans;
import com.p000ison.dev.simpleclans2.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

/**
 * Represents a OnlineClanPlayer
 */
public class OnlineClanPlayer {

    private SimpleClans plugin;
    private ClanPlayer clanPlayer;
    private PermissionAttachment attachment;

    public OnlineClanPlayer(SimpleClans plugin, ClanPlayer clanPlayer)
    {
        this.plugin = plugin;
        this.clanPlayer = clanPlayer;
    }

    /**
     * Returns a player object. May be null if the player is not online
     *
     * @return Returns a player object.
     */
    public Player toPlayer()
    {
        return plugin.getServer().getPlayerExact(clanPlayer.getName());
    }

    /**
     * Setups the permission attachment of this clanplayer based on his clan
     */
    public void setupPermissions()
    {
        Clan clan = clanPlayer.getClan();
        if (clan == null) {
            return;
        }

        attachment = toPlayer().addAttachment(plugin);
        attachment.setPermission(String.valueOf(clan.getID()), true);
        attachment.setPermission("^" + clan.getID(), true);
    }

    /**
     * Removes the current PermissionAttachment
     */
    public void removePermissions()
    {
        if (attachment != null) {
            attachment.remove();
            attachment = null;
        }
    }
}