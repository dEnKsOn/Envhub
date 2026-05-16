// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initClientsLocal() {
  const searchInput = document.getElementById('search-input');
  const searchForm = document.getElementById('search-form');
  const tableBody = document.getElementById('clients-table-body');
  
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
if (!window.clientsJsInitialized) {
  window.clientsJsInitialized = true;

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

  function openClientModal(mode = 'create', client = {}) {
    const modal = document.getElementById('client-modal');
    const formAction = document.getElementById('client-form-action');
    const modalTitle = document.getElementById('client-modal-title');
    const modalSubtitle = document.getElementById('client-modal-subtitle');
    const modalIcon = document.getElementById('client-modal-icon');
    const modalSubmit = document.getElementById('client-modal-submit');
    
    if (!modal) return;
    
    openModal(modal);
    if (formAction) formAction.value = mode === 'edit' ? 'update' : 'create';

    const clientIdInput = document.getElementById('clientId');
    const entrepriseInput = document.getElementById('entreprise');
    const nomInput = document.getElementById('nom');
    const prenomInput = document.getElementById('prenom');

    if (mode === 'edit') {
      if (modalTitle) modalTitle.textContent = 'Modifier le client';
      if (modalSubtitle) modalSubtitle.textContent = 'Mettez à jour les informations de ce client.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'briefcase');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Mettre à jour';
      
      if (clientIdInput) clientIdInput.value = client.id || '';
      if (entrepriseInput) entrepriseInput.value = client.entreprise || '';
      if (nomInput) nomInput.value = client.nom || '';
      if (prenomInput) prenomInput.value = client.prenom && client.prenom !== 'undefined' ? client.prenom : '';
    } else {
      if (modalTitle) modalTitle.textContent = 'Ajouter un client';
      if (modalSubtitle) modalSubtitle.textContent = 'Veuillez renseigner les informations du client.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'briefcase');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Enregistrer le client';
      
      if (clientIdInput) clientIdInput.value = '';
      if (entrepriseInput) entrepriseInput.value = '';
      if (nomInput) nomInput.value = '';
      if (prenomInput) prenomInput.value = '';
    }
  }

  function openDeleteModal(clientId, clientName) {
    const deleteModal = document.getElementById('delete-client-modal');
    const deleteIdInput = document.getElementById('delete-client-id');
    const deleteName = document.getElementById('delete-client-name');
    
    if (!deleteModal) return;
    if (deleteIdInput) deleteIdInput.value = clientId;
    if (deleteName) deleteName.textContent = clientName;
    openModal(deleteModal);
  }

  document.addEventListener('click', function(e) {
    const btnAdd = e.target.closest('#btn-add-client') || e.target.closest('.open-client-modal');
    if (btnAdd) {
      e.preventDefault();
      openClientModal('create');
      return;
    }

    const btnEdit = e.target.closest('.edit-client-btn');
    if (btnEdit) {
      e.preventDefault();
      openClientModal('edit', {
        id: btnEdit.dataset.clientId,
        entreprise: btnEdit.dataset.entreprise,
        nom: btnEdit.dataset.nom,
        prenom: btnEdit.dataset.prenom
      });
      return;
    }

    const btnDelete = e.target.closest('.delete-client-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.clientId, btnDelete.dataset.clientName);
      return;
    }

    if (e.target.closest('#close-client-modal') || e.target.closest('#cancel-client-modal') || e.target.closest('#client-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('client-modal'));
      return;
    }

    if (e.target.closest('#delete-close-client-modal') || e.target.closest('#delete-client-cancel') || e.target.closest('#delete-client-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-client-modal'));
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