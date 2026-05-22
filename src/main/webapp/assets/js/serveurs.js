document.addEventListener('DOMContentLoaded', function() {
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
        // Bouton Ajouter
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

    if (typeof lucide !== 'undefined') lucide.createIcons();
});