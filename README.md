# Songs of War

![forge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/forge_vector.svg)
![fabric](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg)
![quilt](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/unsupported/quilt_vector.svg)

This is a mod to add elements from [Songs of War Animation](https://youtu.be/Uc7YMW3AKpg).

~~Put me into the washing machine like the logo if you meet any bugs.~~

## Credit

**Squared Media (Black Plasma Studio)**: Animation author and assets.

## Features

### Various Weapons

All weapons in animation and variant.

<div align=center><img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/1.webp" style="width:400px;text-align:center;" alt=""></img></div>

### Back&Belt Item Render

Most weapon are wearable on back and belt. (Thanks for `Curios` and `Trinkets`)

<div align=center><img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/2.webp" style="width:400px;text-align:center;" alt=""></img></div>

### Upgrading Stone

Song Stone forging system allow you to upgrade your weapon and will receive colorful glint.

<div align=center><img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/3.webp" style="width:400px;text-align:center;" alt=""></img></div>

### Various Entities

Add almost all characters in animation. Also, every ardoni have their own class and markers.

<div align=center><img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/4.webp" style="width:400px;text-align:center;" alt=""></img></div>

### Song Power System

Restore song power in animation.

<details> <summary>Obtain</summary>

**You need to have access to song abilities/`Ardoni Origin` to use `Song Stones`!**

There are chunks named `Song Chunk` in the world. Craft a `Song Stone` and when you in a song chunk, the color will
change.

Also, you can upgrade with `Notes` to detect specific song chunk. The color will half change if you near a song chunk (
default 2 chunks).

Ones you found a song chunk, you can place a note block and play it. It will drop `Notes`.

The count of `Notes` is 3-6. Ones all of them are dig out, the chunk is no longer a song chunk.

Finally, you can craft songs with `Notes`. Its power will randomize.

**The song chunk will regenerate with 1 note per day (Invoke at midnight/18000 ticks).**

</details>

<details> <summary>Usage</summary>

#### Admin command (Or single player)

`/songpower enable/disable <player>` to enable/disable access to song abilities.

#### Combine song cube

**Mod will also extract a schematic file, you can use it with `Litematica`**

Build a shrine structure below. Put song cube in the hole like how to do in Animation.
Then stand on the `chiseled stone bricks`, look at the song cube and sneak for 3s.

If everything is correct, the song cube will start spawning particles. After an explosion, the combination is completed.

<img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/shrine.png" style="width:256px" alt="">
<img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/shrine.gif" style="width:256px" alt="">

**Note: 1.The stone bricks and stairs can be any kinds. (mossy/cracked ones, can change through datapack.)**

**2.If you already have one in that category, the previous one will be replaced into the hole.**

</details>

<details> <summary>Currently Added Songs</summary>

#### Aggressium

**HotKey: C**

**Damage will be multiple 1.5 when released with a weapon.**

- Aggrobeam **(Experimental)**: Activate a laser, which can damage targeted entities.
- Aggroblast: Push the entity you are looking at away and give damage.
- Aggrodetonate: Fire an explosive short laser.
- Aggroquake: Push entities around you away and damage them.
- Aggroshard: Fire a lot of shards.
- Aggroshock **(Experimental)**: Generate lightnings.
- Aggrosphere: Fire a sphere and damage hit entity or create explosion.
- Aggrostorm **(Experimental)**: Pull entities to you.
- Aggrovortex: Not complete yet.

#### Mobilium

**HotKey: V**

- Mobilibounce: Generate a fake platform and disappear in 5s. You can jump 3x higher on it.
- Mobiliburst: Teleport to the direction you see, also pull every entity on your way away.
- Mobiliflash: Teleport to the direction you see.
- Mobiliglide: Slow falling.
- Mobilileap: Jump boost and invulnerable to fall damage.
- Mobiliwings: Enable a fake elytra and into sliding mode. Press `Jump` key to speed up.

#### Protisium

**HotKey: B**

- Protearmor: Add an armor, can reduce up to 20 damage(Configurable) in next damage.
- Protebarrier: Summon a large protect shield for 3s(Configurable).
- Proteclone: Summon a fake player entity, can block damage once.
- Proteheal: Heal 10 times with 1 health each.
- Protesphere **(Recommend AttributeFix)**: Enable a protect shield and reduce 80% damage.
- Protepoint: Enable a fake shield.

#### Supportium

**HotKey: N**

- Supporekesis: Stop all entities related to aggressium songs in 20 blocks and explode them. (No damage)
- Supporoform: Smelt items. Also, this is the only way to gain ender knight armors in survival.
- Supporolift: Pull the entity you are looking at in 20 blocks.
- Supporospike: Push the entity you are looking at up.

</details>

### Origins Support

Add some origins related to the animation.

<details>
<summary>Added Origins</summary>

| Origin    | Impact | Advantages                                                                                   | Disadvantages                                                                          |
|:----------|:-------|:---------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|
| Ardoni    | High   | +10 Health **(Recommend Max Health Fix)** <br> Use song ability <br> Invulnerable to potions | Cannot use redstone <br> Cannot wear armor greater than leather <br> Cannot use elytra |
| Felina    | Medium | Can climb <br> Speed and jump boost <br> Invulnerable to fall                                | Afraid of water <br> Cannot wear armor greater than iron                               |
| Magnorite | High   | Invulnerable to fire, lava and fall <br> Faster in lava <br> +10 Defense                     | Very afraid of water&cold <br> Cannot use elytra                                       |
| Netharan  | Low    | Invulnerable to fire                                                                         | Afraid of water&cold <br> Cannot use elytra                                            |
| Glacian   | Medium | Invulnerable to powder snow <br> +5 Defense                                                  | Afraid of hot                                                                          |

</details>

### Farmer's Delight Support

Peas! Comes from the countryside!

<div align=center><img src="https://raw.githubusercontent.com/CodeOfArdonia/SongsOfWar/refs/heads/master/img/5.webp" style="width:400px;text-align:center;" alt=""></img></div>

- Peas: Add peas crop which can grow.
- Peas burger, peas cake and other peas related food.
- Peas Can: [Meme](https://youtu.be/TmErrDqnBf0?si=MYqYbNtYMQlT5E84&t=10) item.

#### Future plan

- Add peas wild generate.
- Placeable :)

## Mods Relations

### Dependencies

- `Neptune`: Provide base utilities.
- `Jupiter`: Provide config system.

### Recommended to install

These mods are not mandatory to install, but they are recommended to gain better game experience.

- `Attribute Fix`: Fix `Protesphere` armor value leak.
- `EMI`: Check recipes.
- `Farmer's Delight (Refabricated)`: Enable crafting recipe for Peas Delight items.
- `Litematica`: SoW Mod provide shrine schematic for it.
- `Max Health Fix`: Fix Ardoni Origin health problem.
- `Origins`: SoW Mod provide new origins for it.
- `Tips`: SoW Mod provide quotes for it.

## License

All official textures from SQM (weapons&entities&sounds) are freely to use since they are already in public. **But all
other stuff are All Right Reserved**.

You can freely use this mod in your modpack if you credit us somewhere.

## Any Questions?

Join our Discord: https://discord.gg/NDzz2upqAk