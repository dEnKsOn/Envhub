// --- Initialisation locale ---
(function initDemandesLocal() {
})();

// Gestion des événements via délégation pour supporter le chargement AJAX
if (!window.demandesJsInitialized) {
    window.demandesJsInitialized = true;

    // --- Fonctions Utilitaires Modales ---
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

    // --- Délégation d'événements globale ---
    document.addEventListener('click', function(e) {
        
        // 1. Ouvrir modale d'ajout
        const btnAdd = e.target.closest('#btn-add-demande');
        if (btnAdd) {
            e.preventDefault();
            openModal(document.getElementById('add-demande-modal'));
            return;
        }

        // 2. Ouvrir modale Voir (Oeil)
        const btnView = e.target.closest('.view-demande-btn');
        if (btnView) {
            e.preventDefault();
            const titreEl = document.getElementById('lbl-modal-titre');
            const clientEl = document.getElementById('lbl-modal-client');
            const emailEl = document.getElementById('lbl-modal-email');
            const besoinEl = document.getElementById('lbl-modal-besoin');

            if (titreEl) titreEl.textContent = btnView.dataset.titre;
            if (clientEl) clientEl.textContent = btnView.dataset.client;
            if (emailEl) emailEl.textContent = btnView.dataset.email;
            if (besoinEl) besoinEl.textContent = btnView.dataset.besoin;

            openModal(document.getElementById('view-demande-modal'));
            return;
        }

        // 3. Ouvrir modale Accepter
        const btnAccept = e.target.closest('.accept-demande-btn');
        if (btnAccept) {
            e.preventDefault();
            document.getElementById('accept-demande-id').value = btnAccept.dataset.id;
            document.getElementById('accept-demande-titre').textContent = btnAccept.dataset.titre;
            openModal(document.getElementById('accept-demande-modal'));
            return;
        }

        // 4. Ouvrir modale Rejeter
        const btnReject = e.target.closest('.reject-demande-btn');
        if (btnReject) {
            e.preventDefault();
            document.getElementById('reject-demande-id').value = btnReject.dataset.id;
            document.getElementById('reject-demande-titre').textContent = btnReject.dataset.titre;
            openModal(document.getElementById('reject-demande-modal'));
            return;
        }

        // 5. Ouvrir modale Supprimer
        const btnDelete = e.target.closest('.delete-demande-btn');
        if (btnDelete) {
            e.preventDefault();
            document.getElementById('delete-demande-id').value = btnDelete.dataset.id;
            openModal(document.getElementById('delete-demande-modal'));
            return;
        }

        // 6. Fermeture des Modales (Croix et boutons Annuler)
        if (e.target.closest('#close-add-modal') || e.target.closest('#cancel-add-modal')) {
            e.preventDefault(); closeModal(document.getElementById('add-demande-modal')); return;
        }
        if (e.target.closest('#close-view-modal') || e.target.closest('#btn-close-view-text')) {
            e.preventDefault(); closeModal(document.getElementById('view-demande-modal')); return;
        }
        if (e.target.closest('#close-accept-modal') || e.target.closest('#cancel-accept-modal')) {
            e.preventDefault(); closeModal(document.getElementById('accept-demande-modal')); return;
        }
        if (e.target.closest('#close-reject-modal') || e.target.closest('#cancel-reject-modal')) {
            e.preventDefault(); closeModal(document.getElementById('reject-demande-modal')); return;
        }
        if (e.target.closest('#close-delete-modal') || e.target.closest('#cancel-delete-modal')) {
            e.preventDefault(); closeModal(document.getElementById('delete-demande-modal')); return;
        }

        // Clic sur l'overlay pour fermer
        if (e.target.matches('.modal-overlay')) {
            closeModal(e.target);
        }
    });
}

// Rendu des icônes
if (typeof window.refreshLucideIcons === 'function') {
    window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
    lucide.createIcons();
}