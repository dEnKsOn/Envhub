document.addEventListener('DOMContentLoaded', function() {
    
    // 1. Initialisation de Lucide Icons
    if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // ==========================================
    // LOGIQUE DE LA MODALE "DÉTAILS ENVIRONNEMENT" (Identique à la vue DEV)
    // ==========================================
    const modal = document.getElementById('view-env-modal');

    function populateViewEnvModal(btn) {
        document.getElementById('view-env-type').textContent = btn.dataset.envType;
        document.getElementById('view-env-db').textContent = btn.dataset.envDb || 'Non spécifiée';
        
        // Nouveautés par rapport à dev-projet-details : Injecter le Projet et le Client
        document.getElementById('view-env-projet').textContent = btn.dataset.envProjet || 'Non défini';
        document.getElementById('view-env-client').textContent = btn.dataset.envClient || 'Non défini';
        
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
                    badge.innerHTML = `${t.nom} ${t.version && t.version !== 'null' ? '<strong>v' + t.version + '</strong>' : ''}`;
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
    
    document.addEventListener('click', function(e) {
        // Bouton pour Ouvrir
        const btnView = e.target.closest('.btn-view-env');
        if (btnView) {
            e.preventDefault();
            populateViewEnvModal(btnView);
            modal.classList.remove('is-hidden');
            modal.classList.add('is-visible');
        }

        // Bouton pour Fermer (croix, bouton "Fermer" ou clic hors de la modale)
        if (e.target.closest('.modal-close') || e.target.closest('.btn-secondary.modal-close') || e.target === modal) {
            if (modal.classList.contains('is-visible')) {
                e.preventDefault();
                modal.classList.remove('is-visible');
                modal.classList.add('is-hidden');
            }
        }
    });

    // ==========================================
    // LOGIQUE DE FILTRAGE DES DONNÉES (Côté Client)
    // ==========================================
    const selectClient = document.getElementById('filter-client');
    const selectStatus = document.getElementById('filter-status');
    const selectTech = document.getElementById('filter-tech');
    const btnReset = document.getElementById('btn-reset-filters');
    const rows = document.querySelectorAll('.env-row');

    function filterTable() {
        const clientVal = selectClient ? selectClient.value : '';
        const statusVal = selectStatus ? selectStatus.value : '';
        const techVal = selectTech ? selectTech.value.toLowerCase() : '';

        rows.forEach(row => {
            const rowClient = row.getAttribute('data-client');
            const rowStatus = row.getAttribute('data-status');
            // On récupère le texte combiné des cellules pour chercher la technologie
            const techCellText = row.querySelector('.tech-cell').textContent.toLowerCase();
            
            let matchClient = clientVal === '' || rowClient === clientVal;
            let matchStatus = statusVal === '' || rowStatus === statusVal;
            let matchTech = techVal === '' || techCellText.includes(techVal); 
            
            if (matchClient && matchStatus && matchTech) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    }

    if (selectClient) selectClient.addEventListener('change', filterTable);
    if (selectStatus) selectStatus.addEventListener('change', filterTable);
    if (selectTech) selectTech.addEventListener('change', filterTable);

    if (btnReset) {
        btnReset.addEventListener('click', () => {
            if (selectClient) selectClient.value = '';
            if (selectStatus) selectStatus.value = '';
            if (selectTech) selectTech.value = '';
            filterTable();
        });
    }
});