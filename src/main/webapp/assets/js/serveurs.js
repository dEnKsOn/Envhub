// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initServeursLocal() {
  const searchInput = document.getElementById('search-input');
  const searchForm = document.getElementById('search-form');
  const tableBody = document.getElementById('serveurs-table-body');
  
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

      const noResultsMessage = document.getElementById('no-results-message');
      const noResultsQuery = document.getElementById('no-results-query');
      if (noResultsMessage && noResultsQuery) {
        if (!hasVisibleRows && term.trim() !== '') {
          noResultsQuery.textContent = e.target.value;
          noResultsMessage.style.display = 'flex';
        } else {
          noResultsMessage.style.display = 'none';
        }
      }
    });

    if (searchForm) {
      searchForm.addEventListener('submit', function(e) {
        e.preventDefault();
      });
    }
  }
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
    const formAction = document.getElementById('serveur-form-action');
    const modalTitle = document.getElementById('serveur-modal-title');
    const modalSubtitle = document.getElementById('serveur-modal-subtitle');
    const modalIcon = document.getElementById('serveur-modal-icon');
    const modalSubmit = document.getElementById('serveur-modal-submit');
    
    if (!modal) return;
    
    openModal(modal);
    if (formAction) formAction.value = mode === 'edit' ? 'update' : 'create';

    const serveurIdInput = document.getElementById('serveurId');
    const adressIPInput = document.getElementById('adressIP');
    const osInput = document.getElementById('os');

    if (mode === 'edit') {
      if (modalTitle) modalTitle.textContent = 'Modifier le serveur';
      if (modalSubtitle) modalSubtitle.textContent = 'Mettez à jour les informations de ce serveur.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'server');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Mettre à jour';
      
      if (serveurIdInput) serveurIdInput.value = serveur.id || '';
      if (adressIPInput) adressIPInput.value = serveur.adressIP || '';
      if (osInput) osInput.value = serveur.os || '';
    } else {
      if (modalTitle) modalTitle.textContent = 'Ajouter un serveur';
      if (modalSubtitle) modalSubtitle.textContent = 'Veuillez renseigner les informations du serveur.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'server');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Enregistrer le serveur';
      
      if (serveurIdInput) serveurIdInput.value = '';
      if (adressIPInput) adressIPInput.value = '';
      if (osInput) osInput.value = '';
    }
  }

  function openDeleteModal(serveurId, serveurIp) {
    const deleteModal = document.getElementById('delete-serveur-modal');
    const deleteIdInput = document.getElementById('delete-serveur-id');
    const deleteIp = document.getElementById('delete-serveur-ip');
    
    if (!deleteModal) return;
    if (deleteIdInput) deleteIdInput.value = serveurId;
    if (deleteIp) deleteIp.textContent = serveurIp;
    openModal(deleteModal);
  }

  document.addEventListener('click', function(e) {
    const btnAdd = e.target.closest('#btn-add-serveur') || e.target.closest('.open-serveur-modal');
    if (btnAdd) {
      e.preventDefault();
      openServeurModal('create');
      return;
    }

    const btnEdit = e.target.closest('.edit-serveur-btn');
    if (btnEdit) {
      e.preventDefault();
      openServeurModal('edit', {
        id: btnEdit.dataset.serveurId,
        adressIP: btnEdit.dataset.adressip,
        os: btnEdit.dataset.os
      });
      return;
    }

    const btnDelete = e.target.closest('.delete-serveur-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.serveurId, btnDelete.dataset.serveurIp);
      return;
    }

    if (e.target.closest('#close-serveur-modal') || e.target.closest('#cancel-serveur-modal') || e.target.closest('#serveur-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('serveur-modal'));
      return;
    }

    if (e.target.closest('#delete-close-serveur-modal') || e.target.closest('#delete-serveur-cancel') || e.target.closest('#delete-serveur-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-serveur-modal'));
      return;
    }

    if (e.target.matches('.modal-overlay')) {
      closeModal(e.target);
    }
  });
}

// Rafraîchir les icônes
if (typeof window.refreshLucideIcons === 'function') {
  window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
  lucide.createIcons();
}
