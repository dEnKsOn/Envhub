/**
 * dev-projet-details.js
 * Logique Frontend pour l'Espace Développeur (Détails du Projet)
 */
document.addEventListener("DOMContentLoaded", function() {
    
    // 1. Initialisation des icônes Lucide
    if (typeof window.refreshLucideIcons === 'function') {
        window.refreshLucideIcons();
    } else if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // 2. Animation de la barre de progression
    const progressFill = document.querySelector('.progress-fill');
    if (progressFill) {
        const targetWidth = progressFill.style.width;
        progressFill.style.width = '0%';
        setTimeout(() => { progressFill.style.width = targetWidth; }, 150);
    }

    // 3. Utilitaires Modales
    function openModal(id) {
        const modal = document.getElementById(id);
        if (modal) {
            modal.classList.remove('is-hidden');
            modal.classList.add('is-visible');
            modal.setAttribute('aria-hidden', 'false');
        }
    }

    function closeModal(modal) {
        if (modal) {
            modal.classList.remove('is-visible');
            modal.classList.add('is-hidden');
            modal.setAttribute('aria-hidden', 'true');
        }
    }

    // =======================================================================
    // 4. Fonctions pour la gestion des Technologies (Ajout & Édition)
    // =======================================================================

    // Ajout d'une ligne dans la modale "Nouvel Environnement"
    window.addTechnoRow = function() {
        const container = document.getElementById('techno-container');
        if (!container) return;
        
        const firstRow = container.querySelector('.techno-row');
        if (!firstRow) return;
        
        const newRow = firstRow.cloneNode(true);
        newRow.querySelector('select').value = '';
        newRow.querySelector('input[type="text"]').value = '';
        container.appendChild(newRow);
        
        if (typeof lucide !== 'undefined') lucide.createIcons();
    };

    // Ajout d'une ligne VIDE dans la modale "Éditer Environnement" (via Template)
    window.addEditTechnoRow = function() {
        const container = document.getElementById('edit-techno-container');
        const template = document.getElementById('techno-row-template');
        if (!container || !template) return;
        
        const newRow = template.content.cloneNode(true);
        container.appendChild(newRow);
        
        if (typeof lucide !== 'undefined') lucide.createIcons();
    };

    // Ajout d'une ligne PRÉ-REMPLIE dans la modale "Éditer Environnement"
    function appendTechnoRowToEdit(technoId, version) {
        const container = document.getElementById('edit-techno-container');
        const template = document.getElementById('techno-row-template');
        if (!container || !template) return;
        
        const newRow = template.content.cloneNode(true);
        const select = newRow.querySelector('select');
        const input = newRow.querySelector('input[type="text"]');
        
        if (technoId) select.value = technoId;
        if (version && version !== 'null') input.value = version; // Prévient l'affichage du mot 'null'
        
        container.appendChild(newRow);
    }

    // =======================================================================
    // 5. Remplir la modale "Voir" un environnement
    // =======================================================================
    function populateViewEnvModal(btn) {
        document.getElementById('view-env-type').textContent = btn.dataset.envType;
        document.getElementById('view-env-db').textContent = btn.dataset.envDb || 'Non spécifiée';
        
        const serverSpan = document.getElementById('view-env-server');
        if (btn.dataset.envServerIp) {
            serverSpan.innerHTML = `<i data-lucide="server" style="width:14px; margin-right:4px;"></i> ${btn.dataset.envServerIp}`;
            if(btn.dataset.envServerOs) serverSpan.innerHTML += ` (${btn.dataset.envServerOs})`;
        } else {
            serverSpan.innerHTML = `<i data-lucide="laptop" style="width:14px; margin-right:4px;"></i> Poste Local`;
        }

        const linksContainer = document.getElementById('view-env-links');
        linksContainer.innerHTML = '';
        if (btn.dataset.envUrlFront) {
            linksContainer.innerHTML += `<a href="${btn.dataset.envUrlFront}" target="_blank" class="env-access-btn env-access-btn-front"><i data-lucide="monitor"></i> ${btn.dataset.envUrlFront}</a>`;
        }
        if (btn.dataset.envUrlBack) {
            linksContainer.innerHTML += `<a href="${btn.dataset.envUrlBack}" target="_blank" class="env-access-btn env-access-btn-back"><i data-lucide="plug"></i> ${btn.dataset.envUrlBack}</a>`;
        }
        if (!btn.dataset.envUrlFront && !btn.dataset.envUrlBack) {
            linksContainer.innerHTML = '<span class="text-muted text-sm">Aucune URL configurée.</span>';
        }

        const technoContainer = document.getElementById('view-env-technos');
        technoContainer.innerHTML = '';
        try {
            const technos = JSON.parse(btn.dataset.envTechnos || '[]');
            if (technos.length > 0) {
                technos.forEach(t => {
                    const badge = document.createElement('span');
                    badge.className = 'badge badge-outline';
                    badge.textContent = `${t.nom} ${t.version && t.version !== 'null' ? 'v' + t.version : ''}`;
                    technoContainer.appendChild(badge);
                });
            } else {
                technoContainer.innerHTML = '<span class="text-muted text-sm">Aucune technologie associée.</span>';
            }
        } catch (e) {
            technoContainer.innerHTML = '<span class="text-muted text-sm">Erreur de lecture.</span>';
        }
        
        if (typeof lucide !== 'undefined') lucide.createIcons();
    }

    // =======================================================================
    // 6. Gestionnaire global de clics (Délégation d'événements)
    // =======================================================================
    document.addEventListener('click', function(e) {
        
        // --- SUPPRESSION D'UNE LIGNE TECHNOLOGIE (Compatible Ajout et Édition) ---
        const removeTechnoBtn = e.target.closest('.remove-techno-row');
        if (removeTechnoBtn) {
            e.preventDefault();
            // Trouve le conteneur le plus proche (soit techno-container soit edit-techno-container)
            const container = removeTechnoBtn.closest('.stack-xs');
            if (container && container.querySelectorAll('.techno-row').length > 1) {
                removeTechnoBtn.closest('.techno-row').remove();
            }
            return;
        }

        // --- OUVERTURES DES MODALES SIMPLES ---
        if (e.target.closest('#btn-edit-projet-details')) {
            e.preventDefault(); openModal('edit-projet-modal'); return;
        }
        if (e.target.closest('#btn-add-member') || e.target.closest('#btn-manage-team')) {
            e.preventDefault(); openModal('add-member-modal'); return;
        }
        if (e.target.closest('#btn-add-env')) {
            e.preventDefault(); openModal('add-env-modal'); return;
        }

        // --- OUVERTURE DE LA MODALE "VOIR ENVIRONNEMENT" ---
        const btnViewEnv = e.target.closest('.btn-view-env');
        if (btnViewEnv) {
            e.preventDefault();
            populateViewEnvModal(btnViewEnv);
            openModal('view-env-modal');
            return;
        }

        // --- OUVERTURE DE LA MODALE "MODIFIER ENVIRONNEMENT" ---
        const btnEditEnv = e.target.closest('.btn-edit-env');
        if (btnEditEnv) {
            e.preventDefault();
            
            // 1. Pré-remplir les champs basiques et sélecteurs
            document.getElementById('edit-env-id').value = btnEditEnv.dataset.envId || '';
            document.getElementById('edit-typeEnv').value = btnEditEnv.dataset.envType || 'LOCAL';
            document.getElementById('edit-serveurId').value = btnEditEnv.dataset.envServerId || '';
            document.getElementById('edit-urlFront').value = btnEditEnv.dataset.envUrlFront || '';
            document.getElementById('edit-urlBack').value = btnEditEnv.dataset.envUrlBack || '';
            document.getElementById('edit-dbName').value = btnEditEnv.dataset.envDb || '';

            // 2. Pré-remplir la liste dynamique des technologies
            const technoContainer = document.getElementById('edit-techno-container');
            if (technoContainer) {
                technoContainer.innerHTML = ''; // Nettoyer les lignes précédentes
                
                try {
                    const technos = JSON.parse(btnEditEnv.dataset.envTechnos || '[]');
                    if (technos.length > 0) {
                        technos.forEach(t => {
                            appendTechnoRowToEdit(t.id, t.version);
                        });
                    } else {
                        // S'il n'y a aucune technologie, insérer une ligne vide
                        window.addEditTechnoRow();
                    }
                } catch (err) {
                    window.addEditTechnoRow();
                }
            }

            if (typeof lucide !== 'undefined') lucide.createIcons();
            openModal('edit-env-modal');
            return;
        }

        // --- OUVERTURE DE LA MODALE "SUPPRIMER ENVIRONNEMENT" ---
        const btnDeleteEnv = e.target.closest('.btn-delete-env');
        if (btnDeleteEnv) {
            e.preventDefault();
            const idInput = document.getElementById('delete-env-id');
            if (idInput) idInput.value = btnDeleteEnv.dataset.envId;
            openModal('delete-env-modal');
            return;
        }

        // --- OUVERTURE DE LA MODALE "RETIRER MEMBRE" ---
        const removeMemberBtn = e.target.closest('.remove-member-btn');
        if (removeMemberBtn) {
            e.preventDefault();
            const idInput = document.getElementById('remove-member-id');
            const nameEl = document.getElementById('remove-member-name');
            if (idInput) idInput.value = removeMemberBtn.dataset.memberId;
            if (nameEl) nameEl.textContent = removeMemberBtn.dataset.memberName;
            openModal('remove-member-modal');
            return;
        }

        // --- FERMETURE DES MODALES ---
        if (e.target.closest('.modal-close') || e.target.closest('.btn-secondary[id^="cancel-"]')) {
            e.preventDefault();
            closeModal(e.target.closest('.modal-overlay'));
            return;
        }

        // Clic en dehors de la carte (sur le fond gris)
        if (e.target.matches('.modal-overlay.is-visible')) {
            closeModal(e.target);
        }
    });
});