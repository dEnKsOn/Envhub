/**
 * dev-projets.js
 * Gère la recherche en temps réel pour la grille "Mes Projets" du développeur
 */
(function initDevProjets() {
    const searchInput = document.getElementById('search-input');
    const searchForm = document.getElementById('search-form');
    const gridContainer = document.querySelector('.projets-grid');
    const noResultsMessage = document.getElementById('no-results-message');
    const noResultsQuery = document.getElementById('no-results-query');

    if (searchInput && gridContainer) {
        searchInput.addEventListener('input', function(e) {
            const term = e.target.value.toLowerCase();
            const cards = gridContainer.querySelectorAll('.projet-card');
            let hasVisibleItems = false;

            // Filtrage des cartes
            cards.forEach(card => {
                const text = card.textContent.toLowerCase();
                if (text.includes(term)) {
                    card.style.display = 'flex'; // Remet le display: flex de la carte
                    hasVisibleItems = true;
                } else {
                    card.style.display = 'none';
                }
            });

            // Affichage du message "Aucun résultat" si besoin
            if (noResultsMessage && noResultsQuery) {
                if (!hasVisibleItems && term.trim() !== '') {
                    noResultsQuery.textContent = e.target.value;
                    noResultsMessage.style.display = 'flex';
                } else {
                    noResultsMessage.style.display = 'none';
                }
            }
        });

        // Empêcher la soumission du formulaire avec la touche Entrée
        if (searchForm) {
            searchForm.addEventListener('submit', function(e) {
                e.preventDefault();
            });
        }
    }

    // Initialisation des icônes Lucide si elles n'ont pas été chargées
    if (typeof window.refreshLucideIcons === 'function') {
        window.refreshLucideIcons();
    } else if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }
})();