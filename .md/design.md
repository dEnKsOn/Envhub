# Design System : EnvHub

Ce document définit les directives de conception visuelle pour le projet **EnvHub**. Il sert de référence pour maintenir une cohérence graphique à travers toute l'application.

## 1. Typographie

La hiérarchie typographique est divisée en deux polices principales pour assurer un bon contraste entre les titres et le corps du texte.

* **Titres (Headings) :** `Inknut Antiqua`
    * *Utilisation :* Titres principaux (H1, H2, H3), en-têtes de sections, éléments nécessitant un fort impact visuel ou de l'élégance.
* **Corps du texte (Body) :** `Satoshi`
    * *Utilisation :* Paragraphes, descriptions, labels, textes de boutons, et tout autre texte de lecture. Sa nature géométrique et propre contraste bien avec l'Inknut Antiqua.

## 2. Palette de Couleurs

Les couleurs définissent l'identité visuelle d'EnvHub. Voici les valeurs exactes extraites de votre maquette :

| Nom | HEX | RGB | CMYK | Utilisation |
| :--- | :--- | :--- | :--- | :--- |
| **Background** | `#FFFFFF` | 255, 255, 255 | 0, 0, 0, 0 | Fond principal de l'application. |
| **Text** | `#0C1625` | 12, 22, 37 | 68, 41, 0, 85 | Couleur principale pour le texte et les titres. |
| **Primary** | `#64748B` | 100, 116, 139 | 28, 17, 0, 45 | Éléments d'action principaux (boutons, liens, icônes actives). |
| **Accent** | `#324155` | 50, 65, 85 | 41, 24, 0, 67 | Éléments secondaires, états de survol (hover) pour les boutons primaires, éléments mis en avant. |
| **Surface** | `#FFFFFF` | 255, 255, 255 | 0, 0, 0, 0 | Fond des éléments superposés (cartes, modales, menus déroulants). |
| **Border** | `#E2E8F0` | 226, 232, 240 | 6, 3, 0, 6 | Lignes de séparation, contours de cartes, bordures de champs de saisie (inputs). |

## 3. Iconographie

* **Bibliothèque :** [Akar Icons](https://akaricons.com/)
* **Style :** Les icônes doivent conserver un style "outline" (contours) propre et minimaliste, avec une épaisseur de trait constante.
* **Couleur :**
    * Par défaut : `Text` (`#0C1625`) pour les icônes de navigation régulières.
    * Actions/Actif : `Primary` (`#64748B`) pour indiquer l'état actif ou interactif.

## 4. Directives d'Interface (UI Guidelines)

* **Cartes (Cards) :** Utilisez le fond `Surface` (#FFFFFF) entouré d'une bordure fine `Border` (#E2E8F0) de 1px.
* **Boutons :** * *Bouton Primaire :* Fond `Primary` (#64748B) avec texte blanc (#FFFFFF). Au survol (hover), passez au fond `Accent` (#324155).
    * *Bouton Secondaire :* Fond transparent, bordure `Border` (#E2E8F0), texte `Text` (#0C1625).
* **Contrastes :** Veillez à ce que le texte sombre (`#0C1625`) soit utilisé sur les fonds clairs (`Background` ou `Surface`) pour garantir une accessibilité et une lisibilité parfaites.
