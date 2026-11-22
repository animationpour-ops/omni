# Omnimine — « Minecraft mais tout se mine » (v2)

Mod **Forge 1.20.1** (47.x). Avec une **pioche en bedrock** portant l'enchantement **Omniminage**, tu peux miner
**n'importe quoi** : des mobs, le **Soleil**, la **Lune**, des **éclairs** (les vrais, ceux de l'orage) et même des
**structures entières**. Tout atterrit dans ton inventaire et se transforme en objets à pouvoirs, avec plein d'effets
visuels et de sons.

> ⚠️ Ce mod a été écrit sans pouvoir le compiler ni le lancer (pas de Minecraft dans mon environnement).
> Si GitHub affiche des erreurs, envoie-moi le log rouge et je corrige (comme pour Néant).

## Nouveautés de la v2 (tes retours)

- **Armure** : c'est maintenant le **vrai modèle de l'armure en Netherite**, juste repeint (même forme, même découpe) :
  ton skin reste visible (visage, mains, jambes). L'armure d'éclair est bleu électrique avec des veines de foudre
  animées, les bottes lunaires sont argentées. Le dessin est peint au lancement à partir de la texture Netherite de
  ton jeu ; si ça échoue, le jeu affiche simplement la Netherite normale.
- **Éclairs** : le mod **ne crée plus jamais d'éclair**. Tu récoltes **la vraie foudre de l'orage**, attirée par un
  **paratonnerre en cuivre** (voir §4). Elle est figée en l'air quelques secondes, dessinée par le rendu de foudre de
  Minecraft lui-même, et tu la mines.
- **Pouvoirs bien plus destructeurs** : cratères, tunnels, explosions en chaîne, gros dégâts, grosses zones. Les
  jambières d'éclair donnent une **vraie vitesse** (+60 % en permanence et Rapidité IV en sprint).
- **Minage** : ce sont les **fissures vanilla** de Minecraft (les `destroy_stage`, comme quand tu mines du fer) qui
  apparaissent sur le mob, sur le disque du Soleil / de la Lune, sur l'éclair, et sur les vrais blocs d'une structure.
- **Essences** : chaque essence est un **mini-modèle 3D du mob** (le vrai modèle vanilla réduit, qui tourne au sol).

Si tu avais la v1 : le `.jar` garde le même nom (`omnimine-1.0.0.jar`), remplace-le dans `mods` (ne garde pas les deux).

---

## 1. Compiler avec GitHub

