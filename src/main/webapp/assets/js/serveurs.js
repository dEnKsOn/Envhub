// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initServeursLocal() {
    // 1. Filtrage à la volée
    const searchInput = document.getElementById('search-input');
    const searchForm = document.getElementById('search-form');
    const tableBody = document.getElementById('serveurs-table-body');
    const noResultsMessage = document.getElementById('no-results-message');
    const noResultsQuery = document.getElementById('no-results-query');

    if (searchInput && tableBody) {
        searchInput.addEventListener('input', function(e) {
            const term = e.target.value.toLowerCase();
            const rows = tableBody.querySelectorAll('tr');
            let hasVisibleRows = false;

            rows.forEach(row => {
                if (row.cells.length > 1) {
                    const text = row.textContent.toLowerCase();
                    if (text.includes(term)) {
                        row.style.display = '';
                        hasVisibleRows = true;
                    } else {
                        row.style.display = 'none';
                    }
                }
            });

            // 2. Gestion de l'Empty State (Message introuvable)
            if (noResultsMessage && noResultsQuery) {
                if (!hasVisibleRows && term.trim() !== '') {
                    noResultsQuery.textContent = e.target.value;
                    noResultsMessage.style.display = 'flex';
                } else {
                    noResultsMessage.style.display = 'none';
                }
            }
        });
    }

    if (searchForm) {
        searchForm.addEventListener('submit', function(e) {
            e.preventDefault();
        });
    }

    // --- Fin recherche instantanée ---
})();

// Gestion des événements via délégation pour supporter le chargement AJAX
if (!window.serveursJsInitialized) {
    window.serveursJsInitialized = true;

    function openModal(modal) {
        if (modal) {
            modal.classList.add('is-visible');
            modal.setAttribute('aria-hidden', 'false');
        }
    }

    function closeModal(modal) {
        if (modal) {
            modal.classList.remove('is-visible');
            modal.setAttribute('aria-hidden', 'true');
        }
    }

    function openServeurModal(mode = 'create', serveur = {}) {
        const modal = document.getElementById('serveur-modal');
        if (!modal) return;
        
        document.getElementById('serveur-form-action').value = mode === 'edit' ? 'update' : 'create';
        document.getElementById('serveur-modal-title').textContent = mode === 'edit' ? 'Modifier le serveur' : 'Ajouter un serveur';
        
        // Remplissage des champs
        document.getElementById('serveurId').value = serveur.id || '';
        document.getElementById('adressIP').value = serveur.adressIP || '';
        document.getElementById('os').value = serveur.os || '';
        document.getElementById('fournisseur').value = serveur.fournisseur || '';
        document.getElementById('cpuCores').value = serveur.cpuCores || '';
        document.getElementById('ramGb').value = serveur.ramGb || '';

        openModal(modal);
    }

    document.addEventListener('click', function(e) {
        // 4. Connexion du bouton "Ajouter" (y compris le bouton de l'Empty State)
        if (e.target.closest('#btn-add-serveur') || e.target.closest('.open-serveur-modal')) {
            e.preventDefault();
            openServeurModal('create');
        }

        // Bouton Modifier
        const btnEdit = e.target.closest('.edit-serveur-btn');
        if (btnEdit) {
            e.preventDefault();
            openServeurModal('edit', {
                id: btnEdit.dataset.serveurId,
                adressIP: btnEdit.dataset.adressip,
                os: btnEdit.dataset.os,
                fournisseur: btnEdit.dataset.fournisseur,
                cpuCores: btnEdit.dataset.cpu,
                ramGb: btnEdit.dataset.ram
            });
        }

        // Bouton Supprimer
        const btnDelete = e.target.closest('.delete-serveur-btn');
        if (btnDelete) {
            e.preventDefault();
            document.getElementById('delete-serveur-id').value = btnDelete.dataset.serveurId;
            document.getElementById('delete-serveur-ip').textContent = btnDelete.dataset.serveurIp;
            openModal(document.getElementById('delete-serveur-modal'));
        }

        // Fermeture des modales
        if (e.target.closest('.modal-close') || e.target.closest('.btn-secondary') || e.target.matches('.modal-overlay')) {
            closeModal(document.getElementById('serveur-modal'));
            closeModal(document.getElementById('delete-serveur-modal'));
        }
    });
}

// S'assurer que les icônes sont rendues immédiatement (compatible AJAX)
if (typeof window.refreshLucideIcons === 'function') {
    window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
    lucide.createIcons();
}