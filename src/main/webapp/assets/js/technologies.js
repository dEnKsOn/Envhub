// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initTechnosLocal() {
  const searchInput = document.getElementById('search-input');
  const searchForm = document.getElementById('search-form');
  const tableBody = document.getElementById('technos-table-body');
  
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
if (!window.technosJsInitialized) {
  window.technosJsInitialized = true;

  function openModal(modal) {
    if (modal) {
      modal.classList.add('is-visible');
      modal.classList.remove('is-hidden');
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

  function openTechnoModal(mode = 'create', techno = {}) {
    const modal = document.getElementById('techno-modal');
    const formAction = document.getElementById('techno-form-action');
    const modalTitle = document.getElementById('techno-modal-title');
    const modalSubtitle = document.getElementById('techno-modal-subtitle');
    const modalIcon = document.getElementById('techno-modal-icon');
    const modalSubmit = document.getElementById('techno-modal-submit');
    
    if (!modal) return;
    
    openModal(modal);
    if (formAction) formAction.value = mode === 'edit' ? 'update' : 'create';

    const technoIdInput = document.getElementById('technoId');
    const nomTechnoInput = document.getElementById('nomTechno');
    const typeTechnoSelect = document.getElementById('typeTechno');

    if (mode === 'edit') {
      if (modalTitle) modalTitle.textContent = 'Modifier la technologie';
      if (modalSubtitle) modalSubtitle.textContent = 'Mettez à jour les informations de cette technologie.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'code');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Mettre à jour';
      
      if (technoIdInput) technoIdInput.value = techno.id || '';
      if (nomTechnoInput) nomTechnoInput.value = techno.nom || '';
      if (typeTechnoSelect) typeTechnoSelect.value = techno.type || '';
    } else {
      if (modalTitle) modalTitle.textContent = 'Ajouter une technologie';
      if (modalSubtitle) modalSubtitle.textContent = 'Veuillez renseigner les informations de la technologie.';
      if (modalIcon) {
          modalIcon.setAttribute('data-lucide', 'code');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (modalSubmit) modalSubmit.textContent = 'Enregistrer la technologie';
      
      if (technoIdInput) technoIdInput.value = '';
      if (nomTechnoInput) nomTechnoInput.value = '';
      if (typeTechnoSelect) typeTechnoSelect.value = '';
    }
  }

  function openDeleteModal(technoId, technoNom) {
    const deleteModal = document.getElementById('delete-techno-modal');
    const deleteIdInput = document.getElementById('delete-techno-id');
    const deleteNom = document.getElementById('delete-techno-nom');
    
    if (!deleteModal) return;
    if (deleteIdInput) deleteIdInput.value = technoId;
    if (deleteNom) deleteNom.textContent = technoNom;
    openModal(deleteModal);
  }

  document.addEventListener('click', function(e) {
    const btnAdd = e.target.closest('#btn-add-techno') || e.target.closest('.open-techno-modal');
    if (btnAdd) {
      e.preventDefault();
      openTechnoModal('create');
      return;
    }

    const btnEdit = e.target.closest('.edit-techno-btn');
    if (btnEdit) {
      e.preventDefault();
      openTechnoModal('edit', {
        id: btnEdit.dataset.technoId,
        nom: btnEdit.dataset.nom,
        type: btnEdit.dataset.type
      });
      return;
    }

    const btnDelete = e.target.closest('.delete-techno-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.technoId, btnDelete.dataset.technoNom);
      return;
    }

    if (e.target.closest('#close-techno-modal') || e.target.closest('#cancel-techno-modal') || e.target.closest('#techno-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('techno-modal'));
      return;
    }

    if (e.target.closest('#delete-close-techno-modal') || e.target.closest('#delete-techno-cancel') || e.target.closest('#delete-techno-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-techno-modal'));
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