1. Sur github.com → **New repository** (privé, c'est très bien).
2. Dézippe `omnimine_mod.zip`. Dans le dépôt : **Add file → Upload files**, puis glisse **tout le contenu** du dossier
   (pas le dossier lui-même) : `.github`, `gradle`, `src`, `build.gradle`, `gradle.properties`, `settings.gradle`,
   `gradlew`, `gradlew.bat`, `.gitignore`, `README.md`.
   - Les dossiers qui commencent par un point (`.github`) sont cachés sous Windows/Mac. Si l'onglet **Actions** reste
     vide, crée le fichier à la main : **Add file → Create new file**, nom `.github/workflows/build.yml`, et colle le
     contenu du fichier `build.yml` du zip.
   - Si tu mets à jour un dépôt de la v1 : envoie tout par-dessus (le dossier `src` surtout, des fichiers Java ont
     changé et 3 sont nouveaux ; aucun n'est supprimé). Les anciennes images (`mob_*.png`, `lightning_layer_*.png`)
     ne servent plus mais ne gênent pas si tu les laisses.
3. **Commit changes**. L'onglet **Actions** lance « Build mod » tout seul (3 à 6 minutes la première fois).
4. Quand c'est vert ✔ : ouvre l'exécution, tout en bas **Artifacts → `omnimine-jar`**, télécharge, dézippe :
   tu obtiens `omnimine-1.0.0.jar`.
5. Mets le `.jar` dans le dossier `mods` de Minecraft **1.20.1 avec Forge 47.3.0 ou plus récent**.
   Pour un serveur, le mod doit être installé côté serveur **et** côté client.
6. Si c'est rouge ✖ : clique sur le job **build** → étape **Compiler**, copie les lignes contenant `error:` et envoie-les.

## 2. Démarrage rapide (tournage)

Commandes (opérateur / triche activée) :

| Commande | Effet |
|---|---|
| `/omnimine kit` | pioche en bedrock enchantée + livre Omniminage |
| `/omnimine tout` | le kit + épée, bottes, armure d'éclair, 8 essences de mobs, 11 structures minées |
| `/omnimine orage` | lance simplement un **orage** (comme `/weather thunder`). Le mod ne crée **aucun** éclair : il te faut un paratonnerre en cuivre (voir §4) |
| `/omnimine ciel` | ramène tout de suite le Soleil et la Lune s'ils ont été minés |
| `/omnimine soleil` · `lune` · `livre` | donne l'épée du Soleil · les bottes lunaires · le livre Omniminage |

## 3. Obtenir la pioche et l'enchantement

- **Pioche en bedrock** : 3 obsidiennes en haut + 2 bâtons (forme d'une pioche normale). Incassable, très rapide sur
  les blocs.
- **Enchantement Omniminage** : le **libraire** (villageois bibliothécaire) vend le livre contre **1 bloc d'émeraude**,
  dès le niveau novice (échange garanti : le mod remplace ses échanges de niveau 1 par celui-là et « 24 papiers → 1 émeraude »).
  Applique le livre sur la pioche à l'enclume.
- Sans l'enchantement, la pioche ne mine que les blocs.

## 4. Miner (« tout se mine »)

**Maintiens le clic gauche** : le minage est progressif comme dans Minecraft (barre de progression dans la barre d'action,
**fissures vanilla** qui se creusent sur la cible, bruits de pierre, particules). Si tu relâches, la progression retombe.
La cible se fige pendant le minage (un mob ne bouge plus).

| Cible | Comment | Tu obtiens |
|---|---|---|
| **Mob** (squelette, creeper, zombie, araignée, gardien, villageois, golem de fer, enderman) | viser à moins de 5 blocs | une **essence** du mob |
| **Soleil** | viser le Soleil dans le ciel (de jour) | **Épée du Soleil** — le Soleil disparaît, la nuit tombe, il revient après ~90 s |
| **Lune** | viser la Lune (de nuit) | **Bottes Lunaires** |
| **Éclair** | viser l'éclair figé (jusqu'à 72 blocs), voir ci-dessous | une pièce de l'**armure d'éclair** (d'abord une pièce que tu n'as pas encore) |
| **Structure** | **accroupi (Shift)** + clic gauche maintenu sur un bloc de la structure | **Structure : X** (la structure se dissout du paysage) |

Temps de minage de base (réglable) : mobs 2 à 5,5 s (villageois 2 s, golem de fer 5,5 s) · éclair ~1,2 s · Lune 6 s ·
Soleil 7 s · structures 6 à 10 s.

### Récolter un éclair (récolte naturelle, comme dans le jeu)

1. Fabrique un **paratonnerre en cuivre** (3 lingots de cuivre en colonne) et pose-le **tout en haut** d'une tour ou
   d'une colline : il doit être le point le plus haut de sa colonne, sinon la foudre l'ignore. Il faut un biome où il
   pleut (pas de désert, pas de biome neigeux).
2. Garde la **pioche enchantée dans ton inventaire** et reste à moins de **64 blocs** du paratonnerre (`boltCaptureRadius`).
3. Il faut un **orage** : attends-le, ou tape `/omnimine orage` (ou `/weather thunder`).
4. Quand la **vraie foudre** de l'orage tombe sur ton paratonnerre, elle est **figée dans le ciel** pendant 14 s
   (`boltFreezeSeconds`), avec tonnerre et message dans la barre d'action. Vise-la et maintiens le clic gauche
   environ 1 seconde : elle se brise et tu obtiens une pièce de l'armure d'éclair.
5. Si tu ne la mines pas à temps, elle retombe pour de vrai, comme une foudre normale (feu, dégâts, creepers chargés…).

La foudre d'orage tombe au hasard autour des joueurs, pas sur commande : en orage, compte en moyenne une foudre toutes
les quelques dizaines de secondes, et le paratonnerre attire celles qui tombent à moins de 128 blocs. Pour accélérer,
monte la **distance de simulation** (Options → Vidéo) et laisse tourner l'orage. Pour que **n'importe quel éclair** proche
soit capturé même sans paratonnerre, mets `boltNeedsRod = false` dans la config.

## 5. Les pouvoirs

Les pouvoirs sont conçus pour être **très destructeurs** : explosions sans objets au sol (donc pas de lag), cratères
irréguliers, tunnels, failles, gros dégâts. Les gros pouvoirs te donnent une résistance temporaire au moment de
l'impact pour que tu ne t'auto-détruises pas. Tout ce qui détruit le décor se coupe d'un coup avec `terrainDestruction = false` (les dégâts aux mobs
restent).

**Essences de mobs** (clic droit, 1 pouvoir chacune, avec recharge) :

| Essence | Pouvoir | Recharge |
|---|---|---|
| Squelette | **Tempête d'os** : 3 s de pluie d'os sur 11 blocs de rayon, chaque os creuse un petit cratère et inflige des dégâts, grosse explosion finale | 6 s |
| Creeper | **Explosion verte** : la zone se charge, puis explosion de puissance 14 (plus de 3 fois la TNT), énorme cratère, 8 explosions supplémentaires autour, tout est projeté sur 24 blocs | 9 s |
| Zombie | **Souffle de peste** : cône de 22 blocs, Wither III, Faiblesse III et Lenteur, toute la végétation du cône fane, tu te soignes | 7 s |
| Araignée | **Toile géante** : 260 fils sur 10 blocs de rayon, les ennemis sont attirés, Lenteur V et mordus (24 dégâts au total) | 8 s |
| Gardien | **Rayon** : charge de 1,5 s, puis perce tout sur 60 blocs (tunnel de 6 blocs de large, 40 dégâts) et explose au bout | 10 s |
| Villageois | **Cri du village** : 3 ondes sonores jusqu'à 20 blocs, 14 dégâts, nausée, verre / feuilles / plantes brisés, émeraudes qui jaillissent | 7 s |
| Golem de fer | **Frappe** : le sol se fend en 12 failles profondes sur 16 blocs, des dizaines de blocs sont arrachés, tout est catapulté (40 dégâts) | 9 s |
| Enderman | **Passage de l'ombre** : téléportation à 50 blocs vers ta visée **en creusant un tunnel dans tout le décor**, 30 dégâts aux ennemis traversés, onde de choc à l'arrivée | 6 s |

**Épée du Soleil** :
1. Chaque coup embrase la cible (15 s) et déclenche une éruption solaire de 7 blocs : dégâts, projection, feux qui se
   propagent au décor. Tu es insensible au feu.
2. Clic droit (recharge 12 s) : un rayon du Soleil s'abat jusqu'à 96 blocs. Après 1,5 s de charge : explosion, cratère
   de 15 blocs (le centre est vaporisé, le pourtour devient magma et braises), 90 dégâts et incendie sur 18 blocs.

**Bottes Lunaires** :
1. Gravité lunaire : super saut (Saut amélioré IV), **deux sauts de plus en l'air** (appuie sur saut ; chacun projette
   les ennemis proches), aucun dégât de chute.
2. Accroupi en l'air : plongeon, puis **impact lunaire** de 16 blocs : cratère, explosion, 60 dégâts, Lenteur IV, petites
   explosions en couronne.

**Armure d'éclair** (1 pouvoir par pièce, modèle Netherite repeint) :
- **Casque** : foudre en chaîne. Chaque coup au corps à corps frappe ta cible (+12 dégâts) puis la foudre saute d'ennemi
  en ennemi (jusqu'à 10, à 13 blocs maximum entre chaque), 16 dégâts et une explosion à chaque saut.
- **Plastron** : décharge statique. Quand on te frappe, une onde de 14 blocs foudroie et projette tout le monde
  (30 dégâts, Lenteur IV), puis 8 foudres explosives tombent autour de toi (recharge 2 s). Immunité à la foudre.
- **Jambières** : course foudroyante. **+60 % de vitesse en permanence** (attribut de l'armure) et **Rapidité IV** dès que
  tu cours : vitesse folle. Tu défonces les murs devant toi, la traînée électrique foudroie et ralentit les ennemis,
  et la foudre frappe l'ennemi le plus proche (22 dégâts) toutes les 0,75 s.

**Structures évoluées** : une structure minée est inutile seule. Table de craft : la **structure au centre** entourée de
**8 blocs** correspondants (l'infobulle le rappelle). Clic droit sur la structure évoluée = cérémonie de lumière puis items cheat.

| Structure | 8 blocs autour | Items cheat |
|---|---|---|
| Village | blocs de foin | 2 totems, 16 pommes dorées, 8 blocs d'émeraude |
| Avant-poste de pillards | bûches de chêne noir | arbalète (Charge rapide III, Perforation IV), 64 fusées, 1 totem |
| Manoir | planches de chêne noir | 4 totems, 2 pommes dorées enchantées |
| Monument océanique | seaux d'eau (rendus vides) | trident (Empalement V, Loyauté III, Canalisation), 2 conduits, cœur de la mer |
| Pyramide du désert | grès | 6 pommes dorées enchantées, 32 TNT |
| Temple de la jungle | pierre moussue | 32 pommes dorées, livre Réparation |
| Forteresse du Nether | briques du Nether | 4 lingots de netherite, 3 crânes de wither squelette |
| Bastion | pierre noire | 6 lingots de netherite, 16 blocs d'or, 1 pomme dorée enchantée |
| Cité de l'End | blocs de purpur | élytres, 64 fusées, 2 shulker boxes, tête de dragon |
| Forteresse (Stronghold) | pierre taillée | 12 yeux d'ender, 16 perles, 1 totem |
| Cité antique | deepslate taillée | livre Réparation, 8 éclats d'écho, 2 totems, 2 pommes dorées enchantées |

## 6. Configuration

Fichier `config/omnimine-common.toml` (créé au premier lancement) :

| Option | Défaut | Rôle |
|---|---|---|
| `miningSpeed` | 1.0 | vitesse du minage (2.0 = deux fois plus vite) |
| `boltFreezeSeconds` | 14 | durée d'un éclair figé avant de retomber pour de vrai |
| `boltCaptureRadius` | 64 | rayon autour d'un joueur portant la pioche dans lequel la foudre est capturée |
| `boltNeedsRod` | true | `true` : seule la foudre qui tombe sur un paratonnerre en cuivre est capturée ; `false` : toute foudre proche |
| `dissolveBlocksPerTick` | 2500 | vitesse de dissolution d'une structure minée |
| `sunReturnSeconds` / `moonReturnSeconds` | 90 | retour du Soleil / de la Lune minés |
| `forceNightWithoutSun` | true | sans Soleil, la nuit tombe |
| `terrainDestruction` | true | les pouvoirs détruisent le décor : cratères, tunnels, failles, arrachage de blocs (mets `false` pour ne rien casser) |

## 7. Si quelque chose cloche

- **Rouge sur GitHub** : copie les lignes `error:` de l'étape **Compiler** et envoie-les.
- **Une essence est invisible** : ouvre `logs/latest.log` et cherche « impossible de dessiner l'essence en 3D » ; envoie-moi
  les lignes autour (l'affichage 3D se désactive après une erreur pour ne pas faire planter le jeu).
- **L'armure ressemble à de la Netherite normale** : la peinture automatique a échoué (cherche « impossible de generer la
  texture d'armure » dans `latest.log`).
- **Ça rame pendant un gros pouvoir** : mets `terrainDestruction = false`, ou envoie-moi ce que tu faisais.

## 8. Ce que j'ai supposé (à me dire si tu veux autre chose)

- Pioche craftable avec 3 obsidiennes + 2 bâtons (pas cher, comme demandé).
- L'enchantement s'achète en livre chez le libraire, 1 bloc d'émeraude, échange garanti au niveau novice.
- Seuls les 8 mobs demandés se minent ; les autres mobs ne réagissent pas à la pioche.
- Pour les structures, il faut être **accroupi** (sinon le clic gauche mine un bloc normalement) ; la structure doit
  avoir été générée par le jeu (village, avant-poste, manoir, monument, pyramide, temple, forteresse du Nether, bastion,
  cité de l'End, forteresse, cité antique).
- Les éclairs se récoltent uniquement quand la foudre d'orage tombe sur un paratonnerre en cuivre (ou sur n'importe
  quoi si tu mets `boltNeedsRod = false`) et que tu portes la pioche enchantée à moins de 64 blocs.
- Les objets qui existent dans Minecraft gardent leur forme vanilla, seul le dessin change : pioche (pierre repeinte),
  épée du Soleil (épée dorée), bottes lunaires, armure d'éclair (modèle Netherite, texture générée à l'exécution).
  Les structures ont leurs propres icônes (aucun personnage Minecraft dessiné) ; les essences sont des mini-modèles 3D.
- Tout est calculé côté serveur : le mod fonctionne aussi sur un serveur dédié (installe-le des deux côtés).
